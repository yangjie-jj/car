package com.sxt.bussi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.bussi.form.BusChecksForm;
import com.sxt.bussi.mapper.BusChecksMapper;
import com.sxt.bussi.mapper.BusRentsMapper;
import com.sxt.bussi.mapper.BussiBusCarsMapper;
import com.sxt.bussi.query.BusCarsQuery;
import com.sxt.bussi.query.BusRentsQuery;
import com.sxt.bussi.service.IBusRentsService;
import com.sxt.bussi.vo.BusCarsVO;
import com.sxt.bussi.vo.BusRentsVO;
import com.sxt.common.CodeMsg;
import com.sxt.common.Constant;
import com.sxt.common.Result;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.impl.BaseServiceImpl;
import com.sxt.common.exception.BussiException;
import com.sxt.common.util.WebUtil;

import cn.hutool.core.date.DateUtil;

@Service
public class BusRentsServiceImpl extends BaseServiceImpl implements IBusRentsService {
	
	@Autowired
	private BusRentsMapper busRentsMapper;
	
	@Autowired
	private BusChecksMapper busChecksMapper;
	
	@Autowired
	private BussiBusCarsMapper bussiBusCarsMapper;

	public BusRentsServiceImpl(BusRentsMapper busRentsMapper) {
		super(busRentsMapper);
	}

	@Override
	@Transactional
	public Result returnCar(BusChecksForm form) {
		/**
		 *  1.创建一个检查单
		 *  2.修改车辆状态  :  已出租 改成 为出租
		 *  3.出租单状态 从 未还车  已还车
		 */
		//1. 判断出租单是否存在  
		BusRentsQuery  query = new BusRentsQuery();
		query.setRentNo(form.getRentNo());
		List<BaseVO> vo = busRentsMapper.selectList(query);
		//判断出租单是否有效
		if(vo == null || vo.isEmpty()) {
			return new Result(CodeMsg.BUSSI_RENT_NO_NOT_EXIST_ERROR);
		}
		//创建检查单
		form.setCheckNo("CHECK"+DateUtil.format(new Date(), Constant.YYYYMMDDHHMMSSSSS));
		form.setUserId(WebUtil.getCurrentUser().getId());
		form.setCreateTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		busChecksMapper.insert(form);
		// 修改出租单状态
		int m = busRentsMapper.updateFlag(form.getRentNo());
		if(m == 0) {
			throw new BussiException(CodeMsg.BUSSI_RENT_NO_FLAG_ERROR.CODE, CodeMsg.BUSSI_RENT_NO_FLAG_ERROR.MSG);
		}
		//修改车辆状态
		BusCarsQuery carQuery = new BusCarsQuery();
		BusRentsVO rentVO = (BusRentsVO) vo.get(0);
		carQuery.setCarNum(rentVO.getCarNum());
		List<BaseVO> data = bussiBusCarsMapper.selectList(carQuery);
		if(data == null || data.isEmpty()) {
			throw new BussiException(CodeMsg.BUSSI_RENT_CAR_NO_ERROR.CODE, CodeMsg.BUSSI_RENT_CAR_NO_ERROR.MSG);
		}
		BusCarsVO carVO = (BusCarsVO) data.get(0);
		m = bussiBusCarsMapper.updateCarState(carVO.getId(), carVO.getVersion(), Constant.UN_RENT);
		if(m == 0) {
			throw new BussiException(CodeMsg.BUSSI_RENT_CAR_STATE_ERROR.CODE, CodeMsg.BUSSI_RENT_CAR_STATE_ERROR.MSG);
		}
		return new Result();
	}

}

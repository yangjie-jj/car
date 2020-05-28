package com.sxt.bussi.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.bussi.form.BusCarsForm;
import com.sxt.bussi.form.BusRentsForm;
import com.sxt.bussi.mapper.BusRentsMapper;
import com.sxt.bussi.mapper.BussiBusCarsMapper;
import com.sxt.bussi.mapper.BussiCustomerMapper;
import com.sxt.bussi.query.BusCarsQuery;
import com.sxt.bussi.query.BussiCustomerQuery;
import com.sxt.bussi.service.IBussiBusCarsService;
import com.sxt.bussi.vo.BusCarsVO;
import com.sxt.common.CodeMsg;
import com.sxt.common.Constant;
import com.sxt.common.Result;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.impl.BaseServiceImpl;
import com.sxt.common.util.WebUtil;

import cn.hutool.core.date.DateUtil;

@Service
public class BussiBusCarsServiceImpl extends BaseServiceImpl implements IBussiBusCarsService {

	@Autowired
	private BussiBusCarsMapper bussiBusCarsMapper;
	
	@Autowired
	private BusRentsMapper busRentsMapper;
	
	@Autowired
	private BussiCustomerMapper bussiCustomerMapper;
	
	public BussiBusCarsServiceImpl(BussiBusCarsMapper bussiBusCarsMapper) {
		super(bussiBusCarsMapper);
	}


	@Override
	public Result createNewCars(BusCarsForm form) {
		// 校验车牌号
		BusCarsQuery query = new BusCarsQuery();
		query.setCarNum(form.getCarNum());
		//根据车牌号查询车辆信息
		List<BaseVO> data = bussiBusCarsMapper.selectList(query);
		if(data != null && !data.isEmpty()) {
			return new Result(CodeMsg.BUSSI_CAR_NUM_EXIST_ERROR);
		}
		form.setIsRent(Constant.UN_RENT);
		form.setVersion(1);
		return super.add(form);
	}


	@Override
	public Result updateCarInfo(BusCarsForm form) {
		// 校验车牌号
		// 校验车牌号
		BusCarsQuery query = new BusCarsQuery();
		query.setCarNum(form.getCarNum());
		// 根据车牌号查询车辆信息
		List<BaseVO> data = bussiBusCarsMapper.selectList(query);
		if (data != null && !data.isEmpty()) {
			BusCarsVO busCarVo = (BusCarsVO) data.get(0);
			if(busCarVo.getId() != form.getId() ) {
				return new Result(CodeMsg.BUSSI_CAR_NUM_EXIST_ERROR);
			}
		}
		//根据ID 查询记录
		BusCarsVO busCarVo = (BusCarsVO) bussiBusCarsMapper.selectOne(form.getId());
		//保存数据 删除之前的图片
		Result rs = super.update(form);
		// 删除之前的图片
		String imgPath = busCarVo.getImg();
		String realPath = WebUtil.getServletContext().getRealPath(imgPath);
		System.out.println(realPath);
		File file = new File(realPath);
		//若文件存在就删除
		if(file.exists()) {
			file.delete();
		}
		return rs;
	}

	
	@Override
	@Transactional
	public Result rentCar(BusRentsForm form) {
		/**
		 *  校验客户是否存在
		 */
		String idCard = form.getIdCard();
		BussiCustomerQuery query = new BussiCustomerQuery();
		query.setIdCard(idCard);
		List<BaseVO> data = bussiCustomerMapper.selectList(query);
		if(data == null || data.isEmpty()) {
			return new Result(CodeMsg.BUSSI_CAR_IDCARD_ERROR);
		}
		
		/**
		 * 	1. 修改当前车辆的状态 :  未出租 改成 已出租
		 *  2. 新增1条数租车记录
		 */
		BusCarsVO busCarsVO = (BusCarsVO) bussiBusCarsMapper.selectOne(form.getCarId());
		if(busCarsVO.getIsRent() == Constant.RENT_ED) {
			return new Result(CodeMsg.BUSSI_CAR_RENT_ED_ERROR);
		}
		// 修改车辆状态
		int m = bussiBusCarsMapper.updateCarState(busCarsVO.getId(),busCarsVO.getVersion(),Constant.RENT_ED);
		if(m == 0) {
			return new Result(CodeMsg.BUSSI_CAR_STATE_ERROR);
		}
		/**
		 *  计算价格
		 */
		String beginTime = form.getBeginTime();
		String returnTime = form.getReturnTime();
		
		long days = DateUtil.betweenDay(DateUtil.parse(beginTime, Constant.YYYY_MM_DD_HH_MM_SS), DateUtil.parse(returnTime, Constant.YYYY_MM_DD_HH_MM_SS), true);
		long price = days * busCarsVO.getRentPrice();
		form.setPrice(Integer.parseInt(price+""));
		form.setRentNo("RENT"+DateUtil.format(new Date(), Constant.YYYYMMDDHHMMSSSSS)+busCarsVO.getCarNum());
		/**
		 *  设置状态
		 */
		form.setFlag(Constant.RENT_FLAG_NOT_RETURNED);
		
		/**
		 * 	设置user_id
		 */
		form.setUserId(WebUtil.getCurrentUser().getId());
		/**
		 *  设置 创建时间
		 */
		form.setCreateTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		busRentsMapper.insert(form);
		return new Result();
	}

}

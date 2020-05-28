package com.sxt.bussi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.bussi.form.BussiCustomerForm;
import com.sxt.bussi.mapper.BussiCustomerMapper;
import com.sxt.bussi.query.BussiCustomerQuery;
import com.sxt.bussi.service.IBussiCustomerService;
import com.sxt.bussi.vo.BussiCustomerVO;
import com.sxt.common.CodeMsg;
import com.sxt.common.Constant;
import com.sxt.common.Result;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.impl.BaseServiceImpl;

import cn.hutool.core.date.DateUtil;

@Service
public class BussiCustomerServiceImpl extends BaseServiceImpl implements IBussiCustomerService {
	
	@Autowired
	private BussiCustomerMapper bussiCustomerMapper; 
	
	public BussiCustomerServiceImpl(BussiCustomerMapper baseMapper) {
		super(baseMapper);
	}

	@Override
	public Result createNewCustomer(BussiCustomerForm form) {
		/**
		 *  业务数据校验
		 */
		//1 . 身份证号
		BussiCustomerQuery  query = new BussiCustomerQuery();
		query.setIdCard(form.getIdCard());
		// 根据身份证号查询客户
		List<BaseVO> data = bussiCustomerMapper.selectList(query);
		if(data != null && !data.isEmpty()) {
			return new Result(CodeMsg.BUSSI_CUSTOMER_ID_CARD_EXIST_ERROR);
		}
		// 2. 手机号
		query = new BussiCustomerQuery();
		query.setPhone(form.getPhone());
		// 根据手机号查询客户
		data = bussiCustomerMapper.selectList(query);
		if(data != null && !data.isEmpty()) {
			return new Result(CodeMsg.BUSSI_CUSTOMER_PHONE_EXIST_ERROR);
		}
		form.setCreateTime(DateUtil.format(new Date(), Constant.YYYY_MM_DD_HH_MM_SS));
		return 	super.add(form);
	}

	@Override
	public Result updateCustomer(BussiCustomerForm form) {
		// 1 . 身份证号
		BussiCustomerQuery query = new BussiCustomerQuery();
		query.setIdCard(form.getIdCard());
		// 根据身份证号查询客户
		List<BaseVO> data = bussiCustomerMapper.selectList(query);
		//如果身份证号存在 且 不是当前记录  则说明新的身份证号 已经被使用了
		if (data != null && !data.isEmpty() ) {
			BussiCustomerVO baseVO = (BussiCustomerVO)data.get(0);
			if(baseVO.getId() != form.getId()) {
				return new Result(CodeMsg.BUSSI_CUSTOMER_ID_CARD_EXIST_ERROR);
			}
		}
		// 2. 手机号
		query = new BussiCustomerQuery();
		query.setPhone(form.getPhone());
		// 根据手机号查询客户
		data = bussiCustomerMapper.selectList(query);
		if (data != null && !data.isEmpty()) {
			BussiCustomerVO baseVO = (BussiCustomerVO)data.get(0);
			if(baseVO.getId() != form.getId()) {
				return new Result(CodeMsg.BUSSI_CUSTOMER_PHONE_EXIST_ERROR);
			}
			
		}
		return super.update(form);
	}
	

}

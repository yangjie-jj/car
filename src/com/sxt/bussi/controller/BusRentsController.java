package com.sxt.bussi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.bussi.form.BusChecksForm;
import com.sxt.bussi.query.BusRentsQuery;
import com.sxt.bussi.service.IBusRentsService;
import com.sxt.common.Result;
import com.sxt.common.validator.ValidatorUtil;

@RestController
@RequestMapping("/bussi/rent")
public class BusRentsController {
	
	@Autowired
	private IBusRentsService busRentsService;
	
	
	
	@RequestMapping("/list.do")
	public Object list(BusRentsQuery query) {
		return busRentsService.queryPage(query);
	}
	
	
	
	@RequestMapping("/returnCar.do")
	public Object returnCar(BusChecksForm form) {
		//数据校验
		ValidatorUtil.validator(form);
		Result rs = busRentsService.returnCar(form);
		return rs;
	}

}

package com.sxt.bussi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.bussi.query.BusChecksQuery;
import com.sxt.bussi.service.IBusChecksService;

@RestController
@RequestMapping("/bussi/check")
public class BusChecksController {
	
	@Autowired
	private IBusChecksService busChecksService;

	
	@RequestMapping("/list.do")
	public Object list(BusChecksQuery query) {
		return busChecksService.queryPage(query);
	}
}

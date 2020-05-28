package com.sxt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sxt.sys.service.IStatisService;

/**
 * @ClassName: StatisticsController 
 * @Description: 统计分析
 * @author: Mr.T
 * @date: 2019年12月6日 下午2:32:03
 */
@RestController
@RequestMapping("/sys/statis")
public class StatisticsController {
	@Autowired
	private IStatisService statisService;
	
	@RequestMapping("/pie.do")
	public Object pie() {
		return statisService.pie();
	}
	
	
	@RequestMapping("/line.do")
	public Object line(Integer year) {
		return statisService.line(year);
	}
	
	
	@RequestMapping("/bar.do")
	public Object bar(Integer year) {
		return statisService.bar(year);
	}

}

package com.sxt.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hutool.core.date.DateUtil;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/index.do")
	public String index() {
		return "/index.jsp";
	}
	/**
	 * @Title: userList
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午5:23:18 
	 * @Description: 用户列表
	 * @return
	 * @return: String
	 */
	@RequestMapping("/sys/userList.do")
	public String userList() {
		return "/sys/user/list.jsp";
	}
	
	@RequestMapping("/bussi/custList.do")
	public String custList() {
		return "/bussi/customer/list.jsp";
	}
	
	@RequestMapping("/bussi/carList.do")
	public String carList() {
		return "/bussi/car/list.jsp";
	}
	
	@RequestMapping("/bussi/rentList.do")
	public String rentList() {
		return "/bussi/rent/list.jsp";
	}
	
	
	@RequestMapping("/bussi/checkList.do")
	public String checkList() {
		return "/bussi/check/list.jsp";
	}
	
	@RequestMapping("/sys/menuList.do")
	public String menuList() {
		return "/sys/menu/list.jsp";
	}
	
	@RequestMapping("/sys/roleList.do")
	public String roleList() {
		return "/sys/role/list.jsp";
	}
	
	
	@RequestMapping("/statistics/pieList.do")
	public String pieList() {
		return "/statistics/pie.jsp";
	}
	
	@RequestMapping("/statistics/lineList.do")
	public String line(Model model) {
		model.addAttribute("year", DateUtil.thisYear());
		return "/statistics/line.jsp";
	}
	
	@RequestMapping("/statistics/barList.do")
	public String bar(Model model) {
		model.addAttribute("year", DateUtil.thisYear());
		return "/statistics/bar.jsp";
	}
}

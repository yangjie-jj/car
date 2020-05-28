package com.sxt.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.sys.form.SysRolesForm;
import com.sxt.sys.query.SysRolesQuery;
import com.sxt.sys.service.ISysRolesService;

@RestController
@RequestMapping("/sys/role")
public class SysRolesController {
	@Autowired
	private ISysRolesService sysRolesService;
	
	@RequestMapping("/list.do")
	public Object  list(SysRolesQuery query) {
		return sysRolesService.queryPage(query);
	}
	
	
	@RequestMapping("/add.do")
	public Object  add(SysRolesForm form) {
		return sysRolesService.add(form);
	}
	
	@RequestMapping("/update.do")
	public Object  update(SysRolesForm form) {
		return sysRolesService.update(form);
	}
	@RequestMapping("/allRole.do")
	public Object  allRole(SysRolesQuery query) {
		return sysRolesService.queryList(query);
	}
}

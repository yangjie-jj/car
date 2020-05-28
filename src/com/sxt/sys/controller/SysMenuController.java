package com.sxt.sys.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sxt.common.Constant;
import com.sxt.sys.form.SysMenuForm;
import com.sxt.sys.query.SysMenuQuery;
import com.sxt.sys.service.ISysMenusService;

@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
	@Autowired
	private ISysMenusService sysMenusService;
	
	@RequestMapping("/menus.do")
	public Object  menus() {
		return sysMenusService.getUserMenu();
	}
	
	
	@RequestMapping("/allMenus.do")
	public Object  allMenus(SysMenuQuery query) {
		query.setFlag(Constant.MENU_FLAG_VALID);
		return sysMenusService.queryList(query);
	}

	@RequestMapping("/list.do")
	public Object  list(SysMenuQuery query) {
		return sysMenusService.queryPage(query);
	}
	
	
	@RequestMapping("/add.do")
	public Object  add(SysMenuForm form) {
		form.setFlag(Constant.MENU_FLAG_VALID);
		return sysMenusService.add(form);
	}
	
	@RequestMapping("/update.do")
	public Object  update(SysMenuForm form) {
		form.setFlag(Constant.MENU_FLAG_VALID);
		return sysMenusService.update(form);
	}
	
	
	@RequestMapping("/delete.do")
	public Object  delete(@RequestParam("id")List<Integer> id) {
		return sysMenusService.batchDeleteMenu(id);
	}
	
	
	@RequestMapping("/getRoleMenu.do")
	public Object  getRoleMenu(@RequestParam("roleId")Integer roleId) {
		return sysMenusService.queryMenuIdByRole(roleId);
	}
	
	
	@RequestMapping("/setRoleMenu.do")
	public Object  setRoleMenu(@RequestParam("roleId")Integer roleId,@RequestParam("menuId")List<Integer> menuId) {
		return sysMenusService.setRoleMenu(roleId,menuId);
	}
	
	
	
}

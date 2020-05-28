package com.sxt.sys.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxt.common.CodeMsg;
import com.sxt.common.Constant;
import com.sxt.common.Result;
import com.sxt.common.util.WebUtil;
import com.sxt.common.validator.ValidatorUtil;
import com.sxt.sys.form.SysRoleUserForm;
import com.sxt.sys.form.SysUsersForm;
import com.sxt.sys.query.SysUsersQuery;
import com.sxt.sys.service.ISysRoleUserService;
import com.sxt.sys.service.ISysUsersService;

import cn.hutool.core.util.StrUtil;

@RestController
@RequestMapping("/sys/user")
public class SysUsersController {

	@Autowired
	ISysUsersService  sysUsersService;
	
	@Autowired
	ISysRoleUserService  sysRoleUserService;
	
	
	@RequestMapping("/login.do")
	public Object login(String userName,String password,String checkCode) {
		//校验验证码是否一致
		HttpSession session = WebUtil.getSession();
		//获取session中code
		Object code = session.getAttribute(Constant.CHECK_CODE);
		if(code == null) {
			return new Result(CodeMsg.SYS_USER_CHECK_CODE_ERROR);
		}
		//校验验证码码
		if(!StrUtil.equalsIgnoreCase(checkCode, code.toString())) {
			return new Result(CodeMsg.SYS_USER_CHECK_CODE_ERROR);
		}
		// 根据账号密码查询用户
		return sysUsersService.login(userName, password);
	}
	/**
	 * @Title: list
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午5:41:33 
	 * @Description: 用户列表
	 * @param query
	 * @return
	 * @return: Object
	 */
	@RequestMapping("/list.do")
	public Object list(SysUsersQuery query) {
		Result rs = sysUsersService.queryPage(query);
		return rs;
	}
	
	
	@RequestMapping("/add.do")
	public Object add(SysUsersForm sysUsersForm) {
		// 数据校验
		ValidatorUtil.validator(sysUsersForm);
		//新增用户
		return sysUsersService.createNewUser(sysUsersForm);
	}
	/**
	 * @Title: restPwd
	 * @author: Mr.T   
	 * @date: 2019年11月30日 上午10:27:54 
	 * @Description: 重置密码
	 * @param id
	 * @return
	 * @return: Object
	 */
	@RequestMapping("/restPwd.do")
	public Object restPwd(Integer id) {
		return sysUsersService.resetPwd(id);
	}
	@RequestMapping("/setRole.do")
	public Object setRole(SysRoleUserForm form) {
		return sysRoleUserService.setRole(form);
	}
}

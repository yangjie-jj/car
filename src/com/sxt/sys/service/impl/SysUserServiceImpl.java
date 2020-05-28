package com.sxt.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.common.CodeMsg;
import com.sxt.common.Constant;
import com.sxt.common.Result;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.impl.BaseServiceImpl;
import com.sxt.common.util.WebUtil;
import com.sxt.sys.form.SysUsersForm;
import com.sxt.sys.mapper.SysUsersMapper;
import com.sxt.sys.query.SysUsersQuery;
import com.sxt.sys.service.ISysUsersService;
import com.sxt.sys.vo.SysUsersVO;

import cn.hutool.crypto.SecureUtil;

@Service
public class SysUserServiceImpl extends BaseServiceImpl implements ISysUsersService{
	
	@Autowired
	private SysUsersMapper sysUsersMapper;
	
	
	public SysUserServiceImpl(SysUsersMapper sysUsersMapper) {
		super(sysUsersMapper);
	}


	@Override
	public Result login(String loginName, String password) {
		password = SecureUtil.md5(password);
		SysUsersVO sysUsersVO = sysUsersMapper.selectByNameAndPwd(loginName, password);
		if(sysUsersVO == null) {
			return new Result(CodeMsg.SYS_USER_ACCOUNT_ERROR);
		}
		WebUtil.getSession().setAttribute(Constant.CURRENT_USER, sysUsersVO);
		
		return new Result();
	}


	@Override
	public Result createNewUser(SysUsersForm sysUsersForm) {
		//做业务数据校验
		// 校验 用户名唯一
		// 根据用户名查询
		SysUsersQuery query = new SysUsersQuery();
		query.setLoginName(sysUsersForm.getLoginName());
		List<BaseVO> vos = sysUsersMapper.selectList(query);
		// 用户名存在
		if(vos != null && !vos.isEmpty()) {
			return new Result(CodeMsg.SYS_USER_LOGIN_NAME_EXIST_ERROR);
		}
		query = new SysUsersQuery();
		query.setPhone(sysUsersForm.getPhone());
		vos = sysUsersMapper.selectList(query);
		// 用户手机号存在
		if (vos != null && !vos.isEmpty()) {
			return new Result(CodeMsg.SYS_USER_PHONE_EXIST_ERROR);
		}
		// 设置默认密码
		sysUsersForm.setPassword(SecureUtil.md5(Constant.DEFAULT_PASSWORD));
		return super.add(sysUsersForm);
	}


	@Override
	public Result resetPwd(Integer id) {
		SysUsersForm sysUsersForm = new SysUsersForm();
		sysUsersForm.setId(id);
		// 设置默认密码
		sysUsersForm.setPassword(SecureUtil.md5(Constant.DEFAULT_PASSWORD));
		return super.update(sysUsersForm);
	}
	

}

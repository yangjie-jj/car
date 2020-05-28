package com.sxt.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.common.Result;
import com.sxt.common.base.service.impl.BaseServiceImpl;
import com.sxt.sys.form.SysRoleUserForm;
import com.sxt.sys.mapper.SysRoleUserMapper;
import com.sxt.sys.service.ISysRoleUserService;

@Service
public class SysRoleUserServiceImpl extends BaseServiceImpl implements ISysRoleUserService {

	@Autowired
	private SysRoleUserMapper  sysRoleUserMapper;
	
	public SysRoleUserServiceImpl( SysRoleUserMapper  sysRoleUserMapper) {
		super(sysRoleUserMapper);
	}

	@Override
	@Transactional
	public Result setRole(SysRoleUserForm form) {
		sysRoleUserMapper.delete(form.getUserId());
		return super.add(form);
	}

	
}

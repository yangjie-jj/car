package com.sxt.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.common.base.service.impl.BaseServiceImpl;
import com.sxt.sys.mapper.SysRolesMapper;
import com.sxt.sys.service.ISysRolesService;

@Service
public class SysRolesServiceImpl extends BaseServiceImpl implements ISysRolesService {
	@Autowired
	private SysRolesMapper sysRolesMapper;
	
	public SysRolesServiceImpl(SysRolesMapper sysRolesMapper) {
		super(sysRolesMapper);
	}

}

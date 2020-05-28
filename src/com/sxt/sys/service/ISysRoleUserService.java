package com.sxt.sys.service;


import com.sxt.common.Result;
import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.IBaseService;
import com.sxt.sys.form.SysRoleUserForm;

public interface ISysRoleUserService extends IBaseService<BaseForm, BaseQuery, BaseVO> {
	/**
	 * @Title: setRole
	 * @author: Mr.T   
	 * @date: 2019年12月4日 下午4:45:56 
	 * @Description: 设置用户角色
	 * @param form
	 * @return
	 * @return: Result
	 */
	Result setRole(SysRoleUserForm form);

}

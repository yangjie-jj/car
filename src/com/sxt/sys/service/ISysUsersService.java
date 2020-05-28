package com.sxt.sys.service;

import com.sxt.common.Result;
import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.IBaseService;
import com.sxt.sys.form.SysUsersForm;

public interface ISysUsersService extends IBaseService<BaseForm,BaseQuery,BaseVO> {

	
	/**
	 * @Title: login
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午4:22:47 
	 * @Description: 用户登录
	 * @param loginName
	 * @param password
	 * @return
	 * @return: Result
	 */
	public Result login(String loginName,String password);
	
	
	/**
	 * @Title: createNewUser
	 * @author: Mr.T   
	 * @date: 2019年11月30日 上午9:46:01 
	 * @Description: 创建新用户
	 * @param sysUsersForm
	 * @return
	 * @return: Result
	 */
	public Result createNewUser(SysUsersForm sysUsersForm);
	
	/**
	 * @Title: resetPwd
	 * @author: Mr.T   
	 * @date: 2019年11月30日 上午10:28:29 
	 * @Description: 重置用户的密码
	 * @param id
	 * @return
	 * @return: Result
	 */
	public Result resetPwd(Integer  id);

}

package com.sxt.sys.mapper;

import org.apache.ibatis.annotations.Param;

import com.sxt.common.base.mapper.BaseMapper;
import com.sxt.sys.vo.SysUsersVO;

/**
 * @ClassName: SysUsersMapper 
 * @Description: sys_users 表操作接口
 * @author: Mr.T
 * @date: 2019年11月29日 上午10:35:22
 */
public interface SysUsersMapper extends BaseMapper{
	
	/**
	 * @Title: selectByNameAndPwd
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午4:24:03 
	 * @Description: 根据用户名和密码查询用户
	 * @param loginName
	 * @param password
	 * @return
	 * @return: SysUsersVO
	 */
	public SysUsersVO selectByNameAndPwd(@Param("loginName")String loginName,@Param("password")String password);

}

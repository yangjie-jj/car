package com.sxt.sys.service;

import java.util.List;

import com.sxt.common.Result;
import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.IBaseService;

public interface ISysMenusService extends IBaseService<BaseForm, BaseQuery, BaseVO> {

	
	/**
	 * @Title: getUserMenu
	 * @author: Mr.T   
	 * @date: 2019年12月3日 下午3:21:56 
	 * @Description: 获取当前登录用户的菜单
	 * @return
	 * @return: Result
	 */
	public Result getUserMenu();
	
	/**
	 * @Title: batchDeleteMenu
	 * @author: Mr.T   
	 * @date: 2019年12月4日 下午3:32:58 
	 * @Description: 根据ID批量删除菜单
	 * @param id
	 * @return
	 * @return: Result
	 */
	public Result batchDeleteMenu(List<Integer> id);
	/**
	 * @Title: queryMenuIdByRole
	 * @author: Mr.T   
	 * @date: 2019年12月6日 上午10:09:51 
	 * @Description: 根据角色查询菜单ID
	 * @param roleId
	 * @return
	 * @return: Result
	 */
	public Result queryMenuIdByRole(Integer roleId);
	/**
	 * @Title: setRoleMenu
	 * @author: Mr.T   
	 * @date: 2019年12月6日 上午10:45:57 
	 * @Description: 设置角色权限
	 * @param roleId
	 * @param menuId
	 * @return
	 * @return: Result
	 */
	public Result setRoleMenu(Integer roleId, List<Integer> menuId);
}

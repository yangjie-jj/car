package com.sxt.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.common.base.mapper.BaseMapper;
import com.sxt.sys.vo.SysMenuVO;

public interface SysMenusMapper extends BaseMapper {

	int batchDelete(@Param("ids")   List<Integer> id);
   
	/**
	 * @Title: selectMenuId
	 * @author: Mr.T   
	 * @date: 2019年12月6日 上午10:11:47 
	 * @Description: 根据角色查询菜单ID
	 * @param roleId
	 * @return
	 * @return: List<Integer>
	 */
	List<Integer> selectMenuId(@Param("roleId")Integer roleId);
	/**
	 * @Title: deleteRoleMenu
	 * @author: Mr.T   
	 * @date: 2019年12月6日 上午10:48:03 
	 * @Description: 根据角色删除 菜单角色关系记录
	 * @param roleId
	 * @return
	 * @return: Integer
	 */
	Integer deleteRoleMenu(@Param("roleId")Integer roleId);
	/**
	 * @Title: batchMenuRole
	 * @author: Mr.T   
	 * @date: 2019年12月6日 上午10:52:58 
	 * @Description: 批量添加角色菜单关系
	 * @param roleId
	 * @param menuId
	 * @return
	 * @return: Integer
	 */
	Integer batchMenuRole(@Param("roleId")Integer roleId,@Param("menuId")List<Integer> menuId);
	
	
	/**
	 * @Title: selectUserMenu
	 * @author: Mr.T   
	 * @date: 2019年12月6日 上午11:27:59 
	 * @Description: 根据用户查询其菜单
	 * @param userId
	 * @return
	 * @return: List<SysMenuVO>
	 */
	List<SysMenuVO> selectUserMenu(@Param("userId") Integer userId);
}
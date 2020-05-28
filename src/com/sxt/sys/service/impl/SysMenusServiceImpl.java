package com.sxt.sys.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sxt.common.Result;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.service.impl.BaseServiceImpl;
import com.sxt.common.util.WebUtil;
import com.sxt.sys.mapper.SysMenusMapper;
import com.sxt.sys.service.ISysMenusService;
import com.sxt.sys.vo.SysMenuVO;
import com.sxt.sys.vo.SysUsersVO;

@Service
public class SysMenusServiceImpl extends BaseServiceImpl implements ISysMenusService {
	@Autowired
	private SysMenusMapper sysMenusMapper;
	
	public SysMenusServiceImpl(SysMenusMapper sysMenusMapper) {
		super(sysMenusMapper);
	}

	@Override
	public Result getUserMenu() {
		/**
		 * 	1. 获取当前登录用户
		 *  2. 根据用户查询用户角色
		 *  3.根据角色查询菜单  :  用户所有的菜单   : List<SysMenu>
		 *  4.将菜单进行整理 
		 */
		// 获取当前登录用户
		SysUsersVO user = WebUtil.getCurrentUser();
		
		
		List<SysMenuVO> vo = sysMenusMapper.selectUserMenu(user.getId());
		// 返回的菜单
		List<SysMenuVO> menus = new ArrayList<SysMenuVO>();
		// 先找所有的一级菜单
		for (SysMenuVO sysMenuVO : vo) {
			if(sysMenuVO.getParentId() == 0) {
				menus.add(sysMenuVO);
			}
		}
		//for循环所有的一级菜单
		for (SysMenuVO sysMenuVO : menus) {
			Integer id = sysMenuVO.getId();
			List<SysMenuVO> childrens = new ArrayList<SysMenuVO>();
			// 找一级菜单的二级菜单
			for (BaseVO menu : vo) {
				SysMenuVO childMenu = (SysMenuVO) menu;
				Integer parentId = childMenu.getParentId();
				if(id == parentId) {
					childrens.add(childMenu);
				}
			}
			sysMenuVO.setChildren(childrens);
		}
		return new Result(menus);
	}

	@Override
	public Result batchDeleteMenu(List<Integer> id) {
		sysMenusMapper.batchDelete(id);
		return new Result();
	}

	@Override
	public Result queryMenuIdByRole(Integer roleId) {
		List<Integer> data = sysMenusMapper.selectMenuId(roleId);
		String ids = "";
		for (Integer integer : data) {
			ids = ids +integer +",";
		}
		System.out.println(ids);
		return new Result(ids);
	}

	@Override
	@Transactional
	public Result setRoleMenu(Integer roleId, List<Integer> menuId) {
		// 根据角色 删除  绑定的菜单关系记录
		sysMenusMapper.deleteRoleMenu(roleId);
		//插入的新的 角色 菜单关系
		sysMenusMapper.batchMenuRole(roleId, menuId);
		return new Result();
	}

}

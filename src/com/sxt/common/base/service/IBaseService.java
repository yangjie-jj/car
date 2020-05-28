package com.sxt.common.base.service;

import com.sxt.common.Result;

/**
 * @ClassName: IBaseService 
 * @Description: 通用业务操作类
 * @author: Mr.T
 * @date: 2019年11月29日 上午9:53:36
 */
public interface IBaseService<F,Q,V> {
	
	/**
	 * @Title: add
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:54:13 
	 * @Description: 新增业务
	 * @param form
	 * @return
	 * @return: Result
	 */
	public Result add(F form);
	
	/**
	 * @Title: delete
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:54:50 
	 * @Description: 删除的业务
	 * @param id
	 * @return
	 * @return: Result
	 */
	public Result delete(Integer id);
	/**
	 * @Title: queryList
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:55:18 
	 * @Description: 根据条件查询列表
	 * @param query
	 * @return
	 * @return: Result
	 */
	public Result queryList(Q query);
	
	/**
	 * @Title: queryPage
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:56:03 
	 * @Description: 分页查询列表
	 * @param query
	 * @return
	 * @return: Result
	 */
	public Result queryPage(Q query);
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:56:24 
	 * @Description: 修改数据
	 * @param form
	 * @return
	 * @return: Result
	 */
	public Result update(F form);

}

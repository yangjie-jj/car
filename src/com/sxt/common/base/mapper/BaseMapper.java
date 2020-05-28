package com.sxt.common.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.common.base.BaseForm;
import com.sxt.common.base.BaseQuery;
import com.sxt.common.base.BaseVO;

/**
 * @ClassName: BaseMapper 
 * @Description: 通用的基础数据操作Mapper
 * @author: Mr.T
 * @date: 2019年11月29日 上午9:49:17 
 */
public interface BaseMapper {
	
	
	/**
	 * @Title: insert
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:50:27 
	 * @Description: 添加数据
	 * @param form
	 * @return
	 * @return: int
	 */
	public int insert(BaseForm form);
	
	/**
	 * @Title: delete
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:51:00 
	 * @Description: 根据ID 删除数据
	 * @param id
	 * @return: int
	 */
	public int  delete(@Param("id")Integer id);
	
	/**
	 * @Title: selectList
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:51:50 
	 * @Description: 根据条件查询列表
	 * @param query
	 * @return: List<V>
	 */
	public List<BaseVO> selectList(BaseQuery query);
	
	/**
	 * @Title: selectOne
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:52:37 
	 * @Description: 根据ID 查询对象
	 * @param id
	 * @return
	 * @return: V
	 */
	public BaseVO selectOne(@Param("id")Integer id);
	
	/**
	 * @Title: update
	 * @author: Mr.T   
	 * @date: 2019年11月29日 上午9:53:06 
	 * @Description: 修改数据
	 * @param form
	 * @return
	 * @return: int
	 */
	public int update(BaseForm form);
	
}

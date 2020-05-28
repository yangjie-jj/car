package com.sxt.bussi.mapper;

import org.apache.ibatis.annotations.Param;

import com.sxt.common.base.mapper.BaseMapper;


public interface BussiBusCarsMapper extends BaseMapper {
	/**
	 * @Title: updateCarState
	 * @author: Mr.T   
	 * @date: 2019年12月2日 下午5:49:20 
	 * @Description: 修改车辆状态
	 * @param id
	 * @param version
	 * @param rent
	 * @return
	 * @return: int
	 */
	int updateCarState(@Param("id")Integer id,@Param("version") Integer version,@Param("rent")  Integer rent);
   
}
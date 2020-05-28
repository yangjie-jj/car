package com.sxt.bussi.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sxt.common.base.mapper.BaseMapper;


public interface BusChecksMapper extends BaseMapper {
	
	/**
	 * @Title: totalMonthMoney
	 * @author: Mr.T   
	 * @date: 2019年12月6日 下午3:25:22 
	 * @Description: 统计每年 每月的销售额度
	 * @param year
	 * @return
	 * @return: List<Map<String,Object>>
	 */
	public List<Integer> totalMonthMoney(@Param("year") Integer year);
	/**
	 * @Title: selectUserSaleMoney
	 * @author: Mr.T   
	 * @date: 2019年12月6日 下午4:38:30 
	 * @Description: 查询业务员年度的销售额
	 * @param year
	 * @return
	 * @return: List<Map<String,Integer>>
	 */
	public List<Map<String,Integer>> selectUserSaleMoney(@Param("year") Integer year);
    
}
package com.sxt.bussi.mapper;

import org.apache.ibatis.annotations.Param;

import com.sxt.common.base.mapper.BaseMapper;


public interface BusRentsMapper extends BaseMapper {
   
	int updateFlag(@Param("rentNo")String rentNo);
}
package com.sxt.bussi.mapper;

import java.util.List;
import java.util.Map;

import com.sxt.common.base.mapper.BaseMapper;


public interface BussiCustomerMapper extends BaseMapper {
	
	
	public List<Map<String,Object>> selectPie();
   
}
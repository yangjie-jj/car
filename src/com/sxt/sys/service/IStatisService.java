package com.sxt.sys.service;

import com.sxt.common.Result;

/**
 * @ClassName: IStatisService 
 * @Description: 用于统计分析的service
 * @author: Mr.T
 * @date: 2019年12月6日 下午2:34:15
 */
public interface IStatisService {

	/**
	 * @Title: pie
	 * @author: Mr.T   
	 * @date: 2019年12月6日 下午2:34:40 
	 * @Description: 获取饼状图数据    客户分布统计
	 * @return
	 * @return: Result
	 */
	public Result pie();
	
	/**
	 * @Title: line
	 * @author: Mr.T   
	 * @date: 2019年12月6日 下午3:45:18 
	 * @Description: 统计折线图
	 * @param year
	 * @return
	 * @return: Result
	 */
	public Result line(Integer year);
	/**
	 * @Title: bar
	 * @author: Mr.T   
	 * @date: 2019年12月6日 下午4:31:26 
	 * @Description: 柱状图  统计年业务员销售额
	 * @param year
	 * @return
	 * @return: Result
	 */
	public Result bar(Integer year);
}

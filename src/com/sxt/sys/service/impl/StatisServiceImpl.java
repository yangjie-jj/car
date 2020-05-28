package com.sxt.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.bussi.mapper.BusChecksMapper;
import com.sxt.bussi.mapper.BussiCustomerMapper;
import com.sxt.common.Constant;
import com.sxt.common.Result;
import com.sxt.common.base.BaseVO;
import com.sxt.common.base.EchartDataVO;
import com.sxt.sys.mapper.SysUsersMapper;
import com.sxt.sys.query.SysUsersQuery;
import com.sxt.sys.service.IStatisService;
import com.sxt.sys.vo.SysUsersVO;
@Service
public class StatisServiceImpl implements IStatisService {
	@Autowired
	private BussiCustomerMapper  bussiCustomerMapper;
	
	@Autowired
	private BusChecksMapper  busChecksMapper;
	@Autowired
	private SysUsersMapper  sysUsersMapper;

	@Override
	public Result pie() {
		List<Map<String, Object>> data = bussiCustomerMapper.selectPie();
		EchartDataVO echartDataVO = new EchartDataVO();
		echartDataVO.setSeriesData(data);
		//图例数据
		List<String> lendData = new ArrayList<String>();
		for (Map<String, Object> map : data) {
			lendData.add(map.get("name").toString());
		}
		echartDataVO.setLegendData(lendData);
		return new Result(echartDataVO);
	}
	
	
	@Override
	public Result line(Integer year) {
		List<Integer> data = busChecksMapper.totalMonthMoney(year);
		EchartDataVO echartDataVO = new EchartDataVO();
		echartDataVO.setSeriesData(data);
		return new Result(echartDataVO);
	}
	
	@Override
	public Result bar(Integer year) {
		/*
			1. 查询所有的业务员
			2. 假设每个业务员的 年销售额 为   0 
			3. 从查询的结果查找  是否存在销售额  若存在使用查询出的销售额,否则使用  0  
		 */
		//1. 查询所有的业务员
		SysUsersQuery query = new SysUsersQuery();
		query.setType(Constant.USER_SALES);
		//查询出所有的业务员
		List<BaseVO> list = sysUsersMapper.selectList(query);
		// x轴数据容器
		List<String> xaxisData = new ArrayList<String>();
		//图表系列数据容器
		List<Object> seriesData = new ArrayList<Object>();
		// 业务员具体的年度销售额
		List<Map<String, Integer>> data = busChecksMapper.selectUserSaleMoney(year);
		// 将List转化为map  便于搜索
		Map<Integer,Object> map = new HashMap<Integer, Object>();
		for (Map<String, Integer> d : data) {
			Integer id = d.get("id");
			Object money = d.get("money");
			map.put(id, money);
		}
		//循环业务员
		for (BaseVO vo : list) {
			SysUsersVO user = (SysUsersVO) vo;
			//业务员名称
			String realName = user.getRealName();
			//业务员ID
			Integer userId = user.getId();
			xaxisData.add(realName);
			if(map.containsKey(userId)) {
				seriesData.add(map.get(userId)); // money
			}else {
				seriesData.add(0); // 0 
			}
		}
		EchartDataVO echartDataVO = new EchartDataVO();
		echartDataVO.setXaxis(xaxisData);
		echartDataVO.setSeriesData(seriesData);
		return new Result(echartDataVO);
	}

}

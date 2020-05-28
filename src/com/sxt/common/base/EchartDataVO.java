package com.sxt.common.base;

import java.util.List;

/**
 * @ClassName: EchartDataVO 
 * @Description: echart 报表需要的数据对象
 * @author: Mr.T
 * @date: 2019年12月6日 下午2:15:58
 */
public class EchartDataVO {
	
	/**
	 *  x轴的值
	 */
	private  Object  xaxis;
	/**
	 * 	y轴的值
	 */
	private Object yaxis;
	/**
	 * 	图例的值
	 */
	private List<String> legendData;
	/**
	 * 	图表系列的值
	 */
	private Object seriesData;
	
	
	public Object getXaxis() {
		return xaxis;
	}
	public void setXaxis(Object xaxis) {
		this.xaxis = xaxis;
	}
	public Object getYaxis() {
		return yaxis;
	}
	public void setYaxis(Object yaxis) {
		this.yaxis = yaxis;
	}
	public List<String> getLegendData() {
		return legendData;
	}
	public void setLegendData(List<String> legendData) {
		this.legendData = legendData;
	}
	public Object getSeriesData() {
		return seriesData;
	}
	public void setSeriesData(Object seriesData) {
		this.seriesData = seriesData;
	}
	
	
	

}

package com.sxt.bussi.query;

import com.sxt.common.base.BaseQuery;

public class BusRentsQuery extends BaseQuery {
	
	private String rentNo;
	
	private Integer flag;
	
	private String carNum;
	
	private String idCard;
	
	private String minCreateTime;
	
	private String maxCreateTime;

	public String getRentNo() {
		return rentNo;
	}

	public void setRentNo(String rentNo) {
		this.rentNo = rentNo;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMinCreateTime() {
		return minCreateTime;
	}

	public void setMinCreateTime(String minCreateTime) {
		this.minCreateTime = minCreateTime;
	}

	public String getMaxCreateTime() {
		return maxCreateTime;
	}

	public void setMaxCreateTime(String maxCreateTime) {
		this.maxCreateTime = maxCreateTime;
	}
	
	
	

}

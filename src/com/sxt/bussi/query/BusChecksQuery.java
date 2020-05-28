package com.sxt.bussi.query;

import com.sxt.common.base.BaseQuery;

public class BusChecksQuery extends BaseQuery {
	
	private String checkNo;
	
	private String rentNo;
	
	private String minCheckTime;
	
	private String maxCheckTime;

	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public String getRentNo() {
		return rentNo;
	}

	public void setRentNo(String rentNo) {
		this.rentNo = rentNo;
	}

	public String getMinCheckTime() {
		return minCheckTime;
	}

	public void setMinCheckTime(String minCheckTime) {
		this.minCheckTime = minCheckTime;
	}

	public String getMaxCheckTime() {
		return maxCheckTime;
	}

	public void setMaxCheckTime(String maxCheckTime) {
		this.maxCheckTime = maxCheckTime;
	}
	
	
	

}

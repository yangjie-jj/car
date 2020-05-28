package com.sxt.bussi.query;

import com.sxt.common.base.BaseQuery;

public class BussiCustomerQuery extends BaseQuery {
	
	private String idCard;
	
	private String custName;
	
	private String address;
	
	private String phone;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}

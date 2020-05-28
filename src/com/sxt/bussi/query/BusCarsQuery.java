package com.sxt.bussi.query;

import com.sxt.common.base.BaseQuery;

public class BusCarsQuery extends BaseQuery {
	
	private String carNum;
	
	private String color;
	
	private Integer minPrice;
	
	private Integer maxPrice;
	
	
	private Integer minRentPrice;
	
	private Integer maxRentPrice;
	
	private Integer isRent; // 1  2

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getMinRentPrice() {
		return minRentPrice;
	}

	public void setMinRentPrice(Integer minRentPrice) {
		this.minRentPrice = minRentPrice;
	}

	public Integer getMaxRentPrice() {
		return maxRentPrice;
	}

	public void setMaxRentPrice(Integer maxRentPrice) {
		this.maxRentPrice = maxRentPrice;
	}

	public Integer getIsRent() {
		return isRent;
	}

	public void setIsRent(Integer isRent) {
		this.isRent = isRent;
	}
	
	

}

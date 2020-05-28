package com.sxt.bussi.form;

import com.sxt.common.base.BaseForm;

public class BusChecksForm extends BaseForm {
	
	private Integer id;
	
	private String checkNo;
	
	/**
     * 	检查时间
     */
    private String checkTime;

    /**
     * 	描述
     */
    private String desc;

    /**
     * 	存在问题
     */
    private String problem;

    /**
     * 支付金额
     */
    private Integer payMoney;

    /**
     * 	操作员
     */
    private Integer userId;

    /**
     * 	出租单号
     */
    private String rentNo;

    /**
     * 	创建时间
     */
    private String createTime;


    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }


    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRentNo() {
        return rentNo;
    }

    public void setRentNo(String rentNo) {
        this.rentNo = rentNo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

	public String getCheckNo() {
		return checkNo;
	}

	public void setCheckNo(String checkNo) {
		this.checkNo = checkNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    
}

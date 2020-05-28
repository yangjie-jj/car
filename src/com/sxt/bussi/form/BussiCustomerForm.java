package com.sxt.bussi.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.sxt.common.base.BaseForm;

public class BussiCustomerForm  extends BaseForm{
	/**
     * 客户id
     */
    private Integer id;

    /**
     * 身份证
     */
    @NotEmpty( message = "身份证号不能为空")
    @Length(min=18,max=18,message = "身份证号只能是18位")
    private String idCard;

    /**
     * 姓名
     */
    @NotEmpty( message = "客户名称不能为空")
    @Length(max=30,message = "客户名称最多30字符")
    private String custName;

    /**
     * 性别
     */
    @NotNull(message = "性别不能为空")
    @Range(min=1,max=2,message = "性别只能是男女")
    private Integer sex;

    /**
     * 地址
     */
    @NotEmpty( message = "客户地址不能为空")
    @Length(max=30,message = "客户地址最多30字符")
    private String address;

    /**
     * 电话
     */
    @NotEmpty( message = "客户手机号不能为空")
    @Length(min=11,max=11,message = "客户手机号只能11位")
    private String phone;

    /**
     * 职位
     */
    private String position;

    /**
     * 创建时间
     */
    private String createTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

package com.sxt.sys.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import com.sxt.common.base.BaseForm;


public class SysUsersForm extends BaseForm {
	
	
	/**
	 * 用户编号
	 */
	private Integer id;
	/**
	 * 登陆名
	 */
	@NotEmpty(message = "登录名不能为空")
	@Length(min = 6,max=15,message = "登录名字符最少6位,最多15位")
	private String loginName;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * 身份证号
	 */
	@NotEmpty(message = "身份证号不能为空")
	@Length(min = 18,max=18,message = "身份证号字符只能为18位")
	private String idCard;

	/**
	 * 真实名称
	 */
	@NotEmpty(message = "用户姓名不能为空")
	@Length(min=1,max=15,message = "用户姓名字符最多15位")
	private String realName;

	/**
	 * 性别 1男 2女
	 */
	@NotNull
	@Range(min = 1,max = 2,message = "性别只能是男女")
	private Integer sex;

	/**
	 * 地址
	 */
	@Length(max=100,message = "地址最多100字符")
	private String address;

	/**
	 * 电话
	 */
	@NotEmpty(message = "手机号不能为空")
	@Length(min=11,max=11,message = "手机号只能11位")
	private String phone;

	/**
	 * 职位
	 */
	@Length(max=20,message = "职位最对20位字符")
	private String position;

	/**
	 * 用户类型 1，超级管理员 2，系统用户
	 */
	@NotNull
	@Range(min = 1,max = 2,message = "用户类型只能是超级管理员和系统用户")
	private Integer type;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}

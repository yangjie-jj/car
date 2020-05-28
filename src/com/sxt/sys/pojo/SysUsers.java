package com.sxt.sys.pojo;

import java.io.Serializable;
/**
 * @ClassName: SysUsers 
 * @Description: sys_users 表实体类
 * @author: Mr.T
 * @date: 2019年11月29日 上午10:31:41
 */
public class SysUsers implements Serializable {
	
	private static final long serialVersionUID = 1415207586647453217L;

	/**
	 * 用户编号
	 */
	private Integer id;

	/**
	 * 登陆名
	 */
	private String loginName;

	/**
	 * 登录密码
	 */
	private String password;

	/**
	 * 身份证号
	 */
	private String idCard;

	/**
	 * 真实名称
	 */
	private String realName;

	/**
	 * 性别 1男 2女
	 */
	private Integer sex;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 职位
	 */
	private String position;

	/**
	 * 用户类型 1，超级管理员 2，系统用户
	 */
	private Integer type;
	/**
	 * 用户头像
	 */
	private String img;


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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
}

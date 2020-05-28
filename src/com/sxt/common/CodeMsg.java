package com.sxt.common;
/**
 * @ClassName: CodeMsg 
 * @Description: 业务编码和业务信息枚举
 * @author: Mr.T
 * @date: 2019年11月29日 上午9:47:40
 */
public enum CodeMsg {

	SUCCESS(200,"success"),
	ERROR(500,"程序员在路上"),
	LOGIN_TIMEOUT(501,"登录失效,请重新登录"),
	//用户模块
	SYS_USER_CHECK_CODE_ERROR(4002001,"验证码错误"),
	SYS_USER_ACCOUNT_ERROR(4002002,"用户名或密码不正确"),
	SYS_USER_LOGIN_NAME_EXIST_ERROR(4002003,"用户名已使用"),
	SYS_USER_PHONE_EXIST_ERROR(4002004,"用户手机号已使用"),
	
	//客户模块
	BUSSI_CUSTOMER_ID_CARD_EXIST_ERROR(4006001,"身份证号已使用"),
	BUSSI_CUSTOMER_PHONE_EXIST_ERROR(4006002,"手机号已使用"),
	//车辆模块
	BUSSI_CAR_NUM_EXIST_ERROR(4007001,"车牌号已使用"),
	BUSSI_CAR_RENT_ED_ERROR(4007002,"该车已出租"),
	BUSSI_CAR_STATE_ERROR(4007003,"该车状态已发生改变,请刷新检查"),
	BUSSI_CAR_IDCARD_ERROR(4007004,"身份证号对应的客户不存在"),
	// 出租单模块
	BUSSI_RENT_NO_NOT_EXIST_ERROR(4008001,"出租单不正确"),
	BUSSI_RENT_NO_FLAG_ERROR(4008002,"出租单状态异常,请检查"),
	BUSSI_RENT_CAR_NO_ERROR(4008003,"出租单车牌号异常,请检查"),
	BUSSI_RENT_CAR_STATE_ERROR(4008004,"出租单车辆状态异常,请检查"),
	
	;
	
	
	public Integer CODE;
	public String MSG;
	
	CodeMsg(Integer code,String msg){
		this.CODE = code;
		this.MSG = msg;
	}
	
	
	
}

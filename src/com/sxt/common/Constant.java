package com.sxt.common;
/**
 * @ClassName: Constant 
 * @Description: 全局常量
 * @author: Mr.T
 * @date: 2019年11月30日 上午9:07:37
 */
public interface Constant {

	/**
	 *  web项目的根目录
	 */
	String WEB_ROOT = "WEB_ROOT";
	/**
	 *  数据校验的错误码
	 */
	Integer FORM_DATA_CHECK_ERROR_CODE = 4001000;
	
	/**
	 * 验证码的key
	 */
	String CHECK_CODE = "CHECK_CODE";
	/**
	 *  当前用的key
	 */
	String CURRENT_USER = "user";
	/**
	 * 	默认密码
	 */
	String DEFAULT_PASSWORD = "123456";
	
	
	/**
	 *  年-月-日 时:分:秒
	 */
	String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	/**
	 *  年月日时分秒毫秒
	 */
	String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	
	/**
	 *  未出租
	 */
	Integer UN_RENT = 1;
	
	/**
	 * 已出租
	 */
	Integer RENT_ED = 2;
	
	/**
	 *  未归还
	 */
	Integer RENT_FLAG_NOT_RETURNED = 1; 
	
	/**
	 *  已归还
	 */
	Integer RENT_FLAG_RETURNED = 2; 
	/**
	 * 	菜单有效
	 */
	Integer MENU_FLAG_VALID = 1;
	/**
	 * 	菜单无效
	 */
	Integer MENU_FLAG_UNVALID = 2;
	
	/**
	 *  	业务员
	 */
	Integer USER_SALES = 2;
}

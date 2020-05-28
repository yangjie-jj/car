package com.sxt.common.exception;
/**
 * @ClassName: BussiException 
 * @Description: 自定义业务异常类  
 * 	1. 场景一 :   
 * 		controller
 * 		新增用户  :  可能存在参数 不正确   向页面 返回相关 参数正确的提示     return  Result  code  4001001   电话号码格式不正确
 * 		修改用户 :	可能存在参数 不正确  向页面 返回相关 参数正确的提示     return  Result  code  4001001    用户名格式不正确
 * 		
 * 		在service 层中 :  add 用户
 * 				接车  :  客户身份证号不存在   整个操作应该不成功  事务需要回滚   抛异常.  且要给客户端返回操作失败原因   BussiException
 * 				 获取BussiException : 从中拿到 code  和  msg  : 封装 成 Result  通过json 返回 页面
 * 
 * @author: Mr.T
 * @date: 2019年11月29日 上午11:39:35
 */
public class BussiException extends RuntimeException {

	private static final long serialVersionUID = 5746106156779307915L;
	/**
	 * 	异常编码
	 */
	private Integer code;
	/**
	 * 	异常信息
	 */
	private String msg;
	
	public BussiException() {}
	
	
	public BussiException(Integer code,String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}

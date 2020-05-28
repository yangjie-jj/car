package com.sxt.common;

import java.io.Serializable;
/**
 * @ClassName: Result 
 * @Description: 业务结果类
 * @author: Mr.T
 * @date: 2019年11月29日 上午9:47:06
 */
public class Result implements Serializable {

	private static final long serialVersionUID = -7635141266620742188L;
	/**
	 * 	业务编码
	 */
	private Integer code;
	/**
	 *	业务消息
	 */
	private String msg;
	/**
	 * 	业务数据
	 */
	private Object data;
	
	public Result() {
		this.code = CodeMsg.SUCCESS.CODE;
		this.msg = CodeMsg.SUCCESS.MSG;
	}
	
	public Result(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(CodeMsg codeMsg) {
		this.code = codeMsg.CODE;
		this.msg = codeMsg.MSG;
	}
	
	public Result(Object data) {
		this();
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
	
}

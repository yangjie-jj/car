package com.sxt.common.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.common.CodeMsg;
import com.sxt.common.Result;
import com.sxt.common.exception.BussiException;

/**
 * @ClassName: GlobalExceptionHandler 
 * @Description:  全局异常处理器
 * @author: Mr.T
 * @date: 2019年11月29日 上午11:50:57
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	@ResponseBody
	public Result bussiExceptionHandler(Exception exception) {
		// 出现异常先进行打印
		exception.printStackTrace();
		// 判断是否是自己定义的异常
		if(exception instanceof BussiException) {
			// 将异常转化为BussiException
			BussiException bussiException = (BussiException) exception;
			Integer code = bussiException.getCode();
			String msg = bussiException.getMsg();
			return new Result(code, msg);
		}
		// 程序自身出现了异常
		return new Result(CodeMsg.ERROR);
	}

}

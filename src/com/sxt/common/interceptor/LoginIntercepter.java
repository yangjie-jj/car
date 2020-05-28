package com.sxt.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sxt.common.CodeMsg;
import com.sxt.common.Constant;
import com.sxt.common.exception.BussiException;
import com.sxt.common.util.WebUtil;
import com.sxt.sys.vo.SysUsersVO;

/**
 * @ClassName: LoginIntercepter 
 * @Description: 登录拦截器
 * @author: Mr.T
 * @date: 2019年11月29日 上午11:39:05
 */
public class LoginIntercepter implements HandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		//获取当前用户
		SysUsersVO user = WebUtil.getCurrentUser();
		//判断用户是否存在
		if(user != null) {
			return true;
		}
		//假如是ajax请求,则返回json数据
		String xRequestedWith= req.getHeader("X-Requested-With");
		if(xRequestedWith!= null && xRequestedWith.indexOf("XMLHttpRequest")!=-1){
		  throw new BussiException(CodeMsg.LOGIN_TIMEOUT.CODE, CodeMsg.LOGIN_TIMEOUT.MSG);
		}else{
			//没有登录 登录页面
			resp.sendRedirect(WebUtil.getServletContext().getAttribute("cxt")+"/index.html");
		}
		
	
		return false;
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		
	}

	

}

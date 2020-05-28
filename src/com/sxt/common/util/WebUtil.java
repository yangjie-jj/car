package com.sxt.common.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sxt.common.Constant;
import com.sxt.sys.vo.SysUsersVO;

public class WebUtil {
	
	/**
	 * @Title: getRequest
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午4:14:49 
	 * @Description: 获取request对象
	 * @return
	 * @return: HttpServletRequest
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return servletRequestAttributes.getRequest();
	}
	
	/**
	 * @Title: getSession
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午4:15:29 
	 * @Description: 获取Session
	 * @return
	 * @return: HttpSession
	 */
	public static HttpSession getSession() {
		return getRequest().getSession();
	}
	
	/**
	 * @Title: getServletContext
	 * @author: Mr.T   
	 * @date: 2019年11月29日 下午4:16:31 
	 * @Description: 获取ServletContext
	 * @return
	 * @return: ServletContext
	 */
	public static ServletContext getServletContext() {
		return ContextLoader.getCurrentWebApplicationContext().getServletContext();
	}
	/**
	 * @Title: getCurrentUser
	 * @author: Mr.T   
	 * @date: 2019年12月2日 下午6:01:08 
	 * @Description: 获取当前用户
	 * @return
	 * @return: SysUsersVO
	 */
	public static SysUsersVO getCurrentUser() {
		return (SysUsersVO) getSession().getAttribute(Constant.CURRENT_USER);
	}

}

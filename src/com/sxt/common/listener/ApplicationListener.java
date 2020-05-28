package com.sxt.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.sxt.common.Constant;
import com.sxt.common.util.PropertiesUtil;

/**
 * @ClassName: ApplicationListener 
 * @Description: 设置全局变量
 * @author: Mr.T
 * @date: 2019年11月29日 上午11:30:39
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sce.getServletContext().setAttribute("cxt", PropertiesUtil.getProp("web.properties", Constant.WEB_ROOT));
	}
	

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	

}

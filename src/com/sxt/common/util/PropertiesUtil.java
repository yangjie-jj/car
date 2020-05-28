package com.sxt.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	
	public static String  getProp(String propName,String key) {
		// 加载properties文件
		Properties prop = new Properties();
		String property = null;
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream(propName);
		if(in == null) {
			throw new RuntimeException("配置文件没找到");
		}
		try {
			prop.load(in);
			property = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return property;
		
	}

}

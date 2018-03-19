package com.yuri.bs.util;

import java.io.InputStream;
import java.util.Properties;

/**   
*    
* Project Name：BookStore   
* Class Name：BeanFactory   
* Description：BeanFactory工具类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:49:44   
* Contact：yuri_feng@outlook.com 
*      
*/
public class BeanFactory {

	private static Properties prop;

	static {
		try {
			prop = new Properties();
			InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("bean.properties");
			prop.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getBean(String key) {
		Object obj = null;
		try {
			Class<?> c = Class.forName(prop.getProperty(key));
			obj = c.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
}

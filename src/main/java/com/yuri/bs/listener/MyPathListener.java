package com.yuri.bs.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**   
*    
* Project Name：BookStore   
* Class Name：MyPathListener   
* Description：监听器,目的是在项目启动时,把应用路径放入到最大作用域中
* @author：yuriFeng  
* @date：2018年3月19日 下午10:18:17   
* Contact：yuri_feng@outlook.com 
*      
*/
@WebListener
public class MyPathListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String base = context.getContextPath();
		context.setAttribute("base", base);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.removeAttribute("base");
	}
}

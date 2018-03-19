package com.yuri.bs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yuri.bs.entity.User;

/**   
*    
* Project Name：BookStore   
* Class Name：PermissionFilter   
* Description：权限级别的过滤器
* @author：yuriFeng  
* @date：2018年3月19日 下午10:17:45   
* Contact：yuri_feng@outlook.com 
*      
*/
@WebFilter(filterName = "PermissionFilter", urlPatterns = "/permission/*")
public class PermissionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 把request和response转换成http版本
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/user/info?info=1");
		} else {
			// 放行
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}
}

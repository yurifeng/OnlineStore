package com.yuri.bs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuri.bs.entity.User;
import com.yuri.bs.exception.UserLoginException;
import com.yuri.bs.service.UserService;
import com.yuri.bs.util.BeanFactory;

/**   
*    
* Project Name：BookStore   
* Class Name：UserAction   
* Description：User用户的控制器
* @author：yuriFeng  
* @date：2018年3月19日 下午10:07:46   
* Contact：yuri_feng@outlook.com 
*      
*/
@WebServlet("/user/*")
public class UserAction extends HttpServlet {

	private static final long serialVersionUID = 5722179976852606551L;
	UserService userService = (UserService) BeanFactory.getBean("userService");

	/**
	 * 重写doGet()方法
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String nextPage = null;
		System.out.println("user:" + pathInfo);
		boolean isRedirect = false;
		if ("/login".equals(pathInfo)) {
			response.setContentType("text/plain;charset=utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String isRember = request.getParameter("isRember");
			System.out.println(username + password + isRember);
			PrintWriter out = response.getWriter();
			try {
				User u = userService.login(username, password);
				request.getSession().setAttribute("user", u);
				System.out.println("登陆");
				if ("true".equals(isRember)) {
					System.out.println("设置cookie");
					String cookstr = username + ":" + password;
					Cookie cookie = new Cookie("loginCookie", cookstr);
					cookie.setMaxAge(604800);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				out.println(u.getUserName());
			} catch (UserLoginException e) {
				out.println("0");
			}
			if ("false".equals(isRember)) {
				System.out.println("delete cookie");
				Cookie cookie = getCookieValue(request.getCookies(), "loginCookie");
				if (cookie != null) {
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
			out.flush();
			out.close();

		} else if ("/logout".equals(pathInfo)) {
			request.getSession().invalidate();
			nextPage = request.getContextPath() + "/book/index";
			isRedirect = true;
		} else if ("/register".equals(pathInfo)) {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String company = request.getParameter("company");

			User user = new User();
			user.setUserName(userName);
			user.setCompany(company);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPassword(password);

			System.out.println(user);
			userService.register(user);
			nextPage = request.getContextPath() + "/user/info?info=2";
			isRedirect = true;
		} else if ("/info".equals(pathInfo)) {
			switch (request.getParameter("info")) {
			case "1":
				request.setAttribute("hint", "请先登陆,<a href='#' data-toggle='modal' data-target='#myModal' >立即登录</a>");
				break;
			case "2":
				request.setAttribute("hint", "注册成功");
				break;
			case "3":
				request.setAttribute("hint", "购物车里没有任何物品");
				break;
			default:
				break;
			}
			nextPage = "/WEB-INF/page/info/hint.jsp";
		} else if ("/checkName".equals(pathInfo)) {
			String username = request.getParameter("username");
			response.setContentType("text/plain;charset=utf-8");
			PrintWriter out = response.getWriter();
			if (userService.validate(username)) {
				out.println("1");
			} else {
				out.println("0");
			}
		}

		if (nextPage != null) {
			if (isRedirect) {
				response.sendRedirect(nextPage);
			} else {
				request.getRequestDispatcher(nextPage).forward(request, response);
			}
		}
	}

	/**
	 * 重写doPost()方法
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 获取用户的cookie值
	 * @param cookies
	 * @param cookieName
	 * @return Cookie
	 */
	private Cookie getCookieValue(Cookie[] cookies, String cookieName) {
		if (cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(cookieName)) {
				return cookie;
			}
		}
		return null;

	}

}

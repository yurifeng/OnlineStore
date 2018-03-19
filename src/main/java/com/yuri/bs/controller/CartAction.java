package com.yuri.bs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuri.bs.cart.ShoppingCart;
import com.yuri.bs.entity.Book;
import com.yuri.bs.entity.OrderItem;
import com.yuri.bs.service.BookService;
import com.yuri.bs.util.BeanFactory;

/**   
*    
* Project Name：BookStore   
* Class Name：CartAction   
* Description：Cart购物车的控制器
* @author：yuriFeng  
* @date：2018年3月19日 下午10:05:29   
* Contact：yuri_feng@outlook.com 
*      
*/
@WebServlet("/permission/cart/*")
public class CartAction extends HttpServlet {

	private static final long serialVersionUID = 5722179976852606551L;
	BookService bs = (BookService) BeanFactory.getBean("bookService");

	/**
	 * 重写doGet()方法
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		String nextPage = null;
		ShoppingCart sc = (ShoppingCart) request.getSession().getAttribute("cart");
		if (sc == null) {
			sc = (ShoppingCart) BeanFactory.getBean("cart");
			request.getSession().setAttribute("cart", sc);
		}

		System.out.println("cart:" + pathInfo);
		boolean isRedirect = false;
		if ("/addCart".equals(pathInfo)) {
			String id = request.getParameter("id");
			String count = request.getParameter("count");
			if (id != null) {
				Book b = bs.queryById(Long.parseLong(id));
				OrderItem oit = new OrderItem();
				oit.setBook_isbn(b.getIsbn());
				oit.setBook_name(b.getName());
				oit.setBook_author(b.getAuthor());

				if (count != null && count != "" && isNumber(count)) {

					oit.setCount(Integer.parseInt(count));
					oit.setUnit_price(b.getNewPrice());
					oit.setBook_url(b.getImageurl());
					sc.addCart(oit);
					response.getWriter().append("1");

				} else {
					response.getWriter().append("3");
				}

			} else {
				response.getWriter().append("2");
			}
		} else if ("/updateNumber".equals(pathInfo)) {
			String isbn = request.getParameter("isbn");
			String count = request.getParameter("count");
			if (isbn != null) {
				if (count != null) {
					int cou = Integer.parseInt(count);
					if (cou > 0 && cou < 100) {
						sc.modifyCount(isbn, cou);
						response.getWriter().append("1");
					} else {
						response.getWriter().append("0");
					}

				}
			}

		} else if ("/showCart".equals(pathInfo)) {
			// String pageNow = request.getParameter("pageNow");
			// String pageSize = request.getParameter("pageSize");
			//
			// int now=(pageNow==null)?1:Integer.parseInt(pageNow);
			// int size=(pageSize==null)?4:Integer.parseInt(pageSize);
			//
			// request.setAttribute("pageNow",now);
			// request.setAttribute("pageSize",size);

			nextPage = "/WEB-INF/page/cart/cart.jsp";
		} else if ("/removeCart".equals(pathInfo)) {
			String isbn = request.getParameter("isbn");
			if (isbn != null) {
				sc.delete(isbn);
				response.getWriter().println(sc.getTotal());
			} else {
				response.getWriter().append("-1");
			}
		} else if ("/countTotal".equals(pathInfo)) {
			response.getWriter().println(sc.getTotal());
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

	public boolean isNumber(String str) {
		return str.matches("[0-9]*");
	}

}

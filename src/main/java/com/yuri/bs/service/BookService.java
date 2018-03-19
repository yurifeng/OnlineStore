package com.yuri.bs.service;

import java.util.List;

import com.yuri.bs.entity.Book;
import com.yuri.bs.entity.Category;
import com.yuri.bs.util.PageBean;

/**   
*    
* Project Name：BookStore   
* Class Name：BookService   
* Description：Book的业务层接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:34:53   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface BookService {

	/**
	 * 业务层根据条件查询Book分页
	 * @param now
	 * @param size
	 * @param cate
	 * @param name
	 * @return PageBean<Book>
	 */
	PageBean<Book> queryByCondition(Integer now, Integer size, Long cate, String name);

	/**
	 * 业务层根据id查询Book
	 * @param id
	 * @return Book
	 */
	Book queryById(Long id);

	/**
	 * 业务层查询所有的图书类型
	 * @return List<Category>
	 */
	List<Category> getAllCategories();
}

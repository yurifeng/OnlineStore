package com.yuri.bs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuri.bs.entity.Book;
import com.yuri.bs.entity.Category;

/**   
*    
* Project Name：BookStore   
* Class Name：BookMapper   
* Description：Book的接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:21:32   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface BookMapper {

	/**
	 * 持久层通过id查询Book
	 * @param id
	 * @return Book
	 */
	Book selectBookById(Long id);

	/**
	 * 持久层查询所有的Book
	 * @return List<Book>
	 */
	List<Book> selectAllBooks();

	/**
	 * 持久层根据条件查询Book
	 * @param pageNow
	 * @param pageSize
	 * @param cate
	 * @param name
	 * @return List<Book>
	 */
	List<Book> selectBooksbyCondition(@Param("pageNow") Integer pageNow, @Param("pageSize") Integer pageSize,
			@Param("cate") Long cate, @Param("str") String name);

	/**
	 * 持久层根据图书分类查询计数
	 * @param cate
	 * @return Integer
	 */
	Integer rowCount(@Param("cate") Long cate);

	/**
	 * 持久层查询所有的图书分类
	 * @return List<Category>
	 */
	List<Category> selectCategory();
}

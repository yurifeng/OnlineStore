package com.yuri.bs.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yuri.bs.entity.Book;
import com.yuri.bs.entity.Category;
import com.yuri.bs.mapper.BookMapper;
import com.yuri.bs.service.BookService;
import com.yuri.bs.util.MyBatiesUtil;
import com.yuri.bs.util.PageBean;

/**   
*    
* Project Name：BookStore   
* Class Name：BookServiceImpl   
* Description：BookService 的实现类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:44:00   
* Contact：yuri_feng@outlook.com 
*      
*/
public class BookServiceImpl implements BookService {
	SqlSession session = MyBatiesUtil.sqlSession();
	BookMapper bk = session.getMapper(BookMapper.class);

	@Override
	public PageBean<Book> queryByCondition(Integer now, Integer size, Long cate, String name) {
		PageBean<Book> pb = new PageBean<>();
		pb.setPageNow(now);
		pb.setPageSize(size);
		pb.setPageDatas(bk.selectBooksbyCondition(now, size, cate, name));
		pb.setTotalRecords(bk.rowCount(cate));
		return pb;
	}

	@Override
	public Book queryById(Long id) {
		return bk.selectBookById(id);
	}

	@Override
	public List<Category> getAllCategories() {
		return bk.selectCategory();
	}
}

package com.yuri.bs.service.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.yuri.bs.entity.Order;
import com.yuri.bs.entity.SearchPojo;
import com.yuri.bs.entity.User;
import com.yuri.bs.mapper.ItemMapper;
import com.yuri.bs.mapper.OrderMapper;
import com.yuri.bs.service.OrderService;
import com.yuri.bs.util.MyBatiesUtil;
import com.yuri.bs.util.PageBean;

/**   
*    
* Project Name：BookStore   
* Class Name：OrderServiceImpl   
* Description：OrderService的实现类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:48:55   
* Contact：yuri_feng@outlook.com 
*      
*/
public class OrderServiceImpl implements OrderService {
	SqlSession session = MyBatiesUtil.sqlSession();
	OrderMapper orderMapper = session.getMapper(OrderMapper.class);
	ItemMapper itemMapper = session.getMapper(ItemMapper.class);

	@Override
	public void save(Order o) {
		orderMapper.insertOrder(o);
		itemMapper.insertItemBitch(o.getItems());
		session.commit();
	}

	@Override
	public void delete(Order o) {
		itemMapper.deleteItemsByOrderID(o.getOrderId());
		orderMapper.deleteOrderByID(o.getOrderId());
		session.commit();
	}

	@Override
	public Order findById(Long id) {

		return orderMapper.selectOrderByID(id);
	}

	@Override
	public Order findByNum(String orderNum) {
		return orderMapper.selectOrderByOrderNum(orderNum);
	}

	@Override
	public PageBean<Order> queryByPage(User user, int now, int size, SearchPojo search) {
		PageBean<Order> pageBean = new PageBean<>();
		List<Order> orders = orderMapper.selectOrderPageByUserID(user.getUserid(), now, size, search);
		pageBean.setPageNow(now);
		pageBean.setPageSize(size);
		pageBean.setPageDatas(orders);
		pageBean.setTotalRecords(orderMapper.countOrderByUserIDAndSearch(user.getUserid(), search));

		return pageBean;
	}
}

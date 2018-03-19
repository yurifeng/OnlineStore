package com.yuri.bs.service;

import com.yuri.bs.entity.Order;
import com.yuri.bs.entity.SearchPojo;
import com.yuri.bs.entity.User;
import com.yuri.bs.util.PageBean;

/**   
*    
* Project Name：BookStore   
* Class Name：OrderService   
* Description：Order的业务层的接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:36:41   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface OrderService {

	/**
	 * 业务层保存Order
	 * @param o
	 */
	void save(Order o);

	/**
	 * 业务层删除Order
	 * @param o
	 */
	void delete(Order o);

	/**
	 * 业务层根据id查询Order
	 * @param id
	 * @return Order
	 */
	Order findById(Long id);

	/**
	 * 业务层根据Order的数量查询Order
	 * @param orderNum
	 * @return Order
	 */ 
	Order findByNum(String orderNum);

	/**
	 * 业务层分页显示Order
	 * @param user
	 * @param now
	 * @param size
	 * @param searchPojo
	 * @return PageBean<Order>
	 */
	PageBean<Order> queryByPage(User user, int now, int size, SearchPojo searchPojo);

}

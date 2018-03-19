package com.yuri.bs.cart;

import java.util.List;

import com.yuri.bs.entity.OrderItem;

/**   
*    
* Project Name：BookStore   
* Class Name：ShoppingCart   
* Description：购物车接口
* @author：yuriFeng  
* @date：2018年3月19日 下午9:20:50   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface ShoppingCart {
	/**
	 * 添加购物车
	 * @param item
	 */
	void addCart(OrderItem item);

	/**
	 * 清空购物车
	 */
	void clear();

	
	/**
	 * 修改购物车内容的数量
	 * @param isbn
	 * @param count
	 */
	void modifyCount(String isbn, int count);

	
	/**
	 * 删除购物车中的某商品
	 * @param isbn
	 */
	void delete(String isbn);

	
	/**
	 * 获取购物车的总价
	 * @return double
	 */
	double getTotal();

	
	/**
	 * 获取购物车的数量
	 * @return int
	 */
	int getCount();

	
	/**
	 * 按照分页显示购物车数据
	 * @param pageNow
	 * @param pageSize
	 * @return List<OrderItem>
	 */
	List<OrderItem> getCart(int pageNow, int pageSize);

	
	/**
	 * 获取所有购物车的数据
	 * @return List<OrderItem>
	 */
	List<OrderItem> getCart();
}

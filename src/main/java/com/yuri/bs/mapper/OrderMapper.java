package com.yuri.bs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuri.bs.entity.Order;
import com.yuri.bs.entity.SearchPojo;

/**   
*    
* Project Name：BookStore   
* Class Name：OrderMapper   
* Description：Order的接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:28:36   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface OrderMapper {
	/**
	 * 持久层根据id查询order
	 * @param id
	 * @return Order
	 */
	Order selectOrderByID(Long id);

	/**
	 * 持久层添加Order
	 * @param o
	 * @return Integer
	 */
	Integer insertOrder(Order o);

	/**
	 * 持久层添加Order
	 * @param o
	 * @return Integer
	 */
	Integer updateOrder(Order o);

	/**
	 * 持久层根据user的id查询Order集合(分页显示)
	 * @param uid
	 * @param pageNow
	 * @param pageSize
	 * @param search
	 * @return List<Order>
	 */
	List<Order> selectOrderPageByUserID(@Param("uid") Long uid, @Param("pageNow") int pageNow,
			@Param("pageSize") int pageSize, @Param("search") SearchPojo search);

	/**
	 * 持久层根据id删除Order
	 * @param oid
	 * @return Integer
	 */
	Integer deleteOrderByID(Long oid);

	/**
	 * 持久层根据user的id和搜索查询order的订单数
	 * @param uid
	 * @param search
	 * @return Integer
	 */
	Integer countOrderByUserIDAndSearch(@Param("uid") Long uid, @Param("search") SearchPojo search);

	/**
	 * 持久层根据Order的数量查询order
	 * @param orderNum
	 * @return Order
	 */
	Order selectOrderByOrderNum(String orderNum);
}

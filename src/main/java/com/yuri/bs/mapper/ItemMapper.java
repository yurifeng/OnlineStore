package com.yuri.bs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuri.bs.entity.OrderItem;

/**   
*    
* Project Name：BookStore   
* Class Name：ItemMapper   
* Description：Item订单明细接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:25:11   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface ItemMapper {

	/**
	 * 持久层根据id查询orderItem
	 * @param id
	 * @return
	 */
	OrderItem selectItemByID(Long id);

	/**
	 * 持久层根据oid查询多个OrderItem
	 * @param oid
	 * @return List<OrderItem>
	 */
	List<OrderItem> selectItemByOrderID(Long oid);

	/**
	 * 持久层添加Item
	 * @param i
	 * @param orderid
	 * @return Integer
	 */
	Integer insertItem(@Param("item") OrderItem i, @Param("orderid") Long orderid);

	/**
	 * 持久层批量添加Item
	 * @param item
	 * @return Integer
	 */
	Integer insertItemBitch(List<OrderItem> item);

	/**
	 * 通过订单id删除所有有关的物品
	 * 
	 * @param oid 订单id
	 * @return Integer 影响行数
	 */
	Integer deleteItemsByOrderID(Long oid);
}

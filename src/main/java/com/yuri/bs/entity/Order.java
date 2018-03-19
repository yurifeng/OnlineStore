package com.yuri.bs.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**   
*    
* Project Name：BookStore   
* Class Name：Order   
* Description：Order订单的实体类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:12:08   
* Contact：yuri_feng@outlook.com 
*      
*/
@Data
public class Order {
	private Long orderId;
	private String orderNum;
	private Date createDate;
	private List<OrderItem> items;
	private User user;
	private OrderStatus orderStatus;
	private Address address;
	private Double total;

}

package com.yuri.bs.entity;

import lombok.Data;

/**   
*    
* Project Name：BookStore   
* Class Name：OrderItem   
* Description：订单明细的实体类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:12:25   
* Contact：yuri_feng@outlook.com 
*      
*/
@Data
public class OrderItem {
	private Long itemId;
	private String book_isbn;
	private String book_name;
	private String book_author;
	private Integer count;
	private Double unit_price;
	private Double allPrice;
	private String book_url;
	private Order order;

	public Double getAllPrice() {
		allPrice = Math.ceil(unit_price * count * 100) / 100;
		return allPrice;
	}

}

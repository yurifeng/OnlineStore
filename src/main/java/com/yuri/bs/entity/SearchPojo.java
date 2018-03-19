package com.yuri.bs.entity;

import java.util.Date;

import lombok.Data;

/**   
*    
* Project Name：BookStore   
* Class Name：SearchPojo   
* Description：搜索的实体类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:16:16   
* Contact：yuri_feng@outlook.com 
*      
*/
@Data
public class SearchPojo {
	private String orderNum;
	private Date beginDate;
	private Date endDate;
	private Integer isOrderByTime;
	private OrderStatus orderStatus;
}

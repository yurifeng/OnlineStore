package com.yuri.bs.entity;

import lombok.Data;

/**   
*    
* Project Name：BookStore   
* Class Name：Address   
* Description：Address实体类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:11:26   
* Contact：yuri_feng@outlook.com 
*      
*/
@Data
public class Address {
	private Long addressid;
	private String area;
	private String detailaddress;
	private String emailcode;
	private String reciver;
	private String tel;
	private Character isDefault;
	private User user;
}

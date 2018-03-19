package com.yuri.bs.entity;

import lombok.Data;

/**   
*    
* Project Name：BookStore   
* Class Name：User   
* Description：User用户的实体类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:16:41   
* Contact：yuri_feng@outlook.com 
*      
*/
@Data
public class User {
	private Long userid;
	private String userName;
	private String password;
	private String phone;
	private String email;
	private String company;
}

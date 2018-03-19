package com.yuri.bs.entity;

import java.util.Date;

import lombok.Data;

/**   
*    
* Project Name：BookStore   
* Class Name：Book   
* Description：Book实体类
* @author：yuriFeng  
* @date：2018年3月19日 下午10:11:42   
* Contact：yuri_feng@outlook.com 
*      
*/
@Data
public class Book {
	private Long bookid;
	private String isbn;
	private String name;
	private String author;
	private String publishHouse;
	private Date publishDate;
	private Double oldPrice;
	private Double newPrice;
	private String authorLoc;
	private String info;
	private String imageurl;
	private String suit;
	private Category category;
}

package com.yuri.bs.exception;

/**   
*    
* Project Name：BookStore   
* Class Name：UserLoginException   
* Description：自定义异常
* @author：yuriFeng  
* @date：2018年3月19日 下午10:17:17   
* Contact：yuri_feng@outlook.com 
*      
*/
public class UserLoginException extends ServiceException {

	private static final long serialVersionUID = 1202117627919331243L;

	public UserLoginException(String message) {
		super(message);
	}
}

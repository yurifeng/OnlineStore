package com.yuri.bs.exception;

/**   
*    
* Project Name：BookStore   
* Class Name：ServiceException   
* Description：自定义异常
* @author：yuriFeng  
* @date：2018年3月19日 下午10:16:59   
* Contact：yuri_feng@outlook.com 
*      
*/
public class ServiceException extends Exception {

	private static final long serialVersionUID = 5150124926149885724L;

	public ServiceException(String message) {
		super(message);

	}

}

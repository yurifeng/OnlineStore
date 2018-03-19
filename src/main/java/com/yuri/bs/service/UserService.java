package com.yuri.bs.service;

import java.util.List;

import com.yuri.bs.entity.Address;
import com.yuri.bs.entity.User;
import com.yuri.bs.exception.UserLoginException;

/**   
*    
* Project Name：BookStore   
* Class Name：UserService   
* Description： User的业务层接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:39:34   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface UserService {
	/**
	 * 业务层的用户登录
	 * @param name
	 * @param pwd
	 * @return User
	 * @throws UserLoginException
	 */
	User login(String name, String pwd) throws UserLoginException;

	/**
	 * 业务层的用户注册
	 * @param user
	 */
	void register(User user);

	/**
	 * 业务层的用户验证
	 * @param name
	 * @return boolean
	 */
	boolean validate(String name);

	/**
	 * 业务层的添加地址
	 * @param a
	 */
	void addAddress(Address a);

	/**
	 * 业务层的删除地址
	 * @param a
	 */
	void removeAddress(Address a);

	/**
	 * 业务层的修改地址
	 * @param a
	 */
	void updateAddress(Address a);

	/**
	 * 业务层的根据User查询地址
	 * @param u
	 * @return List<Address>
	 */
	List<Address> getAddressByUser(User u);

	/**
	 * 业务层的根据id查询地址
	 * @param id
	 * @return Address
	 */
	Address getAddressById(Long id);
}

package com.yuri.bs.mapper;

import org.apache.ibatis.annotations.Param;

import com.yuri.bs.entity.User;

/**   
*    
* Project Name：BookStore   
* Class Name：UserMapper   
* Description：User的接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:33:04   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface UserMapper {
	
	/**
	 * 持久层根据User的id查询User
	 * @param userID
	 * @return User
	 */
	User selectUser(Long userID);

	/**
	 * 持久层根据Username查询user
	 * @param userName
	 * @return User
	 */
	User selectUserByUserName(@Param("name") String userName);

	/**
	 * 持久层添加User
	 * @param u
	 * @return Integer
	 */
	Integer insertUser(User u);

	/**
	 * 持久层修改User
	 * @param u
	 * @return Integer
	 */
	Integer updateUser(User u);
}

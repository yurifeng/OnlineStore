package com.yuri.bs.mapper;

import java.util.List;

import com.yuri.bs.entity.Address;

/**   
*    
* Project Name：BookStore   
* Class Name：AddressMapper   
* Description：Address地址接口
* @author：yuriFeng  
* @date：2018年3月19日 下午10:18:38   
* Contact：yuri_feng@outlook.com 
*      
*/
public interface AddressMapper {

	/**
	 * 持久层通过id查询地址
	 * @param id
	 * @return Address
	 */
	Address selectAddrByID(Long id);

	/**
	 * 持久层通过id删除地址
	 * @param id
	 * @return Integer
	 */
	Integer deleteAddr(Long id);

	/**
	 * 持久层通过User的id查询地址集合
	 * @param uid
	 * @return List<Address>
	 */
	List<Address> selectAddrsByUserID(Long uid);

	/**
	 * 持久层插入地址
	 * @param a
	 * @return Integer
	 */
	Integer insertAddr(Address a);

	/**
	 * 持久层修改地址
	 * @param a
	 * @return Integer
	 */
	Integer updateAddr(Address a);

	/**
	 * 持久层清除默认地址
	 * @param uid
	 * @return Integer
	 */
	Integer cleanDefaultAddress(Long uid);
}

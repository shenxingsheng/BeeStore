/*
 * 文件名：AddressService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.Address;

public interface AddressService
{
	void save(Address address);
	
	void delete(Address address);
	
	void delete(String id);
	
	void update(Address address);
	
	Address find(String id);
	
	List<Address> getAll();
}

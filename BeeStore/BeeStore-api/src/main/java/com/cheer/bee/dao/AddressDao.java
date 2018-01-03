/*
 * 文件名：AddressDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.Address;
import com.cheer.bee.util.Page;

public interface AddressDao
{
	void save(Address address);
	
	void delete(Address address);
	
	void delete(String id);
	
	void update(Address address);
	
	Address find(String id);
	
	List<Address> getAll();
	
	List<Address> getPage(Page page);
}

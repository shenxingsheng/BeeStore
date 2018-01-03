/*
 * 文件名：CustomerDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.Customer;
import com.cheer.bee.util.Page;

public interface CustomerDao
{
	void save(Customer customer);
	
	void delete(Customer customer);
	
	void delete(String id);
	
	void update(Customer customer);
	
	Customer find(String id);
	
	List<Customer> getAll();
	
	List<Customer> getPage(Page page);
	
	Customer findByUsername(String username);
}

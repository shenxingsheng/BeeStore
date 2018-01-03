/*
 * 文件名：CustomerService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.Customer;

public interface CustomerService
{
	void save(Customer customer);
	
	void delete(Customer customer);
	
	void delete(String id);
	
	void update(Customer customer);
	
	Customer find(String id);
	
	List<Customer> getAll();
	
    boolean checkEmailIsExists(String email);

    boolean checkUsernameIsExists(String username);
    
    Customer findByUsername(String username);
}

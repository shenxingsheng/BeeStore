/*
 * 文件名：OrderService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.Order;

public interface OrderService
{
	void save(Order order);
	
	void delete(Order order);
	
	void delete(String id);
	
	void update(Order order);
	
	Order find(String id);
	
	List<Order> getAll();
}

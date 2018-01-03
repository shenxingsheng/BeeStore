/*
 * 文件名：OrderItemService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.OrderItem;

public interface OrderItemService
{
	void save(OrderItem orderItem);
	
	void delete(OrderItem orderItem);
	
	void delete(String id);
	
	void update(OrderItem orderItem);
	
	OrderItem find(String id);
	
	List<OrderItem> getAll();
}

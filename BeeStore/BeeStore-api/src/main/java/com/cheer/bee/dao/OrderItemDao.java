/*
 * 文件名：OrderItemDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.OrderItem;
import com.cheer.bee.util.Page;

public interface OrderItemDao
{
	void save(OrderItem orderItem);
	
	void delete(OrderItem orderItem);
	
	void delete(String id);
	
	void update(OrderItem orderItem);
	
	OrderItem find(String id);
	
	List<OrderItem> getAll();
	
	List<OrderItem> getPage(Page page);
}

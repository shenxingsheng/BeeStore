/*
 * 文件名：OrderDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.Order;
import com.cheer.bee.util.Page;



public interface OrderDao
{
	void save(Order order);
	
	void delete(Order order);
	
	void delete(String id);
	
	void update(Order order);
	
	Order find(String id);
	
	List<Order> getAll();
	
	List<Order> getPage(Page page);
}

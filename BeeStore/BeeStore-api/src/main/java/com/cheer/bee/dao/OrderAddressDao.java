/*
 * 文件名：OrderAddressDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月26日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.OrderAddress;
import com.cheer.bee.util.Page;

public interface OrderAddressDao
{
	void save(OrderAddress orderAddress);
	
	void delete(OrderAddress orderAddress);
	
	void delete(String id);
	
	void update(OrderAddress orderAddress);
	
	OrderAddress find(String id);
	
	List<OrderAddress> getAll();
	
	List<OrderAddress> getPage(Page page);
}

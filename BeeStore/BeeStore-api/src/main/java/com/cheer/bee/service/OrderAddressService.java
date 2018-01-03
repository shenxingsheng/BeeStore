/*
 * 文件名：OrderAddressService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.OrderAddress;

public interface OrderAddressService
{
	void save(OrderAddress orderAddress);
	
	void delete(OrderAddress orderAddress);
	
	void delete(String id);
	
	void update(OrderAddress orderAddress);
	
	OrderAddress find(String id);
	
	List<OrderAddress> getAll();
}

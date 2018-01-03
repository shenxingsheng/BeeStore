/*
 * 文件名：OrderItemServiceImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.bee.dao.OrderItemDao;
import com.cheer.bee.domain.OrderItem;
import com.cheer.bee.service.OrderItemService;

@Transactional
@Service
public class OrderItemServiceImpl implements OrderItemService
{
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Override
	public void save(OrderItem orderItem)
	{
		// TODO Auto-generated method stub
		this.orderItemDao.save(orderItem);
	}

	@Override
	public void delete(OrderItem orderItem)
	{
		// TODO Auto-generated method stub
		this.orderItemDao.delete(orderItem);
	}

	@Override
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		this.orderItemDao.delete(id);
	}

	@Override
	public void update(OrderItem orderItem)
	{
		// TODO Auto-generated method stub
		this.orderItemDao.update(orderItem);
	}

	@Override
	public OrderItem find(String id)
	{
		// TODO Auto-generated method stub
		return this.orderItemDao.find(id);
	}

	@Override
	public List<OrderItem> getAll()
	{
		// TODO Auto-generated method stub
		return this.orderItemDao.getAll();
	}

}

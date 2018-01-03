/*
 * 文件名：OrderServiceImpl.java
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

import com.cheer.bee.dao.OrderDao;
import com.cheer.bee.domain.Order;
import com.cheer.bee.service.OrderService;

@Transactional
@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void save(Order order)
	{
		// TODO Auto-generated method stub
		this.orderDao.save(order);
	}

	@Override
	public void delete(Order order)
	{
		// TODO Auto-generated method stub
		this.orderDao.delete(order);
	}

	@Override
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		this.orderDao.delete(id);
	}

	@Override
	public void update(Order order)
	{
		// TODO Auto-generated method stub
		this.orderDao.update(order);
	}

	@Override
	public Order find(String id)
	{
		// TODO Auto-generated method stub
		return this.orderDao.find(id);
	}

	@Override
	public List<Order> getAll()
	{
		// TODO Auto-generated method stub
		return this.orderDao.getAll();
	}

}

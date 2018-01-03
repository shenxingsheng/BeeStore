/*
 * 文件名：OrderAddressServiceImpl.java
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

import com.cheer.bee.dao.OrderAddressDao;
import com.cheer.bee.domain.OrderAddress;
import com.cheer.bee.service.OrderAddressService;

@Transactional
@Service
public class OrderAddressServiceImpl implements OrderAddressService
{
	@Autowired
	private OrderAddressDao orderAddressDao;
	
	@Override
	public void save(OrderAddress orderAddress)
	{
		// TODO Auto-generated method stub
		this.orderAddressDao.save(orderAddress);
	}

	@Override
	public void delete(OrderAddress orderAddress)
	{
		// TODO Auto-generated method stub
		this.delete(orderAddress);
	}

	@Override
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		this.delete(id);
	}

	@Override
	public void update(OrderAddress orderAddress)
	{
		// TODO Auto-generated method stub
		this.update(orderAddress);
	}

	@Override
	public OrderAddress find(String id)
	{
		// TODO Auto-generated method stub
		return this.orderAddressDao.find(id);
	}

	@Override
	public List<OrderAddress> getAll()
	{
		// TODO Auto-generated method stub
		return this.orderAddressDao.getAll();
	}

}

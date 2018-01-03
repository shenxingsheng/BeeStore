/*
 * 文件名：CartItemServiceImpl.java
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

import com.cheer.bee.dao.CartItemDao;
import com.cheer.bee.domain.CartItem;
import com.cheer.bee.service.CartItemService;

@Transactional
@Service
public class CartItemServiceImpl implements CartItemService
{
	
	@Autowired
	private CartItemDao cartItemDao;

	@Override
	public void save(CartItem cartItem)
	{
		// TODO Auto-generated method stub
		this.cartItemDao.save(cartItem);
	}

	@Override
	public void delete(CartItem cartItem)
	{
		// TODO Auto-generated method stub
		this.cartItemDao.delete(cartItem);
	}

	@Override
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		this.cartItemDao.delete(id);
	}

	@Override
	public void update(CartItem cartItem)
	{
		// TODO Auto-generated method stub
		this.cartItemDao.update(cartItem);
	}

	@Override
	public CartItem find(String id)
	{
		// TODO Auto-generated method stub
		return this.cartItemDao.find(id);
	}

	@Override
	public List<CartItem> getAll()
	{
		// TODO Auto-generated method stub
		return this.cartItemDao.getAll();
	}

}

/*
 * 文件名：CartServiceImpl.java
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

import com.cheer.bee.dao.CartDao;
import com.cheer.bee.domain.Cart;
import com.cheer.bee.service.CartService;

@Transactional
@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartDao cartDao;
	
	@Override
	public void save(Cart cart)
	{
		// TODO Auto-generated method stub
		this.cartDao.save(cart);
	}

	@Override
	public void delete(Cart cart)
	{
		// TODO Auto-generated method stub
		this.cartDao.delete(cart);
	}

	@Override
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		this.cartDao.delete(id);
	}

	@Override
	public void update(Cart cart)
	{
		// TODO Auto-generated method stub
		this.cartDao.update(cart);
	}

	@Override
	public Cart find(String id)
	{
		// TODO Auto-generated method stub
		return this.cartDao.find(id);
	}

	@Override
	public List<Cart> getAll()
	{
		// TODO Auto-generated method stub
		return this.cartDao.getAll();
	}

}

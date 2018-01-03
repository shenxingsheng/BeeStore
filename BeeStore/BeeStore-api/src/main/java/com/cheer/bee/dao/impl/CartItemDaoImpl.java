/*
 * 文件名：CartItemImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.bee.dao.CartItemDao;
import com.cheer.bee.domain.CartItem;
import com.cheer.bee.util.Page;

@Transactional
@Repository
public class CartItemDaoImpl implements CartItemDao
{

	@Autowired
	private SessionFactory sf;

	@Override
	public void save(CartItem cartItem)
	{
		Session session = sf.getCurrentSession();
		session.persist(cartItem);
	}

	@Override
	public void delete(CartItem cartItem)
	{
		this.sf.getCurrentSession().delete(cartItem);
	}

	@Override
	public void delete(String id)
	{
		this.delete(this.find(id));
	}

	@Override
	public void update(CartItem cartItem)
	{
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(cartItem);
	}

	@Override
	public CartItem find(String id)
	{

		return sf.getCurrentSession().get(CartItem.class, id);
	}

	@Override
	public List<CartItem> getAll()
	{
		String hql = "SELECT c FROM CartItem c ORDER BY c.id";
		return sf.getCurrentSession().createQuery(hql, CartItem.class).setCacheable(true).list();
	}
	
	 @Override
	 public List<CartItem> getPage(Page page)
	 {
		 String hql = "SELECT c FROM CartItem c ORDER BY c.id";

		 return sf.getCurrentSession().createQuery(hql, CartItem.class).setFirstResult(
				 page.getStartRow()).setMaxResults(page.getPageSize()).getResultList();
	 }

}

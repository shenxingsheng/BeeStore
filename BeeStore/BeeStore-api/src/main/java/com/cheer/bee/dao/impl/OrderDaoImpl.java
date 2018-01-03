/*
 * 文件名：OrderDaoImpl.java
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

import com.cheer.bee.dao.OrderDao;
import com.cheer.bee.domain.Order;
import com.cheer.bee.util.Page;

@Transactional
@Repository
public class OrderDaoImpl implements OrderDao
{

	@Autowired
	private SessionFactory sf;

	@Override
	public void save(Order order)
	{
		Session session = sf.getCurrentSession();
		session.persist(order);
	}

	@Override
	public void delete(Order order)
	{
		this.sf.getCurrentSession().delete(order);
	}

	@Override
	public void delete(String id)
	{
		this.delete(this.find(id));
	}

	@Override
	public void update(Order order)
	{
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(order);
	}

	@Override
	public Order find(String id)
	{

		return sf.getCurrentSession().get(Order.class, id);
	}

	@Override
	public List<Order> getAll()
	{
		String hql = "SELECT o FROM Order o ORDER BY o.id";
		return sf.getCurrentSession().createQuery(hql, Order.class).setCacheable(true).list();
	}
	
	 @Override
	 public List<Order> getPage(Page page)
	 {
		 String hql = "SELECT o FROM Order o ORDER BY o.id";

		 return sf.getCurrentSession().createQuery(hql, Order.class).setFirstResult(
				 page.getStartRow()).setMaxResults(page.getPageSize()).getResultList();
	 }
}

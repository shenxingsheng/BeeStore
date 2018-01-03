/*
 * 文件名：OrderItemDaoImpl.java
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

import com.cheer.bee.dao.OrderItemDao;
import com.cheer.bee.domain.OrderItem;
import com.cheer.bee.util.Page;

@Transactional
@Repository
public class OrderItemDaoImpl implements OrderItemDao
{

	@Autowired
	private SessionFactory sf;

	@Override
	public void save(OrderItem orderItem)
	{
		Session session = sf.getCurrentSession();
		session.persist(orderItem);
	}

	@Override
	public void delete(OrderItem orderItem)
	{
		this.sf.getCurrentSession().delete(orderItem);
	}

	@Override
	public void delete(String id)
	{
		this.delete(this.find(id));
	}

	@Override
	public void update(OrderItem orderItem)
	{
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(orderItem);
	}

	@Override
	public OrderItem find(String id)
	{

		return sf.getCurrentSession().get(OrderItem.class, id);
	}

	@Override
	public List<OrderItem> getAll()
	{
		String hql = "SELECT o FROM OrderItem o ORDER BY o.id";
		return sf.getCurrentSession().createQuery(hql, OrderItem.class).setCacheable(true).list();
	}
	
	 @Override
	 public List<OrderItem> getPage(Page page)
	 {
		 String hql = "SELECT o FROM OrderItem o ORDER BY o.id";

		 return sf.getCurrentSession().createQuery(hql, OrderItem.class).setFirstResult(
				 page.getStartRow()).setMaxResults(page.getPageSize()).getResultList();
	 }
}

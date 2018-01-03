/*
 * 文件名：OrderAddressDaoImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月26日
 */

package com.cheer.bee.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.bee.dao.OrderAddressDao;
import com.cheer.bee.domain.OrderAddress;
import com.cheer.bee.util.Page;

@Transactional
@Repository
public class OrderAddressDaoImpl implements OrderAddressDao
{

	@Autowired
	private SessionFactory sf;

	@Override
	public void save(OrderAddress orderAddress)
	{
		Session session = sf.getCurrentSession();
		session.persist(orderAddress);
	}

	@Override
	public void delete(OrderAddress orderAddress)
	{
		this.sf.getCurrentSession().delete(orderAddress);
	}

	@Override
	public void delete(String id)
	{
		this.delete(this.find(id));
	}

	@Override
	public void update(OrderAddress orderAddress)
	{
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(orderAddress);
	}
	

	@Override
	public OrderAddress find(String id)
	{

		return sf.getCurrentSession().get(OrderAddress.class, id);
	}

	@Override
	public List<OrderAddress> getAll()
	{
		String hql = "SELECT o FROM OrderAddress o ORDER BY o.id";
		return sf.getCurrentSession().createQuery(hql, OrderAddress.class).setCacheable(true).list();
	}
	
	 @Override
	 public List<OrderAddress> getPage(Page page)
	 {
		 String hql = "SELECT o FROM OrderAddress o ORDER BY o.id";

		 return sf.getCurrentSession().createQuery(hql, OrderAddress.class).setFirstResult(
				 page.getStartRow()).setMaxResults(page.getPageSize()).getResultList();
	 }
}

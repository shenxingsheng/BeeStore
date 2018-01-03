/*
 * 文件名：CustomerDaoImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.bee.dao.CustomerDao;
import com.cheer.bee.domain.Cart;
import com.cheer.bee.domain.Customer;
import com.cheer.bee.util.Page;

@Transactional
@Repository
public class CustomerDaoImpl implements CustomerDao
{

	@Autowired
	private SessionFactory sf;

    @Override
    public void save(Customer customer)
    {
        customer.getAccount().setCreateTime(new Date());
        
        Cart cart = new Cart();
        cart.setCreateTime(new Date());
        customer.setCart(cart);
        cart.setCustomer(customer);

        sf.getCurrentSession().save(customer);
    }

	@Override
	public void delete(Customer customer)
	{
		this.sf.getCurrentSession().delete(customer);
	}

	@Override
	public void delete(String id)
	{
		this.delete(this.find(id));
	}

	@Override
	public void update(Customer customer)
	{
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(customer);
	}

	@Override
	public Customer find(String id)
	{
		return sf.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public List<Customer> getAll()
	{
		String hql = "SELECT c FROM Customer c ORDER BY c.id";
		return sf.getCurrentSession().createQuery(hql, Customer.class).setCacheable(true).list();
	}

	@Override
	public List<Customer> getPage(Page page)
	{
		String hql = "SELECT c FROM Customer c ORDER BY c.id";

		return sf.getCurrentSession().createQuery(hql, Customer.class).setFirstResult(page.getStartRow())
				.setMaxResults(page.getPageSize()).getResultList();
	}

	@Override
	public Customer findByUsername(String username)
	{
		String hql = "SELECT c FROM Customer c WHERE c.account.username = :username";
		return sf.getCurrentSession().createQuery(hql, Customer.class).setParameter("username", username)
				.getSingleResult();
	}

}

/*
 * 文件名：CartDaoImpl.java
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

import com.cheer.bee.dao.CartDao;
import com.cheer.bee.domain.Cart;
import com.cheer.bee.util.Page;

@Transactional
@Repository
public class CartDaoImpl implements CartDao
{

    @Autowired
    private SessionFactory sf;

    @Override
    public void save(Cart cart)
    {
        Session session = sf.getCurrentSession();
        session.persist(cart);
    }

    @Override
    public void delete(Cart cart)
    {
        this.sf.getCurrentSession().delete(cart);
    }

    @Override
    public void delete(String id)
    {
       this.delete(this.find(id));
    }

    @Override
    public void update(Cart cart)
    {   
    	Session session = sf.getCurrentSession();
            
        session.saveOrUpdate(cart);
    }

    @Override
    public Cart find(String id)
    {
    	
        return sf.getCurrentSession().get(Cart.class, id);
    }

    @Override
    public List<Cart> getAll()
    {
        String hql = "SELECT c FROM Cart c ORDER BY c.id";
        return sf.getCurrentSession().createQuery(hql, Cart.class).setCacheable(true).list();
    }
    
    @Override
    public List<Cart> getPage(Page page)
    {
        String hql = "SELECT c FROM Cart c ORDER BY c.id";

        return sf.getCurrentSession().createQuery(hql, Cart.class).setFirstResult(
            page.getStartRow()).setMaxResults(page.getPageSize()).getResultList();
    }

}

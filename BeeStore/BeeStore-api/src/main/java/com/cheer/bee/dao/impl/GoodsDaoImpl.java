/*
 * 文件名：GoodsDaoImpl.java
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

import com.cheer.bee.dao.GoodsDao;
import com.cheer.bee.domain.Goods;
import com.cheer.bee.util.Page;

@Transactional
@Repository
public class GoodsDaoImpl implements GoodsDao
{

	@Autowired
	private SessionFactory sf;

	@Override
	public void save(Goods goods)
	{
		Session session = sf.getCurrentSession();
		session.persist(goods);
	}

	@Override
	public void delete(Goods goods)
	{
		this.sf.getCurrentSession().delete(goods);
	}
	
	@Override
	public void delete(Integer goodsno)
	{
		this.delete(this.find(goodsno));
	}

	@Override
	public void delete(String id)
	{
		this.delete(this.find(id));
	}

	@Override
	public void update(Goods goods)
	{
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(goods);
	}
	
	@Override
	public Goods find(Integer goodsno)
	{
		String hql = "SELECT g FROM Goods g WHERE g.goodsno = :goodsno";
        return sf.getCurrentSession().createQuery(hql, Goods.class).setParameter("goodsno",
            goodsno).getSingleResult();
	}

	@Override
	public Goods find(String id)
	{

		return sf.getCurrentSession().get(Goods.class, id);
	}

	@Override
	public List<Goods> getAll()
	{
		String hql = "SELECT g FROM Goods g ORDER BY g.id";
		return sf.getCurrentSession().createQuery(hql, Goods.class).setCacheable(true).list();
	}
	
	 @Override
	 public List<Goods> getPage(Page page)
	 {
		 String hql = "SELECT g FROM Goods g ORDER BY g.id";

		 return sf.getCurrentSession().createQuery(hql, Goods.class).setFirstResult(
				 page.getStartRow()).setMaxResults(page.getPageSize()).getResultList();
	 }
}

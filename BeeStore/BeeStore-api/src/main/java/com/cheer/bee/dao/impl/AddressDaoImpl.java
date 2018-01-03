/*
 * 文件名：AddressDaoImpl.java
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

import com.cheer.bee.dao.AddressDao;
import com.cheer.bee.domain.Address;
import com.cheer.bee.util.Page;

@Transactional
@Repository("addressDaoImpl")
public class AddressDaoImpl implements AddressDao
{
	/*
	 * 框架提供的增删改 不同于 通过hql语句注入的，级联关系比如级联删除等操作 如果
	 * 用的是 hql语句  会报错 或者正常运行但是没法级联 因此尽量用框架提供的方法
	 * 至于 getAll（）只是查询数据 无所谓
	 * hql的具体操作 可以看EMS-api的domain中 有例子
	 */
	
	@Autowired
	private SessionFactory sf;
	 	
	@Override
	public void save(Address address)
	{

		Session session = sf.getCurrentSession();
		session.persist(address);
	}
	
	@Override
	public void delete(Address address)
	{
		this.sf.getCurrentSession().delete(address);
	}
	
	@Override
	public void delete(String id)
	{
		this.delete(this.find(id));
	}
	
	@Override
	public void update(Address address) 
	{
		Session session = sf.getCurrentSession();

		session.saveOrUpdate(address);
	}
	
	@Override
	public Address find(String id)
	{
		
		return sf.getCurrentSession().get(Address.class, id);
	}
	
	@Override
	public List<Address> getAll()
	{
		String hql = "SELECT a FROM Address a ORDER BY a.id";
		
		return sf.getCurrentSession().createQuery(hql, Address.class).setCacheable(true).list();
	}
	
	@Override
    public List<Address> getPage(Page page)
    {
        String hql = "SELECT a FROM Address a ORDER BY a.id";

        return sf.getCurrentSession().createQuery(hql, Address.class).setFirstResult(
            page.getStartRow()).setMaxResults(page.getPageSize()).getResultList();
    }

}

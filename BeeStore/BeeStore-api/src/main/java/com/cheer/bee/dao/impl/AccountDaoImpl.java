/*
 * 文件名：AccountDaoImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月2日
 */

package com.cheer.bee.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheer.bee.dao.AccountDao;
import com.cheer.bee.domain.Account;

@Transactional
@Repository
public class AccountDaoImpl implements AccountDao
{

	@Autowired
	SessionFactory sf;

	@Override
	public void save(Account account)
	{
		
		sf.getCurrentSession().save(account);
	}

	@Override
	public void delete(Account account)
	{
		sf.getCurrentSession().delete(account);
	}

	@Override
	public void delete(String id)
	{
		this.sf.getCurrentSession().delete(this.find(id));
	}

	@Override
	public void update(Account account)
	{
		sf.getCurrentSession().saveOrUpdate(account);
	}

	@Override
	public Account find(String id)
	{
		return sf.getCurrentSession().get(Account.class, id);
	}

	@Override
	public List<Account> getAll()
	{
		return sf.getCurrentSession().createQuery("SELECT a FROM Account a", Account.class).getResultList();
	}
}

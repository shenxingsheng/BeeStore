/*
 * 文件名：AuthorityDaoImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月2日
 */

package com.cheer.bee.dao.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cheer.bee.dao.AuthorityDao;
import com.cheer.bee.domain.Authority;

@Transactional
@Repository
public class AuthorityDaoImpl implements AuthorityDao
{
    @Autowired
    SessionFactory sf;

    @Override
    public void save(Authority authority)
    {	
    	authority.setCreateTime(new Date());
        this.sf.getCurrentSession().save(authority);
    }

    @Override
    public void delete(Authority authority)
    {
        this.sf.getCurrentSession().delete(authority);
    }

    @Override
    public void delete(String id)
    {
        this.sf.getCurrentSession().delete(this.find(id));
    }

    @Override
    public void update(Authority authority)
    {
        this.sf.getCurrentSession().saveOrUpdate(authority);
    }

    @Override
    public Authority find(String id)
    {
        return this.sf.getCurrentSession().get(Authority.class, id);
    }

    @Override
    public List<Authority> getAll()
    {
        return this.sf.getCurrentSession().createQuery("SELECT a FROM Authority a", Authority.class).list();
    }
}


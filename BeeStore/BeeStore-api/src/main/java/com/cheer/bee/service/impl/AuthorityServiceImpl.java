/*
 * 文件名：AuthorityServiceImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月2日
 */

package com.cheer.bee.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheer.bee.dao.AuthorityDao;
import com.cheer.bee.domain.Authority;
import com.cheer.bee.service.AuthorityService;

@Service
@Transactional
public class AuthorityServiceImpl implements AuthorityService
{
    @Autowired
    AuthorityDao authorityDao;

    @Override
    public void save(Authority authority)
    {
        this.authorityDao.save(authority);
    }

    @Override
    public void delete(Authority authority)
    {
        this.authorityDao.delete(authority);
    }

    @Override
    public void delete(String id)
    {
        this.authorityDao.delete(id);
    }

    @Override
    public void update(Authority authority)
    {
        this.authorityDao.update(authority);
    }

    @Override
    public Authority find(String id)
    {
        return this.authorityDao.find(id);
    }

    @Override
    public List<Authority> getAll()
    {
        return this.authorityDao.getAll();
    }
}

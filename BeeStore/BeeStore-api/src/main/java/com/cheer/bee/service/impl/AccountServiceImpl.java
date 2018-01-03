/*
 * 文件名：AccountServiceImpl.java
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

import com.cheer.bee.dao.AccountDao;
import com.cheer.bee.domain.Account;
import com.cheer.bee.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{
    @Autowired
    AccountDao accountDao;

    @Override
    public void save(Account account)
    {
        this.accountDao.save(account);
    }

    @Override
    public void delete(Account account)
    {
        this.accountDao.delete(account);
    }

    @Override
    public void delete(String id)
    {
        this.accountDao.delete(id);
    }

    @Override
    public void update(Account account)
    {
        this.accountDao.update(account);
    }

    @Override
    public Account find(String id)
    {
        return this.accountDao.find(id);
    }

    @Override
    public List<Account> getAll()
    {
        return this.accountDao.getAll();
    }
}

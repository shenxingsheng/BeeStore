/*
 * 文件名：CustomerServiceImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.bee.dao.CustomerDao;
import com.cheer.bee.domain.Customer;
import com.cheer.bee.service.CustomerService;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerDao customerDao;

	@Override
	public void save(Customer customer)
	{
		// TODO Auto-generated method stub
		this.customerDao.save(customer);
	}

	@Override
	public void delete(Customer customer)
	{
		// TODO Auto-generated method stub
		this.customerDao.delete(customer);
	}

	@Override
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		this.customerDao.delete(id);
	}

	@Override
	public void update(Customer customer)
	{
		// TODO Auto-generated method stub
		this.customerDao.update(customer);
	}

	@Override
	public Customer find(String id)
	{
		// TODO Auto-generated method stub
		return this.customerDao.find(id);
	}

	@Override
	public List<Customer> getAll()
	{
		// TODO Auto-generated method stub
		return this.customerDao.getAll();
	}
	
    @Override
    public boolean checkEmailIsExists(String email)
    {
        List<Customer> customerList = this.customerDao.getAll();

        for (Customer customer : customerList)
        {
            if (email.equals(customer.getEmail()))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean checkUsernameIsExists(String username)
    {
        List<Customer> customerList = this.customerDao.getAll();

        for (Customer customer : customerList)
        {
            if (username.equals(customer.getAccount().getUsername()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Customer findByUsername(String username)
    {
        return this.customerDao.findByUsername(username);
    }

}

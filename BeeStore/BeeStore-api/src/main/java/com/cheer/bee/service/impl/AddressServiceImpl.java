/*
 * 文件名：AddressServiceImpl.java
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

import com.cheer.bee.dao.AddressDao;
import com.cheer.bee.domain.Address;
import com.cheer.bee.service.AddressService;

@Transactional
@Service
public class AddressServiceImpl implements AddressService
{
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public void save(Address address)
	{
		this.addressDao.save(address);
	}

	@Override
	public void delete(Address address)
	{
		this.addressDao.delete(address);
	}

	@Override
	public void delete(String id)
	{
		this.addressDao.delete(id);

	}

	@Override
	public void update(Address address)
	{
		this.addressDao.update(address);

	}

	@Override
	public Address find(String id)
	{
		
		return this.addressDao.find(id);
	}

	@Override
	public List<Address> getAll()
	{
		// TODO Auto-generated method stub
		return this.addressDao.getAll();
	}

}

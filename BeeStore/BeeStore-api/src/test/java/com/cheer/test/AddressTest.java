/*
 * 文件名：AddressTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月26日
 */

package com.cheer.test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.bee.dao.AddressDao;
import com.cheer.bee.dao.CustomerDao;
import com.cheer.bee.domain.Address;
import com.cheer.bee.domain.Customer;
import com.cheer.bee.service.AddressService;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class AddressTest
{
	private static final Logger LOGGER = LogManager.getLogger(AddressTest.class);
	
	@Autowired
	private AddressDao addressDao;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Test
	public void save()
	{
		Customer customer = customerDao.find("402880e56093357c0160933586410000");
		
		
		
		Address address = new Address("中国", "山东1", "滕州市", "枫木镇", "露露村", "007", 1311509116, customer);
		
		//addressDao.save(address);
		addressService.save(address);
	}
	
	@Test
	public void update()
	{
		Address address = addressDao.find("402882f0609b21ff01609b220a8a0000");
		address.setCountry("美国");
		addressDao.update(address);
	}
	
	@Test
	public void show()
	{
		List<Address> addressList = addressDao.getAll();
		
		for(Address address : addressList)
		{
			LOGGER.info(address);
		}
		//有问题 目前用到order 全有问题
	}
	
	@Test
	public void delete()
	{
		addressDao.delete("402882f0609bd59001609bd59b2f0001");
		
	}
	
	
}

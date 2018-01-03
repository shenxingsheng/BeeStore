/*
 * 文件名：OrderAddressDaoTest.java
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

import com.cheer.bee.dao.OrderAddressDao;
import com.cheer.bee.domain.OrderAddress;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class OrderAddressDaoTest
{
	private static final Logger LOGGER = LogManager.getLogger(OrderAddressDaoTest.class);
	
	@Autowired
	private OrderAddressDao orderAddressDao;
	
	@Test
	public void sava()
	{
		OrderAddress orderAddress = new OrderAddress("美国", "洛杉矶", "唐人街", "玉山", "008", 121213);
		
		orderAddressDao.save(orderAddress);
	}
	
	@Test
	public void update()
	{
		OrderAddress orderAddress = orderAddressDao.find("402882f36095c72d016095c7377f0000");
		orderAddress.setTown("周庄");
		
		orderAddressDao.update(orderAddress);
	}
	
	@Test
	public void show()
	{
		List<OrderAddress> orderAddressList = orderAddressDao.getAll();
		
		for(OrderAddress orderAddress: orderAddressList)
		{
			LOGGER.info(orderAddress);
		}
	}
	
	@Test
	public void delete()
	{
		orderAddressDao.delete("402882f36095cef5016095ceff9e0000");
	}
}

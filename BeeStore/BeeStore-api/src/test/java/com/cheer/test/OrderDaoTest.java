/*
 * 文件名：OrderDaoTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月26日
 */

package com.cheer.test;

import java.util.Date;
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

import com.cheer.bee.dao.CustomerDao;
import com.cheer.bee.dao.OrderAddressDao;
import com.cheer.bee.dao.OrderDao;
import com.cheer.bee.domain.Order;
import com.cheer.bee.domain.OrderAddress;
import com.cheer.bee.domain.OrderStatus;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class OrderDaoTest
{
	private static final Logger LOGGER = LogManager.getLogger(OrderDaoTest.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private OrderAddressDao orderAddressDao;
	
	@Test
	public void save()
	{
		OrderAddress orderAddress = orderAddressDao.find("402882f36095c72d016095c7377f0000");
		Order order = new Order(orderAddress, 500.1, customerDao.find("402880e56093357c0160933586410000"), OrderStatus.PAID, new Date(), new Date(), new Date(), new Date());
		orderDao.save(order);
	}
	
	@Test
	public void update()
	{
		Order order = orderDao.find("402882f0609afc8a01609afc94340000");
		order.setTotalPrice(200.1);
		orderDao.update(order);
	}
	
	@Test
	public void show()
	{
		List<Order> orderList = orderDao.getAll();
		
		for(Order order: orderList)
		{
			LOGGER.info(order);
		}
	}
	
	@Test
	public void delete()
	{
		orderDao.delete("402882f36095eb2a016095eb34660000");
	}
}

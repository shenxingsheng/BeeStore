/*
 * 文件名：CartDaoTest.java
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

import com.cheer.bee.dao.CartDao;
import com.cheer.bee.dao.CustomerDao;
import com.cheer.bee.domain.Cart;
import com.cheer.bee.domain.Customer;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class CartDaoTest
{
	private static final Logger LOGGER = LogManager.getLogger(CartDaoTest.class);
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Test
	public void save()
	{
		Customer customer = customerDao.find("402880e56093357c0160933586410000");
		Cart cart = new Cart(100.1, customer);
		
		cartDao.save(cart);
	}
	
	@Test
	public void update()
	{
		Cart cart = cartDao.find("402882f36095b14a016095b154490000");
		cart.setTotalPrice(200.1);
		cartDao.update(cart);
	}
	
	@Test
	public void show()
	{
	   List<Cart> cartList = cartDao.getAll();
	   
	   for(Cart cart : cartList)   
	   {
		   LOGGER.info(cart);
	   }
	   
	   //有问题
	}
	
	@Test 
	public void delete()
	{
		cartDao.delete("402880e56093357c0160933586620001");
	}
}

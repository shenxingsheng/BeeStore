/*
 * 文件名：OrderItemDaoTest.java
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

import com.cheer.bee.dao.GoodsDao;
import com.cheer.bee.dao.OrderDao;
import com.cheer.bee.dao.OrderItemDao;
import com.cheer.bee.domain.Goods;
import com.cheer.bee.domain.ItemStatus;
import com.cheer.bee.domain.Order;
import com.cheer.bee.domain.OrderItem;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class OrderItemDaoTest
{
	private static final Logger LOGGER = LogManager.getLogger(OrderItemDaoTest.class);
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void save()
	{
		Order order = orderDao.find("402882f36095db94016095db9de40000");
		Goods goods = goodsDao.find("402882f36096bd39016096bd434a0000");
		OrderItem orderItem = new OrderItem(110, order, goods, ItemStatus.Checked, 100.1);
		orderItemDao.save(orderItem);
	}
	
	@Test
	public void update()
	{
		OrderItem orderItem = orderItemDao.find("402882f0609b28a901609b28b38b0000");
		orderItem.setTotalPrice(1.1);
		orderItemDao.update(orderItem);
	}
	
	@Test
	public void show()
	{
		List<OrderItem> orderItemList = orderItemDao.getAll();
		
		for(OrderItem orderItem : orderItemList)
		{
			LOGGER.info(orderItem);
		}
	}
	
	@Test
	public void delete()
	{
		orderItemDao.delete("402882f0609b28a901609b28b38b0000");
	}
}

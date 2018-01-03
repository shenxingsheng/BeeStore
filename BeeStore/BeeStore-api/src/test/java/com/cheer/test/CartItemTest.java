/*
 * 文件名：CartItemTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月25日
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

import com.cheer.bee.dao.CartDao;
import com.cheer.bee.dao.CartItemDao;
import com.cheer.bee.dao.GoodsDao;
import com.cheer.bee.domain.Cart;
import com.cheer.bee.domain.CartItem;
import com.cheer.bee.domain.Goods;
import com.cheer.bee.domain.ItemStatus;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class CartItemTest
{
	private static final Logger LOGGER = LogManager.getLogger(CartItemTest.class);
	
	@Autowired
	private CartItemDao cartItemDao;
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Test
	public void saveCartItemDao()
	{
		Goods goods = goodsDao.find("402882f36096bd39016096bd434a0000");
		Cart cart = cartDao.find("402882f36095b466016095b470090000");
		
		CartItem cartItem = new CartItem();
		cartItem.setCart(cart);
		cartItem.setDateAdd(new Date());
		cartItem.setGoods(goods);
		cartItem.setNumber(10);
		cartItem.setTotalPrice(1100.1);
		cartItem.setItemStatus(ItemStatus.Checked);
		
		cartItemDao.save(cartItem);
	}
	
	@Test
	public void updateCartItem()
	{
		CartItem cartItem = cartItemDao.find("402882f0609af82101609af82bc90000");
		
		cartItem.setNumber(99);
		
		cartItemDao.update(cartItem);
	}
	
	@Test
	public void show()
	{
		List<CartItem> cartItemList = cartItemDao.getAll();
		
		for(CartItem cartItem : cartItemList)
		{
			LOGGER.info(cartItem);
		}
	}
	
	@Test
	public void delete()
	{
		cartItemDao.delete("402882f0609af82101609af82bc90000");
	}
}

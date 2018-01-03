/*
 * 文件名：GoodsDaoTest.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月25日
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
import com.cheer.bee.dao.impl.AddressDaoImpl;
import com.cheer.bee.domain.Goods;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class GoodsDaoTest
{
	private static final Logger LOGGER = LogManager.getLogger(GoodsDaoTest.class);
	
	@Autowired
	private GoodsDao goodsDao;
	
	@Test
	public void saveGoods()
	{	
		//数据库里的数字命名 最好别用 0开头 因为到数据库里看 002 变成看2  但是 其他修改删除等操作 输入2 不报错 但是无效
		Goods goods = new Goods(002,"可乐", "碳刷饮料", 4.3, "这个夏天够凉快", "manufacturer", null, 100);
		
		goodsDao.save(goods);
	}
	
	@Test
	public void update()
	{
		Goods goods = goodsDao.find(001);
		goods.setDescribe("娃哈哈真好喝！");
		//goodsDao.update(goods);    //find拿到了一持久化对象 貌似 直接对这个对象操作 数据库会自动同步 好像 不用saveAndUpdate
	}
	
	@Test
	public void show()
	{
		List<Goods> goodsList = goodsDao.getAll();
		
		for(Goods goods : goodsList)
		{
			LOGGER.info(goods);
		}
	}
	
	@Test
	public void delete()
	{
		goodsDao.delete(002);
	}
}

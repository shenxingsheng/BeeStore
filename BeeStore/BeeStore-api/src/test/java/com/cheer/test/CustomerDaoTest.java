/*
 * 文件名：CustomerDaoTest.java
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

import com.cheer.bee.dao.CustomerDao;
import com.cheer.bee.domain.Account;
import com.cheer.bee.domain.Address;
import com.cheer.bee.domain.Cart;
import com.cheer.bee.domain.Customer;

@Rollback(false)
@Transactional
@ContextConfiguration(locations = "classpath*:spring/spring.*.xml")
@RunWith(SpringRunner.class)
public class CustomerDaoTest
{
	private static final Logger LOGGER = LogManager.getLogger(AddressTest.class);
	
	@Autowired
	private CustomerDao customerDao;
	
	@Test
	public void save()
	{
		//这样就能将 customer 保存到数据库啦 至于 customer中只有空的 list 似乎没和address等关联，实际看表能得到，既然又address维护，那么数据库customer表中只
		//有基本信息 是不会也不能存list 什么时候 要用到customer的时候  就是增加地址的时候 再find出 一个customer然后 customer.getAddressList().add(address);
		//这样 Address中 就会保存 且 有了customer的外键id
		Account account = new Account("admin", "admin", true);
		Customer customer = new Customer("大表弟1", "666666@qq.com", 1234123, "dabiaoge", "sxs123", account,new Cart(), 101.1);
		Address address = new Address("中国11", "山东", "滕州", "枫木镇", "大坞沟", "008", 110, customer);
		
		customer.getAddressList().add(address);
		customerDao.save(customer);
	}
	
	@Test
	public void update()
	{
		//前期测试时 没有加类的编号 这里暂时先用id查询 虽然很长 但是在数据库复制一下 也不麻烦
		Customer customer = customerDao.find("402882f0609bd59001609bd59b060000");
		customer.setName("大表弟低");
		customerDao.update(customer);
	}
	
	@Test
	public void show()
	{
		List<Customer> customerList = customerDao.getAll();
		
		for(Customer customer : customerList)
		{
			LOGGER.info(customer);
			
		}
	}
	
	@Test
	public void delete()
	{
		customerDao.delete("402882ea60a025760160a025823b0000");
		
	}
}

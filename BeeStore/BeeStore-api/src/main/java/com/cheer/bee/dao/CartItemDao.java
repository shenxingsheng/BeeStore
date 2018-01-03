/*
 * 文件名：CartItemDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.CartItem;
import com.cheer.bee.util.Page;

public interface CartItemDao
{
	void save(CartItem cartItem);
	
	void delete(CartItem cartItem);
	
	void delete(String id);
	
	void update(CartItem cartItem);
	
	CartItem find(String id);
	
	List<CartItem> getAll();
	
	List<CartItem> getPage(Page page);
}

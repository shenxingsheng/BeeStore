/*
 * 文件名：CartItemService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.CartItem;

public interface CartItemService
{
	void save(CartItem cartItem);
	
	void delete(CartItem cartItem);
	
	void delete(String id);
	
	void update(CartItem cartItem);
	
	CartItem find(String id);
	
	List<CartItem> getAll();
}

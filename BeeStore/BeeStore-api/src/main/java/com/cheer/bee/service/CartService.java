/*
 * 文件名：CartService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.Cart;

public interface CartService
{
	void save(Cart cart);
	
	void delete(Cart cart);
	
	void delete(String id);
	
	void update(Cart cart);
	
	Cart find(String id);
	
	List<Cart> getAll();
}

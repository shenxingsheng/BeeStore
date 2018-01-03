/*
 * 文件名：CartDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.Cart;
import com.cheer.bee.util.Page;

public interface CartDao 
{
	void save(Cart cart);
	
	void delete(Cart cart);
	
	void delete(String id);
	
	void update(Cart cart);
	
	Cart find(String id);
	
	List<Cart> getAll();
	
	List<Cart> getPage(Page page);
}

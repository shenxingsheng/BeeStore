/*
 * 文件名：GoodsDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月24日
 */

package com.cheer.bee.dao;

import java.util.List;

import com.cheer.bee.domain.Goods;
import com.cheer.bee.util.Page;



public interface GoodsDao
{
	void save(Goods goods);
	
	void delete(Goods goods);
	
	void delete(String id);
	
	void delete(Integer goodsno);
	
	void update(Goods goods);
	
	Goods find(Integer goodsno);
	
	Goods find(String id);
	
	List<Goods> getAll();
	
	List<Goods> getPage(Page page);
}

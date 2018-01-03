/*
 * 文件名：GoodsService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.Goods;

public interface GoodsService
{
	void save(Goods goods);
	
	void delete(Goods goods);
	
	void delete(String id);
	
	void delete(Integer goodsno);
	
	void update(Goods goods);
	
	Goods find(Integer goodsno);
	
	Goods find(String id);
	
	List<Goods> getAll();
}

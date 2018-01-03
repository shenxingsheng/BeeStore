/*
 * 文件名：GoodsServiceImpl.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月27日
 */

package com.cheer.bee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.bee.dao.GoodsDao;
import com.cheer.bee.domain.Goods;
import com.cheer.bee.service.GoodsService;

@Transactional
@Service
public class GoodsServiceImpl implements GoodsService
{
	@Autowired
	private GoodsDao goodsDao;
	
	@Override
	public void save(Goods goods)
	{
		// TODO Auto-generated method stub
		this.goodsDao.save(goods);
	}

	@Override
	public void delete(Goods goods)
	{
		// TODO Auto-generated method stub
		this.goodsDao.delete(goods);
	}

	@Override
	public void delete(String id)
	{
		// TODO Auto-generated method stub
		this.goodsDao.delete(id);
	}

	@Override
	public void delete(Integer goodsno)
	{
		// TODO Auto-generated method stub
		this.goodsDao.delete(goodsno);
	}

	@Override
	public void update(Goods goods)
	{
		// TODO Auto-generated method stub
		this.goodsDao.update(goods);
	}

	@Override
	public Goods find(Integer goodsno)
	{
		// TODO Auto-generated method stub
		return this.goodsDao.find(goodsno);
	}

	@Override
	public Goods find(String id)
	{
		// TODO Auto-generated method stub
		return this.goodsDao.find(id);
	}
	
	@Override
	public List<Goods> getAll()
	{
		return this.goodsDao.getAll();
	}

}

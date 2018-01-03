/*
 * 文件名：OrderItem.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月21日
 */

package com.cheer.bee.domain;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.OrderItem")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_orderitem")
public class OrderItem extends BaseEntity
{
	
	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "`number`")
	private Integer number;
	
	@ManyToOne
	private Order order;
	
	@OneToOne(cascade = CascadeType.REFRESH,fetch=FetchType.EAGER)
	private Goods goods;
	
	@Enumerated(EnumType.STRING)
	private ItemStatus itemStatus;
	
	@Column
	private Double totalPrice;
	
	public OrderItem()
	{
		
	}
	
	public OrderItem(Integer number, Order order, Goods goods, ItemStatus itemStatus, Double totalPrice)
	{
		super();
		this.number = number;
		this.order = order;
		this.goods = goods;
		this.itemStatus = itemStatus;
		this.totalPrice = totalPrice;
	}

	public Integer getNumber()
	{
		return number;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}

	public Order getOrder()
	{
		return order;
	}

	public void setOrder(Order order)
	{
		this.order = order;
	}

	public Goods getGoods()
	{
		return goods;
	}

	public void setGoods(Goods goods)
	{
		this.goods = goods;
	}

	public ItemStatus getItemStatus()
	{
		return itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus)
	{
		this.itemStatus = itemStatus;
	}

	public Double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice)
	{
		this.totalPrice = totalPrice;
	}
		
}

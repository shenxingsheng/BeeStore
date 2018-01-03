/*
 * 文件名：CartItem.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月21日
 */

package com.cheer.bee.domain;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.CartItem")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_carItem")
public class CartItem extends BaseEntity
{
	
	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "`number`")
	private Integer number;
	
	@ManyToOne
	private Cart cart;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	private Goods goods;
	
	@Enumerated(EnumType.STRING)
	private ItemStatus itemStatus;
	
	@Column
	private Double totalPrice;
	
	@Column
	private Date dateAdd;
	
	public CartItem()
	{
		
	}
	
	public CartItem(Integer number, Cart cart, Goods goods, ItemStatus itemStatus, Double totalPrice, Date dateAdd)
	{
		super();
		this.number = number;
		this.cart = cart;
		this.goods = goods;
		this.itemStatus = itemStatus;
		this.totalPrice = totalPrice;
		this.dateAdd = dateAdd;
	}

	public Integer getNumber()
	{
		return number;
	}

	public void setNumber(Integer number)
	{
		this.number = number;
	}

	public Cart getCart()
	{
		return cart;
	}

	public void setCart(Cart cart)
	{
		this.cart = cart;
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

	public Date getDateAdd()
	{
		return dateAdd;
	}

	public void setDateAdd(Date dateAdd)
	{
		this.dateAdd = dateAdd;
	}
	
}

/*
 * 文件名：Cart.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月20日
 */

package com.cheer.bee.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.Cart")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_cart")
public class Cart extends BaseEntity
{
	
	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;


	@Column
	private Double totalPrice;

	
	@OneToOne
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="cart",fetch=FetchType.LAZY)
	private List<CartItem> cartItemList = new ArrayList<>();
	
	public Cart()
	{
		
	}
	
	public Cart(Double totalPrice, Customer customer)
	{
		super();
		this.totalPrice = totalPrice;
		this.customer = customer;
	}

	public Double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public List<CartItem> getCartItemList()
	{
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList)
	{
		this.cartItemList = cartItemList;
	}
	
	
}

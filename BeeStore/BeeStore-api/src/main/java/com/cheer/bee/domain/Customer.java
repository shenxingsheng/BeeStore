/*
 * 文件名：Customer.java
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.Customer")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_customer")
public class Customer extends BaseEntity
{

	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "The customer name must not be null")
	@Column
	private String name;
	
	@NotEmpty(message = "The customer name must not be null")
	@Column
	private String email;
	
	@NotEmpty(message = "The customer name must not be null")
	@Column
	private Integer telPhone;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "accountId")
    private Account account;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy="customer",fetch=FetchType.EAGER)
	private Cart cart;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="customer",fetch=FetchType.LAZY)
	private List<Address> addressList = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.PERSIST,mappedBy="customer",fetch=FetchType.LAZY)
	private List<Order> orderList = new ArrayList<>();
	
	@Column
	private Double balance;
	
	public Customer()
	{
		
	}
	
	public Customer(String name, String email, Integer telPhone, String username, String password, Account account, Cart cart, Double balance)
	{
		super();
		this.name = name;
		this.email = email;
		this.telPhone = telPhone;
		this.username = username;
		this.password = password;
		this.account = account;
		this.cart = cart;
		this.balance = balance;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getTelPhone()
	{
		return telPhone;
	}

	public void setTelPhone(Integer telPhone)
	{
		this.telPhone = telPhone;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Cart getCart()
	{
		return cart;
	}

	public void setCart(Cart cart)
	{
		this.cart = cart;
	}
	
	public Account getAccount()
	{
		return account;
	}

	public void setAccount(Account account)
	{
		this.account = account;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public Double getBalance()
	{
		return balance;
	}

	public void setBalance(Double balance)
	{
		this.balance = balance;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public List<Address> getAddressList()
	{
		return addressList;
	}

	public void setAddressList(List<Address> addressList)
	{
		this.addressList = addressList;
	}

	public List<Order> getOrderList()
	{
		return orderList;
	}

	public void setOrderList(List<Order> orderList)
	{
		this.orderList = orderList;
	}
	
}

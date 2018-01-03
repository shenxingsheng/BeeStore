/*
 * 文件名：OrderAddress.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月26日
 */

package com.cheer.bee.domain;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.OrderAaddress")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_orderaddress")
public class OrderAddress extends BaseEntity
{

	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;	
	
	@Column
	private String country;
	
	@Column
	private String city;
	
	@Column
	private String town;
	
	@Column
	private String street;
	
	@Column
	private String houseNumber;
	
	@Column
	private Integer phone;
	
	public OrderAddress()
	{
		
	}
	
	public OrderAddress(String country, String city, String town, String street, String houseNumber, Integer phone)
	{
		super();
		this.country = country;
		this.city = city;
		this.town = town;
		this.street = street;
		this.houseNumber = houseNumber;
		this.phone = phone;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getTown()
	{
		return town;
	}

	public void setTown(String town)
	{
		this.town = town;
	}

	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	public String getHouseNumber()
	{
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber)
	{
		this.houseNumber = houseNumber;
	}

	public Integer getPhone()
	{
		return phone;
	}

	public void setPhone(Integer phone)
	{
		this.phone = phone;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}

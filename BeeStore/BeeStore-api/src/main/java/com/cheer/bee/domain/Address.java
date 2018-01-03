/*
 * 文件名：Address.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月21日
 */

package com.cheer.bee.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.Address")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_address")
public class Address extends BaseEntity
{
	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String country;
	
	@Column
	private String province;
	
	@Column
	private String city;
	
	@Column
	private String town;

	@Column
	private String street;
	
	@Column
	private String houserNumber;
	
	@Column
	private Integer phone;
	
	@ManyToOne
	private Customer customer;
	
	public Address()
	{
		
	}

	public Address(String country, String province, String city, String town, String street, String houserNumber,
			Integer phone, Customer customer)
	{
		super();
		this.country = country;
		this.province = province;
		this.city = city;
		this.town = town;
		this.street = street;
		this.houserNumber = houserNumber;
		this.phone = phone;
		this.customer = customer;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
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

	public String getHouserNumber()
	{
		return houserNumber;
	}

	public void setHouserNumber(String houserNumber)
	{
		this.houserNumber = houserNumber;
	}
	
	
	public Integer getPhone()
	{
		return phone;
	}

	public void setPhone(Integer phone)
	{
		this.phone = phone;
	}
}

/*
 * 文件名：Goods.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月20日
 */

package com.cheer.bee.domain;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.springframework.web.multipart.MultipartFile;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.Goods")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_goods")
public class Goods extends BaseEntity
{
	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;

	@NaturalId
	private Integer goodsno;
	
	@Column
	private String name;
	
	@Column
	private String kind;
	
	@Column
	private Double price;
	
	@Column
	private String describe;
	
	@Column
	private String manufacturer;
	
	@Transient
	private MultipartFile image;
	
	@Column
	private Integer inStock;
	
	public Goods()
	{
		
	}
	
	public Goods(Integer goodsno, String name, String kind, Double price, String describe, String manufacturer,
			MultipartFile image, Integer inStock)
	{
		super();
		this.goodsno = goodsno;
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.describe = describe;
		this.manufacturer = manufacturer;
		this.image = image;
		this.inStock = inStock;
	}
	
	public Integer getGoodsno()
	{
		return goodsno;
	}

	public void setGoodsno(Integer goodsno)
	{
		this.goodsno = goodsno;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getKind()
	{
		return kind;
	}

	public void setKind(String kind)
	{
		this.kind = kind;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice(Double price)
	{
		this.price = price;
	}

	public String getDescribe()
	{
		return describe;
	}

	public void setDescribe(String describe)
	{
		this.describe = describe;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public MultipartFile getImage()
	{
		return image;
	}

	public void setImage(MultipartFile image)
	{
		this.image = image;
	}

	public Integer getInStock()
	{
		return inStock;
	}

	public void setInStock(Integer inStock)
	{
		this.inStock = inStock;
	}
	
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this);
	}
	
}

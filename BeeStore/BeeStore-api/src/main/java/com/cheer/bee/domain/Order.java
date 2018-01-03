/*
 * 文件名：Order.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月20日
 */

package com.cheer.bee.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.cheer.bee.domain.Order")
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name ="tbl_order")
public class Order extends BaseEntity
{
	/**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private OrderAddress orderAddress;
	
	@OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;
	
	@Column
	private Double totalPrice;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="order",fetch=FetchType.LAZY)
	private List<OrderItem> orderItemList = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	@Column
	private Date createDate;
	
	@Column
	private Date shippedDate;
	
	@Column
	private Date deliveredDate;
	
	@Column
	private Date paidDate;
	
	public Order()
	{
		
	}
	
	public Order(OrderAddress orderAddress, Double totalPrice, Customer customer, 
			OrderStatus orderStatus, Date createDate, Date shippedDate, Date deliveredDate, Date paidDate)
	{
		super();
		this.orderAddress = orderAddress;
		this.totalPrice = totalPrice;
		this.customer = customer;
		this.orderStatus = orderStatus;
		this.createDate = createDate;
		this.shippedDate = shippedDate;
		this.deliveredDate = deliveredDate;
		this.paidDate = paidDate;
	}

	public OrderAddress getAddress()
	{
		return orderAddress;
	}

	public void setAddress(Address address)
	{
		this.orderAddress = orderAddress;
	}

	/*
	public Payment getPayment()
	{
		return payment;
	}

	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}
	*/

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

	public OrderStatus getOrderStatus()
	{
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus)
	{
		this.orderStatus = orderStatus;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public Date getShippedDate()
	{
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate)
	{
		this.shippedDate = shippedDate;
	}

	public Date getDeliveredDate()
	{
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate)
	{
		this.deliveredDate = deliveredDate;
	}

	public Date getPaidDate()
	{
		return paidDate;
	}

	public void setPaidDate(Date paidDate)
	{
		this.paidDate = paidDate;
	}

	public OrderAddress getOrderAddress()
	{
		return orderAddress;
	}

	public void setOrderAddress(OrderAddress orderAddress)
	{
		this.orderAddress = orderAddress;
	}

	public List<OrderItem> getOrderItemList()
	{
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList)
	{
		this.orderItemList = orderItemList;
	}
	
	
}

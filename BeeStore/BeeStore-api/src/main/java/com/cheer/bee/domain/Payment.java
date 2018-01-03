/*
 * 文件名：payment.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2017年12月21日
 */

package com.cheer.bee.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@DynamicInsert
@DynamicUpdate
@Table(name = "tbl_payment")
@Entity
public class Payment extends BaseEntity
{
    /**
	 * 意义，目的和功能，以及被用到的地方<br>
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 意义，目的和功能，以及被用到的地方<br>
     */


    @Column
    private Date datePaid;

    @Column
    private Double realTotal;

    public Date getDatePaid()
    {
        return datePaid;
    }

    public void setDatePaid(Date datePaid)
    {
        this.datePaid = datePaid;
    }

    public Double getRealTotal()
    {
        return realTotal;
    }

    public void setRealTotal(Double realTotal)
    {
        this.realTotal = realTotal;
    }
}

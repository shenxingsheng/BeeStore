/*
 * 文件名：BaseEntity.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月2日
 */

package com.cheer.bee.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Past;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * 基本实体类，供其他实体类继承
 * 
 * @author Cheer
 * @version 2017年11月2日
 * @see BaseEntity
 * @since
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class BaseEntity implements Serializable
{
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;

    /**
     * @return Returns the id.
     */
    public String getId()
    {
        return id;
    }

    /**
     * 记录表数据创建的时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss")
    @Past
    @Column
    private Date createTime;

    /**
     * 记录表数据最后一次修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss")
    @Past
    @Column
    private Date modifiedTime;

    /**
     * 备注
     */
    @Column
    private String remark;

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getModifiedTime()
    {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime)
    {
        this.modifiedTime = modifiedTime;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

}

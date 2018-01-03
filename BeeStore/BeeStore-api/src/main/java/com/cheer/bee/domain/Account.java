/*
 * 文件名：Account.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月2日
 */

package com.cheer.bee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

@DynamicInsert
@DynamicUpdate
@Table(name = "tbl_account")
@Entity
public class Account extends BaseEntity
{

    /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = -3266304500319549823L;

    @NotEmpty(message = "The customer username must not be null")
    @NaturalId
    @Column
    private String username;

    @NotEmpty(message = "The customer password must not be null")
    @Column
    private String password;

    @Column
    private Boolean enabled;

    public Account()
    {
    }

    public Account(String username, String password, Boolean enabled)
    {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
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

    public Boolean getEnabled()
    {
        return enabled;
    }

    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

}

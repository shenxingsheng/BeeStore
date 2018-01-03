/*
 * 文件名：Authority.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月2日
 */

package com.cheer.bee.domain;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@DynamicInsert
@DynamicUpdate
@Table(name = "tbl_authority")
@Entity
public class Authority extends BaseEntity
{
	 /**
     * 意义，目的和功能，以及被用到的地方<br>
     */
    private static final long serialVersionUID = -6701670099670858999L;

    /**
     * 用户名
     */
    @Column
    private String username;

    /**
     * 角色
     */
    @Enumerated(EnumType.STRING)
    private Role role;

    public Authority()
    {
    }

    public Authority(String username, Role role)
    {
        this.username = username;
        this.role = role;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }
}

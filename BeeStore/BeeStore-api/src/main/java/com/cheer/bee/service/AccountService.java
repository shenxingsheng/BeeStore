/*
 * 文件名：AccountService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月2日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.Account;

public interface AccountService
{
	void save(Account account);
	
	void delete(Account account);
	
	void delete(String id);
	
	void update(Account account);
	
	Account find(String id);
	
	List<Account> getAll();
}

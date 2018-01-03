/*
 * 文件名：AuthorityService.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月2日
 */

package com.cheer.bee.service;

import java.util.List;

import com.cheer.bee.domain.Authority;

public interface AuthorityService
{
	void save(Authority authority);
	
	void delete(Authority authority);
	
	void delete(String id);
	
	void update(Authority authority);
	
	Authority find(String id);
	
	List<Authority> getAll();
}

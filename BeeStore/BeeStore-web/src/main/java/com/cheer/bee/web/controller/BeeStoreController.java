/*
 * 文件名：Controller.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：ThinkPad
 * 修改时间：2018年1月1日
 */

package com.cheer.bee.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/beeStore")
@Controller
public class BeeStoreController
{
	private static final Logger LOGGER = LogManager.getLogger(BeeStoreController.class);
	
	
	@GetMapping
	public String list()
	{
		return "header";
	}
}

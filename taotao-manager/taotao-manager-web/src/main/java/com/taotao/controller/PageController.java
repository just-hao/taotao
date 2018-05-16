package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.taotao.controller 
 * @author: wang   
 * @date: 2018年5月13日 下午4:59:59 
 * @Description:
 */
@Controller
public class PageController {
	
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping(value = "/")
	public String showIndex(){
		return "index";
	}
	
	/**
	 * 展示其他页面
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	 
}

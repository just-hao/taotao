package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.taotao.controller 
 * @author: wang   
 * @date: 2018年5月12日 下午3:21:07 
 * @Description: 
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value ="/item", method=RequestMethod.GET)
	@ResponseBody
	public TbItem getItemById(@RequestParam("itemId")  Long itemId){
		TbItem item = itemService.getItemByid(itemId);
		return item;
	}
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public TaotaoResult createItem(TbItem tbItem,String desc) throws Exception{
		TaotaoResult result = itemService.createItem(tbItem, desc);
		return result;
	}
	
	
}

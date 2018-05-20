package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taotao.service.ItemParamItemService;

/**
 * <p>Title: ItemParamItemController </p>
 * <p>Description: 展示商品的规格参数信息</p>
 * @author	wang
 * @date	2018年5月20日下午3:36:42
 * @version 1.0
 */
@Controller
public class ItemParamItemController {
	
	@Autowired
	private ItemParamItemService itemParamItemService;
	
	@RequestMapping("/showitem/{itemId}")
	public String showItemParam(@PathVariable long itemId,Model model){
		String itemParam = itemParamItemService.getItemParamById(itemId);
		model.addAttribute("itemParam",itemParam);
		return "item";
	}
}

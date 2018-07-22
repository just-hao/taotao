package com.taotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.service.ItemService;

/**
 * <p>Title: ItemController </p>
 * <p>Description: 导入所有信息到索引库</p>
 * @author	wang
 * @date	2018年6月3日下午4:29:16
 * @version 1.0
 */
@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	/**
	 * 导入商品信息到索引库
	 * @return
	 */
	@RequestMapping("/search/manager/importall")
	@ResponseBody
	private TaotaoResult importAllItems() {
		TaotaoResult result = itemService.importAllItems();
		return result;
	}

}

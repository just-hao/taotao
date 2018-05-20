package com.taotao.controller;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

/**
 * <p>Title: ItemParamController </p>
 * <p>Description: 商品规则参数模板管理controller</p>
 * @author	wang
 * @date	2018年5月20日上午11:11:03
 * @version 1.0
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/query/itemcatid/{itemCatId}")
	@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable long itemCatId){
		TaotaoResult result = itemParamService.getItemParamByCid(itemCatId);
		return result;
	}
	
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable long cid,String paramData){
		//创建itemparam对象
		TbItemParam tbItemParam = new TbItemParam();
		tbItemParam.setItemCatId(cid);
		tbItemParam.setParamData(paramData);
		//插入数据库
		TaotaoResult result = itemParamService.insertItemParam(tbItemParam);
		return result;
	}
}

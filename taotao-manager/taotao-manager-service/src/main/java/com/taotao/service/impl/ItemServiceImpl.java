package com.taotao.service.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;

/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: com.taotao.service 
 * @author: wang   
 * @date: 2018年5月12日 下午3:02:06 
 * @Description: 
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper tbItemMapper;
	
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Override
	public TbItem getItemByid(long id) {
		TbItem tbItem = tbItemMapper.selectById(id);
		return tbItem;
	}
	@Override
	public TaotaoResult createItem(TbItem tbItem,String desc) throws Exception {
		//生成商品的id
		long ItemId = IDUtils.genItemId();
		tbItem.setId(ItemId);
		//补全商品的信息
		//设置商品的状态 1：正常,2:下架,3:删除
		tbItem.setStatus((byte) 1);
		tbItem.setCreated(new Date());
		tbItem.setUpdated(new Date());
		//将数据插入到数据库
		tbItemMapper.insert(tbItem);
		//添加商品描述信息
		TaotaoResult result = insertTbItemDesc(ItemId, desc);
		if(result.getStatus() != 200){
			throw new Exception();
		}
		return TaotaoResult.ok();
	}
	
	/**
	 * 添加商品描述
	 * @param desc
	 */
	private TaotaoResult insertTbItemDesc(long itemId,String desc){
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(itemId);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setUpdated(new Date());
		tbItemDesc.setCreated(new Date());
		tbItemDescMapper.insert(tbItemDesc);
		return TaotaoResult.ok();
		
	}
}

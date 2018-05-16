package com.taotao.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;

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
	@Override
	public TbItem getItemByid(long id) {
		TbItem tbItem = tbItemMapper.selectById(id);
		return tbItem;
	}

}

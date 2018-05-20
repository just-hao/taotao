package com.taotao.service;



import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**
 * <p>Title: ItemService </p>
 * <p>Description: </p>
 * @author	wang
 * @date	2018年5月19日下午3:31:24
 * @version 1.0
 */
public interface ItemService {
	TbItem getItemByid(long id);
	TaotaoResult createItem(TbItem tbItem, String desc, String itemParam) throws Exception;
}

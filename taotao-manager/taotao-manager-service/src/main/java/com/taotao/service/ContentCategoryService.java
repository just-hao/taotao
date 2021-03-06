package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

public interface ContentCategoryService {
	
	List<EUTreeNode> getCatgoryList(long parentId);
	
	TaotaoResult insertContentCatgory(long parentId, String name);
	
	TaotaoResult deleteContentCategory(long parentId, long id);
}

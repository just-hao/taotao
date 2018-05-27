package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;

/**
 * <p>Title: ContentCategoryController </p>
 * <p>Description:内容分类管理 </p>
 * @author	wang
 * @date	2018年5月24日下午11:41:32
 * @version 1.0
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {
	
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EUTreeNode> getContenCatList(@RequestParam(value="id",defaultValue="0")Long parentId){
		List<EUTreeNode> list = contentCategoryService.getCatgoryList(parentId);
		return list;
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public TaotaoResult createContentCategory(long parentId, String name){
		TaotaoResult result = contentCategoryService.insertContentCatgory(parentId, name);
		return result;
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContentCategory(@RequestParam(value="parentId",defaultValue="0")Long parentId, long id){
		return contentCategoryService.deleteContentCategory(parentId, id);
	}
}

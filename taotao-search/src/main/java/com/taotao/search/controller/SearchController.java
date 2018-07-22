package com.taotao.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;

/**
 * <p>Title: SearchController </p>
 * <p>Description: 查询商品controller</p>
 * @author	wang
 * @date	2018年6月3日下午4:42:03
 * @version 1.0
 */
@Controller
public class SearchController {
	
	@Autowired
//	private SearchService searchService;
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public TaotaoResult search(@RequestParam("q")String queryString,
			@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="60")Integer rows){
		if(StringUtils.isBlank(queryString)){
			return TaotaoResult.build(400, "查询条件不能为空");
		}
		
		return null;
	}
}

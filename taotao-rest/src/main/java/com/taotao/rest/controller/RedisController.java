package com.taotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.rest.service.RedisService;

/**
 * <p>Title: RedisController </p>
 * <p>Description: 缓存同步</p>
 * @author	wang
 * @date	2018年5月29日下午11:30:23
 * @version 1.0
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {
	
	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentId}")
	@ResponseBody
	public TaotaoResult contentCacheSync(@PathVariable long contentCid) {
		TaotaoResult result = redisService.syncContent(contentCid);
		return result;
	}
}

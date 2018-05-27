package com.taotao.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.pojo.TbContent;
import com.taotao.portal.service.ContentService;

/**
 * <p>Title: ContentServiceImpl </p>
 * <p>Description:调用服务层查询内容列表 </p>
 * @author	wang
 * @date	2018年5月26日下午4:39:57
 * @version 1.0
 */
@Service
public class ContentServiceImpl implements ContentService {

	private static final Class<?> TbContent = null;

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("REST_INDEX_AD_URL")
	private String REST_INDEX_AD_URL;
	
	@Override
	public String getContentList() {
		//调用服务层的服务
		String result = HttpClientUtil.doGet(REST_BASE_URL = REST_INDEX_AD_URL);
		//将字符串转换成taotaorestlt
		try {
			TaotaoResult taotaoResult = TaotaoResult.formatToList(result, TbContent.class);
			//取内容列表
			List<TbContent> list = (List<TbContent>) taotaoResult.getData();
			List<Object> resultList = new ArrayList<>();
			//创建一个jsp
			for(TbContent content :list){
				Map<Object, Object> map = new HashMap<>();
				map.put("src", content.getPic());
				map.put("height", 240);
				map.put("width", 670);
				map.put("srcB", content.getPic2());
				map.put("heightB", 240);
				map.put("widthB", 550);
				map.put("herf", content.getContent());
				map.put("alt", content.getSubTitle());
				resultList.add(map);
			}
			return JsonUtils.objectToJson(resultList);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;
	}

}

/**
 * 
 */
package com.taotao.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.taotao.common.utils.JsonUtils;
import com.taotao.service.PictureService;

/**
 * <p>Title: PictureController </p>
 * <p>Description: 上传问文件处理</p>
 * @author	wang
 * @date	2018年5月19日下午1:26:29
 * @version 1.0
 */

@Controller
public class PictureController {
	
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String pictureUpload(MultipartFile uploadFile){
		Map result = pictureService.uploadPicture(uploadFile);
		//为了保证程序的兼容性,需要将Result对象转换成json格式的字符串
		String json = JsonUtils.objectToJson(result);
		return json;
	}
}

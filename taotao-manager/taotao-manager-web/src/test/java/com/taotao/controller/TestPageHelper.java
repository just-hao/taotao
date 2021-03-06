package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

/**
 * <p>Title: TestPageHelper </p>
 * <p>Description:分页插件的测试 </p>
 * @author	wang
 * @date	2018年5月19日下午4:10:18
 * @version 1.0
 */
public class TestPageHelper {
	
	@Test
	public void testPageHelper(){
		//创建一个spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从容器中回去mapper对象
		TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
		//执行查询,并分页
		TbItemExample example = new TbItemExample();
		//分页处理
		PageHelper.startPage(2, 10);
		List<TbItem> list = itemMapper.selectByExample(example);
		//取商品列表
		for(TbItem tbItem :list){
			System.out.println(tbItem.getTitle());
		}
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("共有商品信息：" + total);
	}
}

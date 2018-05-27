package com.taotao.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;
import com.taotao.pojo.TbContentCategoryExample.Criteria;
import com.taotao.service.ContentCategoryService;
/**
 * <p>Title: ContentCategoryServiceImpl </p>
 * <p>Description:内容分类管理 </p>
 * @author	wang
 * @date	2018年5月24日下午11:38:17
 * @version 1.0
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;
	
	@Override
	public List<EUTreeNode> getCatgoryList(long parentId) {
		//根据parentid查询节点列表
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<>();
		for(TbContentCategory tbContentCategory : list){
			//创建一个节点
			EUTreeNode node = new EUTreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			resultList.add(node);
		}
		return resultList;
	}

	@Override
	public TaotaoResult insertContentCatgory(long parentId, String name) {
		TbContentCategory contentCategory = new TbContentCategory();
		contentCategory.setName(name);
		contentCategory.setIsParent(false);
		//状态值,1是正常,2是删除
		contentCategory.setStatus(1);
		contentCategory.setParentId(parentId);
		contentCategory.setSortOrder(1);
		contentCategory.setCreated(new Date());
		contentCategory.setUpdated(new Date());
		//插入记录
		contentCategoryMapper.insert(contentCategory);
		//查看父节点的isparent是不是true如果不是改成true
		TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
		//判断是否为父节点
		if (!parentCat.getIsParent()) {
			parentCat.setIsParent(true);
			//更新父节点
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		//返回结果
		return TaotaoResult.ok(contentCategory);
	}

	@Override
	public TaotaoResult deleteContentCategory(long parentId, long id) {
		//删除对应的id记录
		contentCategoryMapper.deleteByPrimaryKey(id);
		//检查父节点是否有子节点，没有的话将isparent标志设为false
		TbContentCategoryExample example = new TbContentCategoryExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		if(list.isEmpty()){
			TbContentCategory parentCat = contentCategoryMapper.selectByPrimaryKey(parentId);
			parentCat.setIsParent(false);
			contentCategoryMapper.updateByPrimaryKey(parentCat);
		}
		return TaotaoResult.ok();
	}

}

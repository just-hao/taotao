package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;

/**
 * <p>Title: ItemParamServiceImpl </p>
 * <p>Description:商品的规格参数模板 </p>
 * @author	wang
 * @date	2018年5月20日上午11:01:29
 * @version 1.0
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {
	
	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		//查询时需要包含大文本列
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断查询结果是否为空
		if (list != null && !list.isEmpty()) {
			return TaotaoResult.ok(list.get(0));
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到数据库当中
		itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

}

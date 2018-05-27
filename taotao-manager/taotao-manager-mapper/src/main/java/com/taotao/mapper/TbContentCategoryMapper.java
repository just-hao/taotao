package com.taotao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.taotao.pojo.TbContentCategory;
import com.taotao.pojo.TbContentCategoryExample;

public interface TbContentCategoryMapper {
    long countByExample(TbContentCategoryExample example);

    int deleteByExample(TbContentCategoryExample example);

    int insert(TbContentCategory record);

    int insertSelective(TbContentCategory record);

    List<TbContentCategory> selectByExample(TbContentCategoryExample example);

    int updateByExampleSelective(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);

    int updateByExample(@Param("record") TbContentCategory record, @Param("example") TbContentCategoryExample example);
    
    TbContentCategory selectByPrimaryKey(Long id);
    
    void updateByPrimaryKey(TbContentCategory parentCat);
    
    void deleteByPrimaryKey(Long id);
}
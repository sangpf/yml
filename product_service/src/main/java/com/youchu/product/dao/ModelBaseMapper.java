package com.youchu.product.dao;

import com.youchu.product.entity.ModelBase;

public interface ModelBaseMapper {
    int deleteByPrimaryKey(String id);

    int insert(ModelBase record);

    int insertSelective(ModelBase record);

    ModelBase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ModelBase record);

    int updateByPrimaryKey(ModelBase record);
}
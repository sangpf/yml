package com.youchu.product.dao;

import com.youchu.product.entity.Dict;

import java.util.List;

public interface DictDao {
    int deleteByPrimaryKey(String id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    List<Dict> getPostList();
}
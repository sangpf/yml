package com.youchu.product.dao;

import com.youchu.product.entity.LoanModelBase;

public interface LoanAssetcreditInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(LoanModelBase record);

    int insertSelective(LoanModelBase record);

    LoanModelBase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanModelBase record);

    int updateByPrimaryKey(LoanModelBase record);
}

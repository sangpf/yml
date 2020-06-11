package com.youchu.product.dao;

import com.youchu.product.entity.LoanAssetCreditInfo;

public interface LoanAssetCreditInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(LoanAssetCreditInfo record);

    int insertSelective(LoanAssetCreditInfo record);

    LoanAssetCreditInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanAssetCreditInfo record);

    int updateByPrimaryKey(LoanAssetCreditInfo record);
}
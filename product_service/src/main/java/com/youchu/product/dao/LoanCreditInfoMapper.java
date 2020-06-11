package com.youchu.product.dao;

import com.youchu.product.entity.LoanCreditInfo;

public interface LoanCreditInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(LoanCreditInfo record);

    int insertSelective(LoanCreditInfo record);

    LoanCreditInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanCreditInfo record);

    int updateByPrimaryKey(LoanCreditInfo record);
}
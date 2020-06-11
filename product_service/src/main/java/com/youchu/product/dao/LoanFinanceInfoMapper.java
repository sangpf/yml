package com.youchu.product.dao;

import com.youchu.product.entity.LoanFinanceInfo;

public interface LoanFinanceInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(LoanFinanceInfo record);

    int insertSelective(LoanFinanceInfo record);

    LoanFinanceInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanFinanceInfo record);

    int updateByPrimaryKey(LoanFinanceInfo record);
}
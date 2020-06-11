package com.youchu.product.dao;

import com.youchu.product.entity.LoanBusiness;

public interface LoanBusinessDao {
    int deleteByPrimaryKey(String bizId);

    int insert(LoanBusiness record);

    int insertSelective(LoanBusiness record);

    LoanBusiness selectByPrimaryKey(String bizId);

    int updateByPrimaryKeySelective(LoanBusiness record);

    int updateByPrimaryKey(LoanBusiness record);
}
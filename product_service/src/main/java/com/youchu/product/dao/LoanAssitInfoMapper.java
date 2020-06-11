package com.youchu.product.dao;

import com.youchu.product.entity.LoanAssitInfo;

public interface LoanAssitInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(LoanAssitInfo record);

    int insertSelective(LoanAssitInfo record);

    LoanAssitInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanAssitInfo record);

    int updateByPrimaryKey(LoanAssitInfo record);
}
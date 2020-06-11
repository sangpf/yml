package com.youchu.product.service;

import com.youchu.product.dto.LoanModelBaseDto;
import com.youchu.product.entity.LoanModelBase;
import java.util.List;

public interface LoanModelService {

    int deleteByPrimaryKey(String id);

    int insert(LoanModelBase record);

    int insertSelective(LoanModelBase record);

    LoanModelBase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LoanModelBase record);

    int updateByPrimaryKey(LoanModelBase record);

}

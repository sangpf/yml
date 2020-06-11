package com.youchu.product.service;

import com.youchu.product.dto.LoanBusinessDto;
import com.youchu.product.entity.LoanBusiness;

import java.util.List;

public interface LoanBusinessService {
    int deleteByPrimaryKey(String bizId);

    int insert(LoanBusiness record);

    int insertSelective(LoanBusiness record);

    LoanBusiness selectByPrimaryKey(String bizId);

    int updateByPrimaryKeySelective(LoanBusiness record);

    int updateByPrimaryKey(LoanBusiness record);

    List<LoanBusiness> getListByParams(LoanBusinessDto loanBusinessDto);
}
package com.youchu.product.service.impl;

import com.youchu.product.dto.LoanBusinessDto;
import com.youchu.product.entity.LoanBusiness;
import com.youchu.product.service.LoanBusinessService;

import java.util.List;

public class LoanBusinessServiceImpl implements LoanBusinessService {

    @Override
    public int deleteByPrimaryKey(String bizId) {
        return 0;
    }

    @Override
    public int insert(LoanBusiness record) {
        return 0;
    }

    @Override
    public int insertSelective(LoanBusiness record) {
        return 0;
    }

    @Override
    public LoanBusiness selectByPrimaryKey(String bizId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(LoanBusiness record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(LoanBusiness record) {
        return 0;
    }

    @Override
    public List<LoanBusiness> getListByParams(LoanBusinessDto loanBusinessDto) {
        return null;
    }
}

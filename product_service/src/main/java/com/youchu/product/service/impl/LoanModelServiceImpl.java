package com.youchu.product.service.impl;

import com.youchu.product.dao.LoanModelBaseMapper;
import com.youchu.product.entity.LoanModelBase;
import com.youchu.product.service.LoanModelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoanModelServiceImpl implements LoanModelService {

    @Resource
    private LoanModelBaseMapper loanModelDao;

    @Override
    public int deleteByPrimaryKey(String id) {
        return 0;
    }

    @Override
    public int insert(LoanModelBase record) {
        return loanModelDao.insert(record);
    }

    @Override
    public int insertSelective(LoanModelBase record) {
        return loanModelDao.insertSelective(record);
    }

    @Override
    public LoanModelBase selectByPrimaryKey(String id) {
        LoanModelBase loanModelBase = loanModelDao.selectByPrimaryKey(id);
        return loanModelBase;
    }

    @Override
    public int updateByPrimaryKeySelective(LoanModelBase record) {
        return loanModelDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LoanModelBase record) {
        return 0;
    }

}

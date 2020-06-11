package com.youchu.product.dao;

import com.youchu.product.dto.LoanModelBaseDto;
import com.youchu.product.entity.LoanModelBase;

import java.util.List;

public interface LoanModelDao {

    List<LoanModelBase> getListByParams(LoanModelBaseDto loanModelBaseDto);

    void insert(LoanModelBase loanModelBase);


}

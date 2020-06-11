package com.youchu.product.dao;

import com.youchu.product.dto.LoanBusinessDto;
import com.youchu.product.entity.LoanBusiness;

import java.util.List;

public interface LoanBusinessDao {
    /**
     * 根据参数查询列表
     */
    List<LoanBusiness> getListByParams(LoanBusinessDto loanBusinessDto);

    void insert(LoanBusiness loanBusiness);

}

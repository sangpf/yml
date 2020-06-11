package com.youchu.product.dao;

import com.youchu.product.dto.LoanReceiptDto;
import com.youchu.product.entity.LoanReceipt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoanReceiptDao {
    int deleteByPrimaryKey(String billNo);

    int insert(LoanReceipt record);

    int insertSelective(LoanReceipt record);

    LoanReceipt selectByPrimaryKey(String billNo);

    int updateByPrimaryKeySelective(LoanReceipt record);

    int updateByPrimaryKey(LoanReceipt record);

    int saveOrUpdateBatch(List<LoanReceipt> list);

    List<LoanReceipt> getListByParams(@Param("query")LoanReceiptDto loanReceiptDto);

    List<String> getOrgNameList(String orgName);

    List<LoanReceipt> getUserListByParams(@Param("query")LoanReceiptDto loanReceiptDto);
}

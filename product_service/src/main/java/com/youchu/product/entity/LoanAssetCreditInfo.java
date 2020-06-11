package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 客户资信对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanAssetCreditInfo {
    private String id;
    private String modelId;
    private String queryDate;//	征信报告查询日期	string
    private String fiveClass;//	当前企业及实际控制人征信情况（注明征信查询分类结果)	string
    private String addedOverdues;//	企业或企业主征信是否有新增逾期记录	string
    private String addedOverduesMsg;//	企业或企业主征信是否有新增逾期记录说明	string
    private String addedLoans;//	企业或企业主是否有他行新增贷款	string
    private String addedLoansMsg;//	企业或企业主是否有他行新增贷款说明	string
    private String shrinkLoanScale;//	企业或企业主是否有他行收缩贷款规模	string
    private String shrinkLoanScaleMsg;//	企业或企业主是否有他行收缩贷款规模说明	string
    private String addedGuarantees;//	企业或企业主是否有新增对外担保记录	string
    private String addedGuaranteesMsg;//	企业或企业主是否有新增对外担保记录说明	string
    private String otherSitu;//	企业或企业主征信是否有其他异常变化	string
    private String otherSituMsg;//	企业或企业主征信是否有其他异常变化说明	string

}
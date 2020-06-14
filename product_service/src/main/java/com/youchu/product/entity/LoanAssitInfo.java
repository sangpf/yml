package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 担保物信息对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanAssitInfo {
    private String assitClassification;//	类型：房地产抵押担保   融资担保机构担保	string
    private String assitName;//	押品名称；担保公司名称	string
    private String assitAddr;//	押品位置地址	string
    private String firstEstimateDate;//	首次评估情况（     年  月）	string
    private String firstEstimateValue;//	我行认定价值（万元）	string
    private String firstMortAndpleRate;//	抵质押率（%）	string
    private String lastEstimateDate;//	最近一次评估情况（     年  月）	string
    private String lastEstimateValue;//	我行认定价值	string
    private String lastMortAndpleRate;//	抵质押率	string
    private String thisEstimateDate;//	本次评估情况（     年  月）	string
    private String thisEstimateValue;//	我行认定价值	string
    private String thisMortAndpleRate;//	抵质押率	string
    private String assitChangeSuit;//	押品价值及变现能力变动情况	string
    private String cooperatStatus;//	我行合作状态	string
    private String assitFiveClass;//	风险分类	string

}
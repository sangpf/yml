package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 财务信息对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FinanceInfo {
    private String financeClassification; //  附件2；附件3	string
    private String stockLastBalance	; //存货上次全面检查或调查时余额	string
    private String stockChangSitu; //	存货本次检查存货变动情况	string
    private String stockChang30Msg; //	存货变动超过30%，原因	string
    private String busIncLastBalance; //	营业收入上次全面检查或调查时余额	string
    private String busIncChangSitu; //	营业收入本次检查营业收入变动情况	string
    private String busInc3MSitu; //	营业收入近三个月的情况	string
    private String busIncChang30Msg; //	营业收入剔除季节性因素后变动超30%，原因	string
    private String dailyExpenLastBalance; //	水、电、煤、气费其中一项或多项上次全面检查或调查时余额	string
    private String dailyExpenChangSitu; //	水、电、煤、气费其中一项或多项本次检查变动情况	string
    private String dailyExpen3MSitu; //	水、电、煤、气费其中一项或多项近三个月的情况	string
    private String dailyExpenChang30Msg	; //水、电、煤、气费其中一项或多项剔除季节性因素后变动超30%，原因	string
    private String financeMsg; //	财务状况整体说明	string
    private String colDebtBalance; //	应收票据当前余额	string
    private String colDebtLastBalance; //	应收票据上期检查（或调查）时点余额	string
    private String colDebtChang30Msg; //	应收票据变动超过30%，原因	string
    private String colCapitalBalance; //	应收账款当前余额	string
    private String colCapitalLastBalance; //	应收账款上期检查（或调查）时点余额	string
    private String colCapitalChang30Msg	; //应收账款变动超过30%，原因	string
    private String loanForBankBalance; //	银行借款当前余额	string
    private String loanForBankLastBalance; //	银行借款上期检查（或调查）时点余额	string
    private String loanForBankChang30Msg; //	银行借款变动超过30%，原因	string
    private String loanForPsonBalance; //	私人借款当前余额	string
    private String loanForPsonLastBalance; //	私人借款上期检查（或调查）时点余额	string
    private String loanForPsonChang30Msg; //	私人借款变动超过30%，原因	string
    private String payCapitalBalance; //	应付账款当前余额	string
    private String payCapitalLastBalance; //	应付账款上期检查（或调查）时点余额	string
    private String payCapitalChang30Msg	; //应付账款变动超过30%，原因	string
    private String payDebtBalance; //	应付票据当前余额	string
    private String payDebtLastBalance; //	应付票据上期检查（或调查）时点余额	string
    private String payDebtChang30Msg; //	应付票据变动超过30%，原因	string
    private String materialCost3M; //	原材料成本近三个月的情况	string
    private String materialCostChang30Msg; //	剔除季节性因素后变动超30%，原因	string
    private String emplCost3M; //	人工成本近三个月的情况	string
    private String emplCostChang30Msg; //	剔除季节性因素后变动超30%，原因	string
    private String financeCost3M; //	财务费用近三个月的情况	string
    private String financeCostChang30Msg; //	剔除季节性因素后变动超30%，原因	string
    private String payTaxAmout3M; //	纳税数额近三个月的情况	string
    private String payTaxAmoutChang30Msg; //	纳税数额剔除季节性因素后变动超30%，原因	string
    private String cash3M; //	现金流近三个月的情况	string
    private String cashChang30Msg; //	剔除季节性因素后变动超30%，原因	string
    private String profit3M; //	利润近三个月的情况	string
    private String profitChang30Msg; //	利润剔除季节性因素后变动超30%，原因	string

}

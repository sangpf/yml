package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 征信信息对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanCreditInfo {
    private String queryDateForPer; // 征信报告查询日期	string
    private String unPayOffLoanNum; // 	未结清贷款笔数	string
    private String unPayOffAmout; // 	贷款金额	string
    private String finInstitutionNum; // 	涉及金融机构	string
    private String sumBalance; // 	贷款结余合计	string
    private String debitCardNum; // 	未销户贷记卡（含准贷记）账户     个	string
    private String debitCardLineAmout; // 	授信总金额	string
    private String guaranteeNum; // 	对外担保	string
    private String guaranteeAmout; // 	担保金额	string
    private String guaranteeBalance; // 	担保结余	string
    private String existBadRecord; // 	贷款期间借款企业是否发生不良信用记录-逾期及违约	string
    private String badRecordMsg; // 	不良信用记录情况说明-逾期及违约	string
    private String existBadRecordPer; // 	贷款期间借款是否发生不良信用记录-逾期及违约	string
    private String badRecordMsgPer; // 	不良信用记录情况说明-逾期及违约	string
    private String oweTaxRecordNum; // 	借款企业共有欠税记录数	string
    private String civilJudgmentRecordNum; // 	民事判决记录数	string
    private String forceImpleRecordNum; // 	强制执行记录数	string
    private String administRecordNum; // 	行政处罚记录数	string
    private String queryDateForCom; // 	个人报告查询日期	string
    private String unPayOffLoanNumCon; // 	未结清贷款笔数-实际控股人	string
    private String unPayOffAmoutCon	; // 贷款金额-实际控股人	string
    private String finInstitutionNumCon; // 	涉及金融机构-实际控股人	string
    private String sumBalanceCon; // 	贷款结余合计-实际控股人	string
    private String debitCardNumCon; // 	未销户贷记卡（含准贷记）账户-实际控股人	string
    private String debitCardLineAmoutCon; // 	授信总金额-实际控股人	string
    private String guaranteeNumCon; // 	对外担保-实际控股人	string
    private String guaranteeAmoutCon; // 	担保金额-实际控股人	string
    private String guaranteeBalanceCon; // 	担保结余-实际控股人	string
    private String existBadRecordCon; // 	贷款期间借款企业是否发生不良信用记录-实际控股人	string
    private String badRecordMsgCon; // 	不良信用记录情况说明-实际控股人	string
    private String oweTaxRecordNumCon; // 	借款企业共有欠税记录数-实际控股人	string
    private String civilJudgmentRecordNumCon; // 	民事判决记录数-实际控股人	string
    private String forceImpleRecordNumCon; // 	强制执行记录数-实际控股人	string
    private String administRecordNumCon; // 	行政处罚记录数-实际控股人	string
    private String unPayOffLoanNumJur; // 	未结清贷款笔数-法人	string
    private String unPayOffAmoutJur; // 	贷款金额-法人	string
    private String finInstitutionNumJur; // 	涉及金融机构-法人	string
    private String sumBalanceJur; // 	贷款结余合计-法人	string
    private String debitCardNumJur; // 	未销户贷记卡（含准贷记）账户-法人	string
    private String debitCardLineAmoutJur; // 	授信总金额-法人	string
    private String guaranteeNumJur; // 	对外担保-法人	string
    private String guaranteeAmoutJur; // 	担保金额-法人	string
    private String guaranteeBalanceJur; // 	担保结余-法人	string
    private String existBadRecordJur; // 	贷款期间借款企业是否发生不良信用记录-法人	string
    private String badRecordMsgJur; // 	不良信用记录情况说明-法人	string
    private String oweTaxRecordNumJur; // 	借款企业共有欠税记录数-法人	string
    private String civilJudgmentRecordNumJur; // 	民事判决记录数-法人	string
    private String forceImpleRecordNumJur; // 	强制执行记录数-法人	string
    private String administRecordNumJur; // 	行政处罚记录数-法人	string
    private String existCreditChage1; // 	征信是否有异常变化-借款企业
    private String creditChageMsg1; // 	征信变化情况说明-借款企业
    private String existCreditChage2; // 	征信是否有异常变化-关联企业	string
    private String creditChageMsg2; // 	征信变化情况说明-关联企业	string
    private String existCreditChage3; // 	征信是否有异常变化-法人保证人	string
    private String creditChageMsg3; // 	征信变化情况说明-法人保证人	string
    private String existCreditChage4; // 	征信是否有异常变化-企业实际控制人及其配偶
    private String creditChageMsg4; // 	征信变化情况说明-企业实际控制人及其配偶
    private String existCreditChage5; // 	征信是否有异常变化-企业法定代表人及其配偶	string
    private String creditChageMsg5; // 	征信变化情况说明-企业法定代表人及其配偶	string
    private String existCreditChager6; // 	征信是否有异常变化-企业其他保证人征信	string
    private String creditChageMsg6; // 	征信变化情况说明-企业其他保证人征信	string
    private String creditClassification; // 	征信分类	string
    private String bigClassification; // 	征信大类	string

}
package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 基本模型信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanModelBase {
    private String modelId; //	模板编号
    private String bizID; //	业务编号	string
    private String checkFlag; //	是否校验	string
    private String emplCode; //	管户工号	string
    private String orgCode; //	机构编码	string
    private String orgLevel; //	机构层级	string
    private String checkType; //	检查类型	string
    private String custName; //	客户名称	string
    private String loanAmout; //	贷款金额	string
    private String checkModel; //	贷后检查模式	string
    private String lineAmout; //	授信额度金额	string
    private String yearlyInspection; //	额度年检	string
    private String lineBalance; //	授信余额	string
    private String loanBalance; //	贷款余额	string
    private String revalOfColl; //	押品重估	string
    private String collEstimateDate; //	上次抵质押物评估或重估日期
    private String collEstimateValue; //	上次抵质押物评估或重估金额
    private String collEstimateMsg; //	上次抵质押物评估或重估情况说明
    private String securityKind; //	担保方式	string
    private String otherSecurityKindMsg; //	其他担保方式填写信息
    private String repayKind; //	还款方式	string
    private String repayDate; //	还款日期	string
    private String repayAmout; //	还款金额	string
    private String contractNo; //	合同编号	string
    private String bizSubKind; //	授信业务小类	string
    private String stageData; //	还款资金落实阶段数组	array
    private String checkStage; //	检查阶段	string
    private String amoutSource; //	还款资金来源	string
    private String expectRepayDate; //	预计还款/付息时间	string
    private String practicableMsg; //	还款资金落实情况说明	string
    private String practicableCheckAddr; //	检查地点	string
    private String practicableStaff; //	接待人员	string
    private String loanLength; //	贷款期限	string
    private String loanDate; //	放款日期	string
    private String loanPurpose; //	约定用途	string
    private String payKind; //	贷款支付方式	string
    private String requireCheck	; //审批意见中首次跟踪检查要求	string
    private String checked; //	审批意见中首次跟踪检查落实情况	string
    private String specialRequireCheck; //	产品首次跟踪检查特殊要求	string
    private String specialChecked; //	产品首次跟踪检查特殊落实情况	string
    private String rateAndIntfinSerCheck; //	利率及综合金融服务的要求	string
    private String rateAndIntfinSerChecked; //	利率及综合金融服务的落实情况	string
    private String holdPensonRisk; //	实际控制人或法定代表人风险点	string
    private String managerRisk; //	管理层风险点	string
    private String otherRisk; //	近期检查发现的其他风险点	string
    private String checkAddr; //	检查地点	string
    private String cooperate; //	检查配合程度	string
    private String cooperateMsg; //检查配合程度情况说明	string
    private String addrIsChanged; //	生产经营场所是否发生变化	string
    private String addrChangedMsg; //	生产经营场所变动情况	string
    private String staff; //	接待人员	string
    private String detailMsg4useAmout; //	检查内容-资金使用情况详细说明	string
    private String msgSource; //	检查内容-提供纸质或影像资料的信息来源	string
    private String useAmoutByContract; //	是否按合同约定的用途使用信贷资金	string
    private String executeCon; //	是否履行合同约定	string
    private String ownerStruSame; //	企业实际股权结构是否与上述工商信息网查询一致	string
    private String ownerStruSameMsg; //	实际股权结构与工商信息网查询说明	string
    private String msg; //	情况说明	string
    private String IndustrycChangSiut; //	企业所在行业是否发生重大不利变化	string
    private String IndustrycChangSiutMsg; //	企业所在行业是否发生重大不利变化具体情况	string
    private String mainBusIsChanged; //	企业主营业务情况是否发生变更	string
    private String mainBusIsChangedMsg; //	企业主营业务情况是否发生变更情况	string
    private String planExpandSitu; //	企业是否有与主业无关的扩张计划	string
    private String planExpandSituMsg; //	企业是否有与主业无关的扩张计划具体情况	string
    private String hiddenTroubleSitu; //	生产经营是否存在安全隐患	string
    private String hiddenTroubleSituMsg; //	生产经营是否存在安全隐患具体情况	string
    private String purchaseCost; //	企业主要原材料或货物的采购成本是否明显上升	string
    private String purchaseCostMsg; //	企业主要原材料或货物的采购成本是否明显上升情况	string
    private String proAndOpeAbnormalSuit; //	企业生产经营是否出现异常情况	string
    private String proAndOpeAbnormalSuitMsg; //	企业生产经营是否出现异常情况说明	string
    private String saleAbnormalSuit; //	企业销售是否出现异常情况	string
    private String saleAbnormalSuitMsg; //	企业销售是否出现异常情况说明	string
    private String chainChange; //	企业上下游核心客户是否发生重大变更	string
    private String chainChangeMsg; //	企业上下游核心客户发生重大变更说明	string
    private String dailyCostDecline	; //制造型企业水、电、煤、气等资源消耗量是否较上年同期明显下降（降幅达30%）	string
    private String dailyCostDeclineMsg	; //制造型企业水、电、煤、气等资源消耗量较上年同期明显下降（降幅达30%）说明	string
    private String orderDecline; //	企业订单是否出现大幅下降（降幅达30%）	string
    private String orderDeclineMsg; //	企业订单出现大幅下降（降幅达30%）说明	string
    private String cashLastToNow; //	上次检查（或调查）至本次检查期间的现金流	string
    private String cashDecline; //	剔除季节性因素后的现金流是否有大幅下降（降幅超30%）	string
    private String cashMatchesAndProAndOpe; //	现金流与营业收入是否基本匹配	string
    private String cashOtherMsg; //	现金流其他说明	string
    private String otherSitu; //	其他情况	string
    private String summaryForAssit; //	押品检查小结	string
    private String assitOtherSuit; //	押品其他情况	string
    private String summaryForCheck; //	检查要点小结	string
    private String inspConAndSug; //	检查结论-检查结论及建议	string
    private String isAdjustLine; //	检查结论-是否建议调整额度	string
    private String adjustLine; //	检查结论-调整后额度	string

    private LoanCreditInfo creditInfoBak;  // 征信信息对象
    private LoanAssitInfo assitInfoBak;   //  担保物信息对象
    private LoanFinanceInfo financeInfoBak; // 财务信息对象
    private LoanAssetCreditInfo assetCreditInfoBak; //客户资信对象

}
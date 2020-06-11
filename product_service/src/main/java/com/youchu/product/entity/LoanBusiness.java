package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 贷后业务信息
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanBusiness {

    private String bizId; // 业务编号
    private String bizType; // 检查类型 : 首次跟踪 firstTracking, 贷后例行 routineCheck,  贷后全面 comprehensiveCheck, 落实情况 toImplementCheck, 日常 dailyCheck
    private String bizStatus; // 业务状态 : 应做 shouldDo, 已做 alreadyDo,  未做 notDo

    private String custName;  // 客户名称
    private String custCode;  // 客户编号
    private String emplCode;  //  管户编码
    private String emplName;  // 管户名称

    private String currOperator;  //  当前处理人

    private String checkModel; // 贷后检查模型 : 模版类型 m1, m2, m3

    private String billNo;  // 借据编号
    private String currency;  // 币种
    private String billAmout;  // 借据金额
    private String billLength;  // 借据期限
    private String billUnit;   // 期限单位
    private String billBeginDate; // 借据起期   yyyy-MM-dd
    private String billEndDate;  // 借据止期
    private String billBlance;   // 借据余额

    private String bizEndDate;  // 业务止期

    private String firstTrackDate; // 首次跟踪检查时间
    private String lastRoutineDate; // 上次例行检查时间
    private String lastComprehensiveDate; // 上次全面检查时间
    private String lastImplementDate;    // 上次贷后落实情况检查时间

    private String noticeDate;    // 提醒时间

}
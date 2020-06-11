package com.youchu.product.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

@Data
public class LoanReceiptExcelDto {
    @ExcelProperty("序号")
    private Long no;
    @ExcelProperty("客户名称")
    private String custName;
    @ExcelProperty("客户编号")
    private String custCode;
    @ExcelProperty("组织模式")
    private String orgModel;
    @ExcelProperty("融资模式")
    private String financingModel;
    @ExcelProperty("申报模式")
    private String declareModel;
    @ExcelProperty("银团类型")
    private String syndicationType;
    @ExcelProperty("授信品种")
    private String creditKind;
    @ExcelProperty("现业务模式")
    private String currbusModel;
    @ExcelProperty("原业务模式")
    private String oldbuModel;
    @ExcelProperty("合同金额")
    private String contAmount;
    @ExcelProperty("是否保障房")
    private String isSecurityRoom;
    @ExcelProperty("保障房类型")
    private String securityRoomType;
    @ExcelProperty("信贷业务小类")
    private String creditSubLoanKind;
    @ExcelProperty("系统合同编号")
    private String systemContractNo;
    @ExcelProperty("纸质合同编号")
    private String paperContractNo;
    @ExcelProperty("借据编号")
    private String billNo;
    @ExcelProperty("币种")
    private String currency;
    @ExcelProperty("借据金额")
    private String billAmout;
    @ExcelProperty("借据期限")
    private String billLength;
    @ExcelProperty("期限单位")
    private String billUnit;
    @ExcelProperty("借据起期")
    @DateTimeFormat("yyyy-MM-dd")
    private String billBeginDate;
    @ExcelProperty("借据止期")
    private String billEndDate;
    @ExcelProperty("借据余额")
    private String billBlance;
    @ExcelProperty("是否受托支付")
    private String isEntrustedPayment;
    @ExcelProperty("执行年利率")
    private String interestRate;
    @ExcelProperty("利率类型")
    private String interestRateType;
    @ExcelProperty("基础利率类型")
    private String baseinterestRateType;
    @ExcelProperty("利率档次")
    private String interestRateGrade;
    @ExcelProperty("利率浮动类型")
    private String interestRateFloatingType;
    @ExcelProperty("利率浮动比率")
    private String floatingRateInterestRate;
    @ExcelProperty("利率浮动值")
    private String floatingValueInterestRate;
    @ExcelProperty("利率调整方式")
    private String rateAdjustMethod;
    @ExcelProperty("还款方式")
    private String repaymentMethod;
    @ExcelProperty("付息方式")
    private String interestPaymentMethod;
    @ExcelProperty("日利率计算方式")
    private String dailyRateCalMethod;
    @ExcelProperty("结清日期")
    private String cleardate;
    @ExcelProperty("借据状态")
    private String promissoryStatus;
    @ExcelProperty("经办机构名称")
    private String orgName;
    @ExcelProperty("经办客户经理")
    private String emplName;
    @ExcelProperty("行业门类")
    private String industryCategory;
    @ExcelProperty("行业大类")
    private String industryLargeCategory;
    @ExcelProperty("行业中类")
    private String industryMiddleCategory;
    @ExcelProperty("行业小类")
    private String industrySmallCategory;
    @ExcelProperty("工信部标准企业规模")
    private String mltenterpriseScale;
    @ExcelProperty("是否科技型企业")
    private String isTechnologyCompany;
    @ExcelProperty("投向门类")
    private String headingCategory;
    @ExcelProperty("投向大类")
    private String generalCategory;
    @ExcelProperty("投向中类")
    private String middleCategory;
    @ExcelProperty("投向小类")
    private String subclassCategory;
    @ExcelProperty("主体评级")
    private String subjectRating;
    @ExcelProperty("债项评级")
    private String debtRating;
    @ExcelProperty("风险分类")
    private String riskClassification;
    @ExcelProperty("绿色信贷标识")
    private String greenCreditMark;
    @ExcelProperty("绿色信贷标识分类结果")
    private String greenCreditMarkType;
    @ExcelProperty("是否涉及环境、安全重大风险")
    private String isEnvironmentalSafetyRisk;
    @ExcelProperty("涉及环境、安全重大风险分类结果")
    private String riskResult;
    @ExcelProperty("环境社会风险分类结果")
    private String socialRisksResult;
    @ExcelProperty("是否属于PPP项目公司主体")
    private String isPppprojectCompany;
    @ExcelProperty("操作类型")
    private String operationType;
    @ExcelProperty("是否展期")
    private String isWhetherExtend;
    @ExcelProperty("农业产业化")
    private String agricultural;
    @ExcelProperty("标志")
    private String sign;
    @ExcelProperty("农业产业化和农村项目管理标志")
    private String ruralProjectsSign;
    @ExcelProperty("控股类型")
    private String holdingType;
    @ExcelProperty("客户类型")
    private String customerType;
    @ExcelProperty("所属集团信息")
    private String groupInformation;
    @ExcelProperty("一级分行")
    private String tierOneBranch;
    @ExcelProperty("二级分行")
    private String tierTwoBranch;
    @ExcelProperty("是否是存量客户营销推荐客户")
    private String isReferralsCustomer;
    @ExcelProperty("是否是二级支行营销客户")
    private String isMarketCustSubBranch;
    @ExcelProperty("存量客户编号")
    private String stockCustomerNo;
    @ExcelProperty("存量客户名称")
    private String stockCustomerName;
    @ExcelProperty("营销机构")
    private String marketingOrganization;
    @ExcelProperty("二级支行机构名称")
    private String subBranchOrgName;
    @ExcelProperty("业务涉及国家/地区")
    private String countryRegionOfBusiness;
    @ExcelProperty("是否是公司条线推荐的客户")
    private String isCompanyReferrals;
    @ExcelProperty("推荐人姓名")
    private String recommenderName;
    @ExcelProperty("推荐人工号")
    private String recommenderNumber;
    @ExcelProperty("推荐人所属一级分行")
    private String recommenderOneBranch;
    @ExcelProperty("推荐人所属二级分行")
    private String recommenderTwoBranch;
    @ExcelProperty("推荐人所属一级支行")
    private String recommenderOneSubBranch;
    @ExcelProperty("是否符合2020版人行按贷款用途划分的绿色贷款")
    private String isGreenByPur;
    @ExcelProperty("2020版人行按贷款用途划分的绿色贷款标识大类")
    private String isGreenByKind;
    @ExcelProperty("2020版人行按贷款用途划分的绿色贷款标识中类")
    private String isGreenByMidKind;
    @ExcelProperty("2020版人行按贷款用途划分的绿色贷款标识小类")
    private String isGreenBySubKind;
}

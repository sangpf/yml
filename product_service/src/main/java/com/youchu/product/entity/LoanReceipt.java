package com.youchu.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 借据实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanReceipt {
    private String billNo;

    private Long no;

    private String custName;

    private String custCode;

    private String orgModel;

    private String financingModel;

    private String declareModel;

    private String syndicationType;

    private String creditKind;

    private String currbusModel;

    private String oldbuModel;

    private String contAmount;

    private String isSecurityRoom;

    private String securityRoomType;

    private String creditSubLoanKind;

    private String systemContractNo;

    private String paperContractNo;

    private String currency;

    private String billAmout;

    private String billLength;

    private String billUnit;

    private String billBeginDate;

    private String billEndDate;

    private String billBlance;

    private String isEntrustedPayment;

    private String interestRate;

    private String interestRateType;

    private String baseinterestRateType;

    private String interestRateGrade;

    private String interestRateFloatingType;

    private String floatingRateInterestRate;

    private String floatingValueInterestRate;

    private String rateAdjustMethod;

    private String repaymentMethod;

    private String interestPaymentMethod;

    private String dailyRateCalMethod;

    private String cleardate;

    private String promissoryStatus;

    private String orgName;

    private String emplName;

    private String industryCategory;

    private String industryLargeCategory;

    private String industryMiddleCategory;

    private String industrySmallCategory;

    private String mltenterpriseScale;

    private String isTechnologyCompany;

    private String headingCategory;

    private String generalCategory;

    private String middleCategory;

    private String subclassCategory;

    private String subjectRating;

    private String debtRating;

    private String riskClassification;

    private String greenCreditMark;

    private String greenCreditMarkType;

    private String isEnvironmentalSafetyRisk;

    private String riskResult;

    private String socialRisksResult;

    private String isPppprojectCompany;

    private String operationType;

    private String isWhetherExtend;

    private String agricultural;

    private String sign;

    private String ruralProjectsSign;

    private String holdingType;

    private String customerType;

    private String groupInformation;

    private String tierOneBranch;

    private String tierTwoBranch;

    private String isReferralsCustomer;

    private String isMarketCustSubBranch;

    private String stockCustomerNo;

    private String stockCustomerName;

    private String marketingOrganization;

    private String subBranchOrgName;

    private String countryRegionOfBusiness;

    private String isCompanyReferrals;

    private String recommenderName;

    private String recommenderNumber;

    private String recommenderOneBranch;

    private String recommenderTwoBranch;

    private String recommenderOneSubBranch;

    private String isGreenByPur;

    private String isGreenByKind;

    private String isGreenByMidKind;

    private String isGreenBySubKind;

}
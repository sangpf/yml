package com.youchu.product.controller;

import com.youchu.product.common.AjaxResult;
import com.youchu.product.entity.*;
import com.youchu.product.pdfconvert.WordModel2PdfUtil;
import com.youchu.product.service.LoanModelService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/postLoan")
public class LoanModelToPdfController {

    @Resource
    private LoanModelService loanModelService;

    /**
     * 保存模版
     * @param loanModelBase
     */
    @PostMapping(value = "/insertModel")
    public AjaxResult insetLoanModel(@RequestBody LoanModelBase loanModelBase){
        try {
            loanModelService.insert(loanModelBase);

            return AjaxResult.successResult();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
    }

    @PostMapping(value = "/getLoanModel")
    public AjaxResult getLoanModel(@RequestParam("modelId") String modelId){
        try {
            LoanModelBase loanModelBase = loanModelService.selectByPrimaryKey(modelId);

            // 组装参数
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String,Object> jpg_1 = new HashMap<String, Object>();
            ArrayList<String> mapList = new ArrayList<>();
            mapList.add("D:\\dog.jpg");
            mapList.add("D:\\jpg_2.jpg");
            int width = 500;
            int height = 400;
            jpg_1.put("width", width);
            jpg_1.put("height", height);
            jpg_1.put("type", "jpg");
            jpg_1.put("content", "D:\\dog.jpg");

            Map<String,Object> jpg_2 = new HashMap<String, Object>();
            jpg_2.put("width", width);
            jpg_2.put("height", height);
            jpg_2.put("type", "jpg");
            jpg_2.put("content", "D:\\jpg_2.jpg");

            Map<String,Object> jpg_3 = new HashMap<String, Object>();
            jpg_3.put("width", width);
            jpg_3.put("height", height);
            jpg_3.put("type", "jpg");
            jpg_3.put("content", "D:\\jpg_3.jpg");

            Map<String,Object> c1 = new HashMap<String, Object>();
            c1.put("width", 15);
            c1.put("height", 15);
            c1.put("type", "jpg");
            c1.put("content", "D:\\c1.jpg");

            Map<String,Object> cc = new HashMap<String, Object>();
            cc.put("width", 15);
            cc.put("height", 15);
            cc.put("type", "jpg");
            cc.put("content", "D:\\cc.jpg");

            ArrayList<String> payKindCheck = new ArrayList<>();
            payKindCheck.add("0");
            payKindCheck.add("1");
            payKindCheck.add("0");

            param.put("cc", cc);
            param.put("c1", c1);
            param.put("m1_1", jpg_1);
            param.put("m1_2", jpg_2);
            param.put("m1_3", jpg_3);

            // 基本信息
            param.put("custName", loanModelBase.getCustName());
            param.put("loanAmout", loanModelBase.getLoanAmout());
            param.put("checkModel", loanModelBase.getCheckModel());
            param.put("lineAmout", loanModelBase.getLineAmout());
            param.put("yearlyInspection", loanModelBase.getYearlyInspection());
            param.put("lineBalance", loanModelBase.getLineBalance());
            param.put("loanBalance", loanModelBase.getLoanBalance());
            param.put("revalOfColl", loanModelBase.getRevalOfColl());
            param.put("collEstimateDate", loanModelBase.getCollEstimateDate());
            param.put("collEstimateValue", loanModelBase.getCollEstimateValue());
            param.put("collEstimateMsg", loanModelBase.getCollEstimateMsg());
            param.put("securityKind", loanModelBase.getSecurityKind());
            param.put("otherSecurityKindMsg", loanModelBase.getOtherSecurityKindMsg());
            param.put("repayKind", loanModelBase.getRepayKind());
            param.put("repayDate", loanModelBase.getRepayDate());
            param.put("repayAmout", loanModelBase.getRepayAmout());
            param.put("contractNo", loanModelBase.getContractNo());
            param.put("bizSubKind", loanModelBase.getBizSubKind());
            param.put("stageData", loanModelBase.getStageData());
            param.put("checkStage", loanModelBase.getCheckStage());
            param.put("amoutSource", loanModelBase.getAmoutSource());
            param.put("expectRepayDate", loanModelBase.getExpectRepayDate());
            param.put("practicableMsg", loanModelBase.getPracticableMsg());
            param.put("practicableCheckAddr", loanModelBase.getPracticableCheckAddr());
            param.put("practicableStaff", loanModelBase.getPracticableStaff());
            param.put("loanLength", loanModelBase.getLoanLength());
            param.put("loanDate", loanModelBase.getLoanDate());
            param.put("loanPurpose", loanModelBase.getLoanPurpose());
            param.put("payKind", loanModelBase.getPayKind());
            param.put("requireCheck", loanModelBase.getRequireCheck());
            param.put("checked", loanModelBase.getChecked());
            param.put("specialRequireCheck", loanModelBase.getSpecialRequireCheck());
            param.put("specialChecked", loanModelBase.getSpecialChecked());
            param.put("rateAndIntfinSerCheck", loanModelBase.getRateAndIntfinSerCheck());
            param.put("rateAndIntfinSerChecked", loanModelBase.getRateAndIntfinSerChecked());
            param.put("holdPensonRisk", loanModelBase.getHoldPensonRisk());
            param.put("managerRisk", loanModelBase.getManagerRisk());
            param.put("otherRisk", loanModelBase.getOtherRisk());
            param.put("checkAddr", loanModelBase.getCheckAddr());
            param.put("cooperate", loanModelBase.getCooperate());
            param.put("cooperateMsg", loanModelBase.getCooperateMsg());
            param.put("addrIsChanged", loanModelBase.getAddrIsChanged());
            param.put("addrChangedMsg", loanModelBase.getAddrChangedMsg());
            param.put("staff", loanModelBase.getStaff());
            param.put("detailMsg4useAmout", loanModelBase.getDetailMsg4useAmout());
            param.put("msgSource", loanModelBase.getMsgSource());
            param.put("useAmoutByContract", loanModelBase.getUseAmoutByContract());
            param.put("executeCon", loanModelBase.getExecuteCon());
            param.put("ownerStruSame", loanModelBase.getOwnerStruSame());
            param.put("msg", loanModelBase.getMsg());
            param.put("IndustrycChangSiut", loanModelBase.getIndustrycChangSiut());
            param.put("IndustrycChangSiutMsg", loanModelBase.getIndustrycChangSiutMsg());
            param.put("mainBusIsChanged", loanModelBase.getMainBusIsChanged());
            param.put("mainBusIsChangedMsg", loanModelBase.getMainBusIsChangedMsg());
            param.put("planExpandSitu", loanModelBase.getPlanExpandSitu());
            param.put("planExpandSituMsg", loanModelBase.getPlanExpandSituMsg());
            param.put("hiddenTroubleSitu", loanModelBase.getHiddenTroubleSitu());
            param.put("hiddenTroubleSituMsg", loanModelBase.getHiddenTroubleSituMsg());
            param.put("purchaseCost", loanModelBase.getPurchaseCost());
            param.put("purchaseCostMsg", loanModelBase.getPurchaseCostMsg());
            param.put("proAndOpeAbnormalSuit", loanModelBase.getProAndOpeAbnormalSuit());
            param.put("proAndOpeAbnormalSuitMsg", loanModelBase.getProAndOpeAbnormalSuitMsg());
            param.put("saleAbnormalSuit", loanModelBase.getSaleAbnormalSuit());
            param.put("saleAbnormalSuitMsg", loanModelBase.getSaleAbnormalSuitMsg());
            param.put("chainChange", loanModelBase.getChainChange());
            param.put("chainChangeMsg", loanModelBase.getChainChangeMsg());
            param.put("dailyCostDecline", loanModelBase.getDailyCostDecline());
            param.put("dailyCostDeclineMsg", loanModelBase.getDailyCostDeclineMsg());
            param.put("orderDecline", loanModelBase.getOrderDecline());
            param.put("orderDeclineMsg", loanModelBase.getOrderDeclineMsg());
            param.put("cashLastToNow", loanModelBase.getCashLastToNow());
            param.put("cashDecline", loanModelBase.getCashDecline());
            param.put("cashMatchesAndProAndOpe", loanModelBase.getCashMatchesAndProAndOpe());
            param.put("cashOtherMsg", loanModelBase.getCashOtherMsg());
            param.put("otherSitu", loanModelBase.getOtherSitu());
            param.put("summaryForAssit", loanModelBase.getSummaryForAssit());
            param.put("assitOtherSuit", loanModelBase.getAssitOtherSuit());
            param.put("summaryForCheck", loanModelBase.getSummaryForCheck());
            param.put("inspConAndSug", loanModelBase.getInspConAndSug());
            param.put("isAdjustLine", loanModelBase.getIsAdjustLine());
            param.put("adjustLine", loanModelBase.getAdjustLine());

            // 征信信息对象
            LoanCreditInfo creditInfoBak = loanModelBase.getCreditInfoBak();
            param.put("queryDateForPer", creditInfoBak.getQueryDateForPer());
            param.put("unPayOffLoanNum", creditInfoBak.getUnPayOffLoanNum());
            param.put("unPayOffAmout", creditInfoBak.getUnPayOffAmout());
            param.put("finInstitutionNum", creditInfoBak.getFinInstitutionNum());
            param.put("sumBalance", creditInfoBak.getSumBalance());
            param.put("debitCardNum", creditInfoBak.getDebitCardNum());
            param.put("debitCardLineAmout", creditInfoBak.getDebitCardLineAmout());
            param.put("guaranteeNum", creditInfoBak.getGuaranteeNum());
            param.put("guaranteeAmout", creditInfoBak.getGuaranteeAmout());
            param.put("guaranteeBalance", creditInfoBak.getGuaranteeBalance());
            param.put("existBadRecord", creditInfoBak.getExistBadRecord());
            param.put("badRecordMsg", creditInfoBak.getBadRecordMsg());
            param.put("existBadRecordPer", creditInfoBak.getExistBadRecordPer());
            param.put("badRecordMsgPer", creditInfoBak.getBadRecordMsgPer());
            param.put("oweTaxRecordNum", creditInfoBak.getOweTaxRecordNum());
            param.put("civilJudgmentRecordNum", creditInfoBak.getCivilJudgmentRecordNum());
            param.put("forceImpleRecordNum", creditInfoBak.getForceImpleRecordNum());
            param.put("administRecordNum", creditInfoBak.getAdministRecordNum());
            param.put("queryDateForCom", creditInfoBak.getQueryDateForCom());
            param.put("unPayOffLoanNumCon", creditInfoBak.getUnPayOffLoanNumCon());
            param.put("unPayOffAmoutCon", creditInfoBak.getUnPayOffAmoutCon());
            param.put("finInstitutionNumCon", creditInfoBak.getFinInstitutionNumCon());
            param.put("sumBalanceCon", creditInfoBak.getSumBalanceCon());
            param.put("debitCardNumCon", creditInfoBak.getDebitCardNumCon());
            param.put("debitCardLineAmoutCon", creditInfoBak.getDebitCardLineAmoutCon());
            param.put("guaranteeNumCon", creditInfoBak.getGuaranteeNumCon());
            param.put("guaranteeAmoutCon", creditInfoBak.getGuaranteeAmoutCon());
            param.put("guaranteeBalanceCon", creditInfoBak.getGuaranteeBalanceCon());
            param.put("existBadRecordCon", creditInfoBak.getExistBadRecordCon());
            param.put("badRecordMsgCon", creditInfoBak.getBadRecordMsgCon());
            param.put("oweTaxRecordNumCon", creditInfoBak.getOweTaxRecordNumCon());
            param.put("civilJudgmentRecordNumCon", creditInfoBak.getCivilJudgmentRecordNumCon());
            param.put("forceImpleRecordNumCon", creditInfoBak.getForceImpleRecordNumCon());
            param.put("administRecordNumCon", creditInfoBak.getAdministRecordNumCon());
            param.put("unPayOffLoanNumJur", creditInfoBak.getUnPayOffLoanNumJur());
            param.put("unPayOffAmoutJur", creditInfoBak.getUnPayOffAmoutJur());
            param.put("finInstitutionNumJur", creditInfoBak.getFinInstitutionNumJur());
            param.put("sumBalanceJur", creditInfoBak.getSumBalanceJur());
            param.put("debitCardNumJur", creditInfoBak.getDebitCardNumJur());
            param.put("debitCardLineAmoutJur", creditInfoBak.getDebitCardLineAmoutJur());
            param.put("guaranteeNumJur", creditInfoBak.getGuaranteeNumJur());
            param.put("guaranteeAmoutJur", creditInfoBak.getGuaranteeAmoutJur());
            param.put("guaranteeBalanceJur", creditInfoBak.getGuaranteeBalanceJur());
            param.put("existBadRecordJur", creditInfoBak.getExistBadRecordJur());
            param.put("badRecordMsgJur", creditInfoBak.getBadRecordMsgJur());
            param.put("oweTaxRecordNumJur", creditInfoBak.getOweTaxRecordNumJur());
            param.put("civilJudgmentRecordNumJur", creditInfoBak.getCivilJudgmentRecordNumJur());
            param.put("forceImpleRecordNumJur", creditInfoBak.getForceImpleRecordNumJur());
            param.put("administRecordNumJur", creditInfoBak.getAdministRecordNumJur());
            param.put("existCreditChage1", creditInfoBak.getExistCreditChage1());
            param.put("creditChageMsg1", creditInfoBak.getCreditChageMsg1());
            param.put("existCreditChage2", creditInfoBak.getExistCreditChage2());
            param.put("creditChageMsg2", creditInfoBak.getCreditChageMsg2());
            param.put("existCreditChage3", creditInfoBak.getExistCreditChage3());
            param.put("creditChageMsg3", creditInfoBak.getCreditChageMsg3());
            param.put("existCreditChage4", creditInfoBak.getExistCreditChage4());
            param.put("creditChageMsg4", creditInfoBak.getCreditChageMsg4());
            param.put("existCreditChage5", creditInfoBak.getExistCreditChage5());
            param.put("creditChageMsg5", creditInfoBak.getCreditChageMsg5());
            param.put("existCreditChager6", creditInfoBak.getExistCreditChager6());
            param.put("creditChageMsg6", creditInfoBak.getCreditChageMsg6());
            param.put("creditClassification", creditInfoBak.getCreditClassification());
            param.put("bigClassification", creditInfoBak.getBigClassification());

            // 担保物信息对象
            LoanAssitInfo assitInfoBak = loanModelBase.getAssitInfoBak();
            param.put("assitClassification", assitInfoBak.getAssitClassification());
            param.put("assitName", assitInfoBak.getAssitName());
            param.put("assitAddr", assitInfoBak.getAssitAddr());
            param.put("firstEstimateDate", assitInfoBak.getFirstEstimateDate());
            param.put("firstEstimateValue", assitInfoBak.getFirstEstimateValue());
            param.put("firstMortAndpleRate", assitInfoBak.getFirstMortAndpleRate());
            param.put("lastEstimateDate", assitInfoBak.getLastEstimateDate());
            param.put("lastEstimateValue", assitInfoBak.getLastEstimateValue());
            param.put("lastMortAndpleRate", assitInfoBak.getLastMortAndpleRate());
            param.put("thisEstimateDate", assitInfoBak.getThisEstimateDate());
            param.put("thisEstimateValue", assitInfoBak.getThisEstimateValue());
            param.put("thisMortAndpleRate", assitInfoBak.getThisMortAndpleRate());
            param.put("assitChangeSuit", assitInfoBak.getAssitChangeSuit());
            param.put("cooperatStatus", assitInfoBak.getCooperatStatus());
            param.put("assitFiveClass", assitInfoBak.getAssitFiveClass());

            // 财务信息对象
            LoanFinanceInfo financeInfoBak = loanModelBase.getFinanceInfoBak();
            param.put("financeClassification",financeInfoBak.getFinanceClassification());
            param.put("stockLastBalance",financeInfoBak.getStockLastBalance());
            param.put("stockChangSitu",financeInfoBak.getStockChangSitu());
            param.put("stockChang30Msg",financeInfoBak.getStockChang30Msg());
            param.put("busIncLastBalance",financeInfoBak.getBusIncLastBalance());
            param.put("busIncChangSitu",financeInfoBak.getBusIncChangSitu());
            param.put("busInc3MSitu",financeInfoBak.getBusInc3MSitu());
            param.put("busIncChang30Msg",financeInfoBak.getBusIncChang30Msg());
            param.put("dailyExpenLastBalance",financeInfoBak.getDailyExpenLastBalance());
            param.put("dailyExpenChangSitu",financeInfoBak.getDailyExpenChangSitu());
            param.put("dailyExpen3MSitu",financeInfoBak.getDailyExpen3MSitu());
            param.put("dailyExpenChang30Msg",financeInfoBak.getDailyExpen3MSitu());
            param.put("financeMsg",financeInfoBak.getFinanceMsg());
            param.put("colDebtBalance",financeInfoBak.getColDebtBalance());
            param.put("colDebtLastBalance",financeInfoBak.getColDebtLastBalance());
            param.put("colDebtChang30Msg",financeInfoBak.getColDebtChang30Msg());
            param.put("colCapitalBalance",financeInfoBak.getColCapitalBalance());
            param.put("colCapitalLastBalance",financeInfoBak.getColCapitalLastBalance());
            param.put("colCapitalChang30Msg",financeInfoBak.getColCapitalChang30Msg());
            param.put("loanForBankBalance",financeInfoBak.getLoanForBankBalance());
            param.put("loanForBankLastBalance",financeInfoBak.getLoanForBankLastBalance());
            param.put("loanForBankChang30Msg",financeInfoBak.getLoanForBankChang30Msg());
            param.put("loanForPsonBalance",financeInfoBak.getLoanForPsonBalance());
            param.put("loanForPsonLastBalance",financeInfoBak.getLoanForPsonLastBalance());
            param.put("loanForPsonChang30Msg",financeInfoBak.getLoanForPsonChang30Msg());
            param.put("payCapitalBalance",financeInfoBak.getPayCapitalBalance());
            param.put("payCapitalLastBalance",financeInfoBak.getPayCapitalLastBalance());
            param.put("payCapitalChang30Msg",financeInfoBak.getPayCapitalChang30Msg());
            param.put("payDebtBalance",financeInfoBak.getPayDebtBalance());
            param.put("payDebtLastBalance",financeInfoBak.getPayDebtLastBalance());
            param.put("payDebtChang30Msg",financeInfoBak.getPayDebtChang30Msg());
            param.put("materialCost3M",financeInfoBak.getMaterialCost3M());
            param.put("materialCostChang30Msg",financeInfoBak.getMaterialCostChang30Msg());
            param.put("emplCost3M",financeInfoBak.getEmplCost3M());
            param.put("emplCostChang30Msg",financeInfoBak.getEmplCostChang30Msg());
            param.put("financeCost3M",financeInfoBak.getFinanceCost3M());
            param.put("financeCostChang30Msg",financeInfoBak.getFinanceCostChang30Msg());
            param.put("payTaxAmout3M",financeInfoBak.getPayTaxAmout3M());
            param.put("payTaxAmoutChang30Msg",financeInfoBak.getPayTaxAmoutChang30Msg());
            param.put("cash3M",financeInfoBak.getCash3M());
            param.put("cashChang30Msg",financeInfoBak.getCashChang30Msg());
            param.put("profit3M",financeInfoBak.getProfit3M());
            param.put("profitChang30Msg",financeInfoBak.getProfitChang30Msg());

            // 客户资信对象  assetCreditInfoBak
            LoanAssetCreditInfo assetCreditInfoBak = loanModelBase.getAssetCreditInfoBak();
            param.put("queryDate",assetCreditInfoBak.getQueryDate());
            param.put("fiveClass",assetCreditInfoBak.getFiveClass());
            param.put("addedOverdues",assetCreditInfoBak.getAddedOverdues());
            param.put("addedOverduesMsg",assetCreditInfoBak.getAddedOverduesMsg());
            param.put("addedLoans",assetCreditInfoBak.getAddedLoans());
            param.put("addedLoansMsg",assetCreditInfoBak.getAddedLoansMsg());
            param.put("shrinkLoanScale",assetCreditInfoBak.getShrinkLoanScale());
            param.put("shrinkLoanScaleMsg",assetCreditInfoBak.getShrinkLoanScaleMsg());
            param.put("addedGuarantees",assetCreditInfoBak.getAddedGuarantees());
            param.put("addedGuaranteesMsg",assetCreditInfoBak.getAddedGuaranteesMsg());
            param.put("otherSitu",assetCreditInfoBak.getOtherSitu());
            param.put("otherSituMsg",assetCreditInfoBak.getOtherSituMsg());

            System.out.println(param);

            AjaxResult result = WordModel2PdfUtil.generateWord2Pdf("m1", param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
    }

    @PostMapping(value = "/uploadModelFile")
    public AjaxResult uploadExcel(@RequestParam("file") MultipartFile picFile,
                                  @RequestParam("modelId") String modelId) throws Exception {
        //form表单提交的参数测试为String类型
        if (picFile == null) {
            return AjaxResult.errorResult();
        }
        // 原文件名称
        String origFileName = picFile.getOriginalFilename();
        // 储存新图片的地址
        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String pic_path = "E:\\test\\"+modelId+"\\"+yyyyMMdd;
        // 新文件名称
        String newFileName = UUID.randomUUID() + origFileName.substring(origFileName.indexOf("."));

        File newFile = new File(pic_path + newFileName);
        picFile.transferTo(newFile);

        // 将新文件的路径 返回
        AjaxResult ajaxResult = AjaxResult.successResult();
        ajaxResult.put("picUrl", pic_path + newFileName);
        return ajaxResult;
    }

}

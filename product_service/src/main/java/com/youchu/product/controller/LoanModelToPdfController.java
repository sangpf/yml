package com.youchu.product.controller;

import com.youchu.product.common.AjaxResult;
import com.youchu.product.entity.LoanModelBase;
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

            param.put("${36}", "2008");
            param.put("${37}", "08");
            param.put("${38}", "08");

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

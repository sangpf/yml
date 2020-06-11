package com.youchu.product.controller;

import com.youchu.product.common.AjaxResult;
import com.youchu.product.common.DateUtil;
import com.youchu.product.dto.LoanBusinessDto;
import com.youchu.product.dto.LoanReceiptDto;
import com.youchu.product.entity.Employee;
import com.youchu.product.entity.LoanBusiness;
import com.youchu.product.entity.LoanNotice;
import com.youchu.product.entity.LoanReceipt;
import com.youchu.product.service.EmployeeService;
import com.youchu.product.service.LoanBusinessService;
import com.youchu.product.service.LoanReceiptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 贷后检查列表
 */
@RestController
@RequestMapping("/postLoan")
public class LoanBusinessController {

    @Resource
    private LoanReceiptService loanReceiptService;
    @Resource
    private LoanBusinessService loanBusinessService;
    @Resource
    private EmployeeService employeeService;

    /**
     * 待办列表
     * 输入
     *  sysType	系统类型
     * 	emplName	管户名称
     * 	emplCode	管户编码
     * 	startDate	查询开始时间
     * 	endDate	查询结束时间
     * 	bizType	检查类型
     * 输出
     *  returnCode	成功标识
     * 	returnMsg	返回信息
     * 	itemType	提醒事项
     * 	itemRecord	记录条数
     */
    @GetMapping(value = "/noticeCheckList")
    public AjaxResult noticeCheckList(@RequestBody LoanBusinessDto loanBusinessDto){
        List<LoanBusiness> listByParams = loanBusinessService.getListByParams(loanBusinessDto);

        List<LoanNotice> dataList = new ArrayList<>();

        LoanNotice loanNotice = new LoanNotice();
        loanNotice.setItemType("1");
        loanNotice.setItemRecordNum(listByParams.size());

        LoanNotice loanNotice1 = new LoanNotice();
        loanNotice1.setItemType("2");
        loanNotice1.setItemRecordNum(100);

        dataList.add(loanNotice);
        dataList.add(loanNotice1);

        AjaxResult ajaxResult = AjaxResult.successResult(0, "success");
        ajaxResult.put("dataList", dataList);

        return ajaxResult;
    }

    /**
     * 贷后检查列表
     * returnCode	成功标识
     * returnMsg	返回信息
     * data	查询信息
     * bizInfoList	业务列表对象
     * bizId	业务id
     * bizType	检查类型
     * custNname	客户名称
     * custNo	客户编号
     * billNo	借据编号
     * noticeDate	提醒时间
     * endDate	截止时间
     * bizStatus	业务状态
     */
    @GetMapping(value = "/postLoanChecklist")
    public AjaxResult postLoanChecklist(@RequestBody LoanBusinessDto params) {
        try{
            String emplCode = params.getEmplCode();
            // 根据 经理编号 查询岗位信息表
            Employee employee = employeeService.findById(emplCode);
            String postCode = employee.getPostCode();  // 对岗位进行判断
            if ("1".equals(postCode)){  // 如果岗位不是 管户经理（贷后检查岗）则不能录入
                return null;
            }
            // 根据 系统类型, 管户名称查询台账  emplName, emplNo
            LoanReceiptDto loanReceiptDto = LoanReceiptDto.builder().emplName(employee.getEmplName()).build();
            List<LoanReceipt> loanReceiptList = loanReceiptService.getListByParams(loanReceiptDto);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            for (LoanReceipt loanReceipt: loanReceiptList){
                // 首次跟踪检查 ------------------------------------------------------------------------------------
                // 根据借据起期判断是否小于 30 天    , 借据状态为: 正常
                String custCode = loanReceipt.getCustCode();
                String custName = loanReceipt.getCustName();
                String billNo = loanReceipt.getBillNo();  // 借据编号
                String billBeginDateStr = loanReceipt.getBillBeginDate();
                Date billBeginDate = dateFormat.parse(billBeginDateStr);  // 借据起期 date
                String billEndDateStr = loanReceipt.getBillEndDate();
                Date billEndDate = dateFormat.parse(billEndDateStr);  // 借据止期
                String billStatus = loanReceipt.getPromissoryStatus();   // 借据状态
                String creditKind = loanReceipt.getCreditKind();  // 授信品种
                String creditSubLoanKind = loanReceipt.getCreditSubLoanKind(); // 信贷业务小类

                String checkModel = "";  // 模版类型 : m1 , m2 , m3
                String bizType = "";  // 检查类型 : 首次跟踪 , 贷后例行,  贷后全面 , 落实情况
                String bizStatus = ""; //

                Date trackEndDate = DateUtil.aMonthLater(billBeginDate, 1);  // 首次跟踪检查止期
                if ("正常".equals(billStatus)) {  // todo   风险分类, 借据状态 两个状态 进行判断
                    // 根据借据编号查询 贷后业务表
                    LoanBusinessDto loanBusinessDto = LoanBusinessDto.builder().billNo(billNo).build();
                    List<LoanBusiness> listByParams = loanBusinessService.getListByParams(loanBusinessDto);
                    LoanBusiness oldLoanBusiness = null;
                    if (listByParams != null && listByParams.size()>0){
                        oldLoanBusiness = listByParams.get(0);
                    }
  // 借据台账中“授信品种”为“小企业流动资金贷款”且“信贷业务小类”为“房地产抵押贷款”“担保公司担保贷款”字段，则调用附件1，
  // 若借据台账中“授信品种”为“小企业快捷贷”或“授信品种”为“小企业流动资金贷款”且“信贷业务小类”为“快捷贷”字段，则调用附件5。
                    if (creditKind.equals("小企业流动资金贷款") &&
                            (creditSubLoanKind.equals("房地产抵押贷款") || creditSubLoanKind.equals("担保公司担保贷款"))){
                        // 调用附件1
                        checkModel = "m1";  // 授信业务首次跟踪检查
                        bizType = "授信业务首次跟踪检查";
                    } else if ((creditKind.equals("小企业快捷贷") || creditKind.equals("小企业流动资金贷款"))
                            && creditSubLoanKind.equals("快捷贷")){
                        // 调用附件5
                        checkModel = "m5";  // 快捷贷首次跟踪检查
                        bizType = "快捷贷业务首次跟踪检查";
                    }
                    if (oldLoanBusiness == null){  // 未做首次跟踪检查
                        if (DateUtil.isWithOneMonth(1, trackEndDate)){  // 截至日期 1个月之内
                            // 录入到 贷后业务信息表 TB_LOAN_BUSINESS
                            LoanBusiness loanBusiness = LoanBusiness.builder()
                                    .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                    .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("应做"+bizType)
                                    .firstTrackDate("首次跟踪检查时间")
                                    .build();
                            loanBusinessService.insert(loanBusiness);
                        } else if (DateUtil.isOverTime(trackEndDate)){  // 超出时间
                            LoanBusiness loanBusiness = LoanBusiness.builder()
                                    .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                    .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("超时未做"+bizType)
                                    .firstTrackDate("首次跟踪检查时间")
                                    .build();
                            loanBusinessService.insert(loanBusiness);
                        }
                    }else {  // 已做首次跟踪检查
                        // 不处理
                    }

                }

                // 贷后全面检查 -------------------------------------------------------------------------------------
                boolean isComprehensive = false; // 近期是否做全面检查
//                “授信品种”为“小企业流动资金贷款”且“信贷业务小类”为“房地产抵押贷款”“担保公司担保贷款”字段，则调用附件3
                if (creditKind.equals("小企业流动资金贷款") &&
                        (creditSubLoanKind.equals("房地产抵押贷款") || creditSubLoanKind.equals("担保公司担保贷款"))){
                    // 授信业务全面检查 调用附件3
                    checkModel = "m3";  // 授信业务首次跟踪检查
                    bizType = "授信业务全面检查";
                    // 已例行检查(不用判断)
                    // 判断风险分类(所有风险分类都一样是6个月一次)
                    // 将借据根据客户进行分组
                    Date comprehensiveEndDate = DateUtil.aMonthLater(billBeginDate, 6);  // 6个月全面检查截至日期
                    // 判断 近期是否已做 全面检查
                    // 根据 检查类型,客户编号,上次全面检查时间是否在6个月内, 查询 贷后业务信息表  ( 检查类型 : 首次跟踪 1, 贷后例行 2,  贷后全面 3, 落实情况 4 )
                    LoanBusinessDto comprehensiveParam = LoanBusinessDto.builder().
                            bizType("检查类型").custCode("客户编号").lastComprehensiveDate("上次全面检查时间").build();
                    List<LoanBusiness> listComprehensive = loanBusinessService.getListByParams(comprehensiveParam);
                    LoanBusiness lastComprehensive = null;
                    if (listComprehensive != null && listComprehensive.size()>0){
                        lastComprehensive = listComprehensive.get(0);
                    }

                    if (lastComprehensive != null){
                        // 近期已做全面检查
                        isComprehensive = true;
                    } else {  // 未做全面检查
                        // 截至日期提前一个月发 全面检查通知
                        Boolean isComprehensiveCheck = DateUtil.isWithOneMonth(1, comprehensiveEndDate);
                        if (isComprehensiveCheck) {
                            // 需要做全面检查, 新增到 贷后业务信息表
                            LoanBusiness loanBusiness = LoanBusiness.builder()
                                    .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                    .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("应做"+bizType)
                                    .lastComprehensiveDate("上次全面检查时间")
                                    .build();
                            loanBusinessService.insert(loanBusiness);
                            isComprehensive = true;
                        } else if(DateUtil.isOverTime(comprehensiveEndDate)){  // 超时
                            // 需要做全面检查, 新增到 贷后业务信息表
                            LoanBusiness loanBusiness = LoanBusiness.builder()
                                    .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                    .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("超时未做"+bizType)
                                    .lastComprehensiveDate("上次全面检查时间")
                                    .build();
                            loanBusinessService.insert(loanBusiness);
                            isComprehensive = true;
                        }
                    }
                }

                // 贷后例行检查 ------------------------------------------------------------------------------------
                // 风险分类  正常,关注,次级,可疑,损失
                // 已做首次跟踪检查(先不判断)
                Date routineEndDate = null;  // 例行检查截至日期

                // 判断 近期有没有做全面检查
                if (!isComprehensive){ // 近期未做全面检查
                    // 判断近期 是否做例行检查
                    LoanBusinessDto routineParam = LoanBusinessDto.builder().
                            bizType("检查类型").custCode("客户编号").lastComprehensiveDate("上次例行检查时间").build();
                    List<LoanBusiness> listRoutine = loanBusinessService.getListByParams(routineParam);
                    LoanBusiness lastRoutine = null;
                    if (listRoutine != null && listRoutine.size()>0){
                        lastRoutine = listRoutine.get(0);
                    }
                    if (lastRoutine != null){
                        // 近期已 做过例行检查
                        // 不处理
                    }else {
                        // 近期未做例行检查
//                        台账中“授信品种”为“小企业流动资金贷款”且“信贷业务小类”为“房地产抵押贷款”“担保公司担保贷款”字段，则调用附件2，
//                        若借据台账中“授信品种”为“小企业快捷贷”或“授信品种”为“小企业流动资金贷款”且“信贷业务小类”为“快捷贷”字段，则调用附件6
                        if (creditKind.equals("小企业流动资金贷款") &&
                                (creditSubLoanKind.equals("房地产抵押贷款") || creditSubLoanKind.equals("担保公司担保贷款"))){
                            // 调用附件1
                            checkModel = "m2";  // 授信业务首次跟踪检查
                            bizType = "授信业务例行检查";
                        } else if ((creditKind.equals("小企业快捷贷") || creditKind.equals("小企业流动资金贷款"))
                                && creditSubLoanKind.equals("快捷贷")){
                            // 调用附件5
                            checkModel = "m6";  // 快捷贷首次跟踪检查
                            bizType = "快捷贷日常检查";
                        }

                        // 判断客户风险类别
                        // todo
                        // 判断风险分类, 根据客户编号进行分组, 如果所有借据状态为'正常' 则三个月内录入, 提前一个月题型 ,
                        // 如果存在借据状态为 '非正常' 则一个月内录入, 根据 客户编号 custNo 判断该客户的风险状态
                        int custStatus = 0;  // 客户风险状态  0 正常,  1 非正常
                        if(custStatus == 0){
                            routineEndDate = DateUtil.aMonthLater(billBeginDate, 3);   // 计算,三个月后 , 3个月截至, 往前一个月提示
                            // 判断当前日期 离 截至日期 是否在一个月内 , 是则进行 例行检查通知
                            Boolean withOneMonth = DateUtil.isWithOneMonth(1, routineEndDate);
                            if (withOneMonth) {
                                // 发起例行检查
                                LoanBusiness loanBusiness = LoanBusiness.builder()
                                        .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                        .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("应做"+bizType)
                                        .lastRoutineDate("上次例行检查时间")
                                        .build();
                                loanBusinessService.insert(loanBusiness);
                            }else if (DateUtil.isOverTime(routineEndDate)){
                                // 超时
                                LoanBusiness loanBusiness = LoanBusiness.builder()
                                        .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                        .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("超时未做"+bizType)
                                        .lastRoutineDate("上次例行检查时间")
                                        .build();
                                loanBusinessService.insert(loanBusiness);
                            }
                        } else {  // 客户风险分类 非正常
                            routineEndDate = DateUtil.aMonthLater(billBeginDate, 1);   // 计算,一个月后 , 可以直接通知
                            // 判断当前日期 离 截至日期 是否在一个月内 , 是则进行 例行检查通知
                            Boolean withOneMonth = DateUtil.isWithOneMonth(1, routineEndDate);
                            if (withOneMonth) {
                                // 发起例行检查
                                LoanBusiness loanBusiness = LoanBusiness.builder()
                                        .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                        .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("应做"+bizType)
                                        .lastRoutineDate("上次例行检查时间")
                                        .build();
                                loanBusinessService.insert(loanBusiness);
                            }else if (DateUtil.isOverTime(routineEndDate)){
                                // 超时
                                LoanBusiness loanBusiness = LoanBusiness.builder()
                                        .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                                        .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("超时未做"+bizType)
                                        .lastRoutineDate("上次例行检查时间")
                                        .build();
                                loanBusinessService.insert(loanBusiness);
                            }
                        }

                    }

                }

                // 落实情况检查 ------------------------------------------------------------------------------------
                // 根据借据止期判断, 一个月前,前3天,当天
                checkModel = "m4";  // 授信业务首次跟踪检查
                bizType = "还款资金落实情况检查";

                Boolean with1Month = DateUtil.isWithOneMonth(1, billEndDate);
                Boolean with3Day = DateUtil.isWithOneDay(3, billEndDate);
                Boolean with1Day = DateUtil.isWithOneDay(1, billEndDate);
                Boolean overTime = DateUtil.isOverTime(billEndDate);
                if (with1Month || with3Day || with1Day){
                    LoanBusiness loanBusiness = LoanBusiness.builder()
                            .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                            .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("应做"+bizType)
                            .lastImplementDate("上次贷后落实情况检查时间").build();
                    loanBusinessService.insert(loanBusiness);
                } else if (overTime){
                    LoanBusiness loanBusiness = LoanBusiness.builder()
                            .custName(custName).checkModel(checkModel).custCode(custCode).bizType(bizType)
                            .billNo(billNo).billBeginDate(billBeginDateStr).billEndDate(billEndDateStr).bizStatus("超时未做"+bizType)
                            .lastImplementDate("上次贷后落实情况检查时间").build();
                    loanBusinessService.insert(loanBusiness);
                }
            }

            // 查询 贷后业务信息表, 返回检查列表信息
            LoanBusinessDto loanBusinessDto = LoanBusinessDto.builder().emplCode(emplCode).build();
            List<LoanBusiness> loanBusinessList = loanBusinessService.getListByParams(loanBusinessDto);
            //     * dataList	查询信息
            //     * bizId	业务id
            //     * bizType	检查类型
            //     * custNname	客户名称
            //     * custNo	客户编号
            //     * billNo	借据编号
            //     * noticeDate	提醒时间
            //     * endDate	截止时间
            //     * bizStatus	业务状态
            AjaxResult dataResult = AjaxResult.successResult(0, "success");
            dataResult.put("dataList", loanBusinessList);
            return dataResult;
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
    }

}

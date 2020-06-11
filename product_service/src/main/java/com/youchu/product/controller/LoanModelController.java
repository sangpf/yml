package com.youchu.product.controller;

import com.youchu.product.common.AjaxResult;
import com.youchu.product.entity.LoanModelBase;
import com.youchu.product.service.LoanModelService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/postLoan")
public class LoanModelController {

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

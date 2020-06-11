package com.youchu.product.controller;

import com.youchu.product.common.ApiResponse;
import com.youchu.product.dto.LoanReceiptDto;
import com.youchu.product.service.LoanReceiptService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/loanReceipt")
public class LoanReceiptController {

    @Resource
    private LoanReceiptService loanReceiptService;

    @GetMapping(value = "/getListByParams")
    public ApiResponse getListByParams(@RequestBody LoanReceiptDto loanReceiptDto) {
        return ApiResponse.successApiResponse(loanReceiptService.getListByParams(loanReceiptDto));
    }

    @GetMapping(value = "/getOrgNameList")
    public ApiResponse getOrgNameList(String agencyName) {
        return ApiResponse.successApiResponse(loanReceiptService.getOrgNameList(agencyName));
    }

    @PostMapping(value = "/uploadExcel")
    public ApiResponse uploadExcel(@RequestParam("file") MultipartFile file) {
        loanReceiptService.uploadExcel(file);
        return loanReceiptService.uploadExcel(file);
    }
}

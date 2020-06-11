package com.youchu.product.controller;

import com.youchu.product.common.ApiResponse;
import com.youchu.product.dto.EmployeeDto;
import com.youchu.product.service.DictService;
import com.youchu.product.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dict")
public class DictController {

    @Resource
    private DictService dictService;

    @GetMapping(value = "/getPostList")
    public ApiResponse getPostList() {
        return ApiResponse.successApiResponse(dictService.getPostList());
    }


}

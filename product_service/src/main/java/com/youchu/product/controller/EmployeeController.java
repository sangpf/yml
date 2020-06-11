package com.youchu.product.controller;

import com.youchu.product.common.ApiResponse;
import com.youchu.product.dto.EmployeeDto;
import com.youchu.product.entity.Employee;
import com.youchu.product.service.EmployeeService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping(value = "/findById")
    public ApiResponse findById(@RequestParam String id) {
        return ApiResponse.successApiResponse(employeeService.findById(id));
    }

    @GetMapping(value = "/save")
    public ApiResponse save(@RequestBody EmployeeDto employeeDto) {
        return ApiResponse.successApiResponse(employeeService.save(employeeDto));
    }

    @GetMapping(value = "/update")
    public ApiResponse update(@RequestBody EmployeeDto employeeDto) {
        if (!employeeDto.getEmplCode().isEmpty() || !employeeDto.getEmplName().isEmpty()){
            return ApiResponse.errorApiResponse("用户名称和编码不可修改");
        }
        return ApiResponse.successApiResponse(employeeService.update(employeeDto));
    }

    @GetMapping(value = "/delete")
    public ApiResponse delete(@RequestParam String id) {
        return ApiResponse.successApiResponse(employeeService.delete(id));
    }

    @GetMapping(value = "/getListByParams")
    public ApiResponse getListByParams(@RequestBody EmployeeDto employeeDto) {
        return ApiResponse.successApiResponse(employeeService.getListByParams(employeeDto));
    }

}

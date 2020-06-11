package com.youchu.product.service;

import cn.hutool.json.JSONUtil;
import com.youchu.product.entity.Employee;
import org.junit.Test;

import javax.annotation.Resource;

public class EmployeeServiceTest extends BaseTest {

    @Resource
    private EmployeeService employeeService;

    @Test
    public void findById() {
        Employee aaa = employeeService.findById("abcde");
        System.out.println(JSONUtil.toJsonStr(aaa));
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}

package com.youchu.product.service;

import com.youchu.product.dto.EmployeeDto;
import com.youchu.product.entity.Dict;
import com.youchu.product.entity.Employee;

import java.util.List;

public interface DictService {

    /**
     * 获取岗位列表
     */
    List<Dict> getPostList();
}

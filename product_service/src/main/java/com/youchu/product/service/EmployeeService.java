package com.youchu.product.service;

import com.youchu.product.dto.EmployeeDto;
import com.youchu.product.entity.Employee;

public interface EmployeeService {

    /**
     * 根据id查询
     */
    Employee findById(String id);

    /**
     * 保存
     */
    Integer save(EmployeeDto employeeDto);

    /**
     * 更新
     */
    Integer update(EmployeeDto employeeDto);

    /**
     * 删除
     */
    Integer delete(String id);
}

package com.youchu.product.dao;

import com.youchu.product.dto.EmployeeDto;
import com.youchu.product.dto.LoanReceiptDto;
import com.youchu.product.entity.Employee;
import com.youchu.product.entity.LoanReceipt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口继承
 */
public interface EmployeeDao {

    int deleteByPrimaryKey(String id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getListByParams(@Param("query") EmployeeDto employeeDto);
}

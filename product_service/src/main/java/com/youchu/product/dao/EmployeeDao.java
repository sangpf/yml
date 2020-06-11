package com.youchu.product.dao;

import com.youchu.product.entity.Employee;

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
}

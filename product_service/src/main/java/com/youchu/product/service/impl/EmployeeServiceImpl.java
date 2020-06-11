package com.youchu.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.youchu.product.dao.EmployeeDao;
import com.youchu.product.dto.EmployeeDto;
import com.youchu.product.entity.Employee;
import com.youchu.product.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;


    @Override
    public Employee findById(String id) {
        return employeeDao.selectByPrimaryKey(id);
    }

    @Override
    public Integer save(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .id(IdUtil.simpleUUID())
                .createTime(DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss"))
                .updateTime(DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss"))
                .build();
        BeanUtil.copyProperties(employeeDto,employee);
        return employeeDao.insertSelective(employee);
    }

    @Override
    public Integer update(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .updateTime(DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss"))
                .build();
        BeanUtil.copyProperties(employeeDto,employee);
        return employeeDao.updateByPrimaryKey(employee);
    }

    @Override
    public Integer delete(String id) {
        Employee employee = Employee.builder()
                .updateTime(DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss"))
                .isDelete("y")
                .build();
        return employeeDao.updateByPrimaryKey(employee);
    }

    @Override
    public List<Employee> getListByParams(EmployeeDto employeeDto) {
        return employeeDao.getListByParams(employeeDto);
    }
}

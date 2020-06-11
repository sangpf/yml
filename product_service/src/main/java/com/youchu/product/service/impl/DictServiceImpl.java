package com.youchu.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.youchu.product.dao.DictDao;
import com.youchu.product.dao.EmployeeDao;
import com.youchu.product.dto.EmployeeDto;
import com.youchu.product.entity.Dict;
import com.youchu.product.entity.Employee;
import com.youchu.product.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DictServiceImpl implements DictService {

    @Resource
    private DictDao dictDao;

    @Override
    public List<Dict> getPostList() {
        return dictDao.getPostList();
    }

}

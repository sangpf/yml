package com.youchu.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.youchu.product.common.ApiResponse;
import com.youchu.product.dao.LoanReceiptDao;
import com.youchu.product.dto.LoanReceiptDto;
import com.youchu.product.dto.LoanReceiptExcelDto;
import com.youchu.product.entity.LoanReceipt;
import com.youchu.product.listener.LoanReceiptDataListener;
import com.youchu.product.service.LoanReceiptService;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class LoanReceiptServiceImpl implements LoanReceiptService {

    @Resource
    private LoanReceiptDao loanReceiptDao;

    @Override
    public List<LoanReceipt> getListByParams(LoanReceiptDto loanReceiptDto) {
        String queryType = loanReceiptDto.getQueryType();
        List<LoanReceipt> listByParams = Lists.newArrayList();
        if (Objects.equals("1", queryType)) {
            listByParams = loanReceiptDao.getListByParams(loanReceiptDto);
        } else if (Objects.equals("2", queryType)) {
            listByParams = loanReceiptDao.getListByParams(loanReceiptDto);
        } else if (Objects.equals("3", queryType)) {
            listByParams = loanReceiptDao.getUserListByParams(loanReceiptDto);
        }
        return listByParams;
    }

    @Override
    public List<String> getOrgNameList(String orgName) {
        return loanReceiptDao.getOrgNameList(orgName);
    }

    @Override
    public ApiResponse uploadExcel(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            LoanReceiptDataListener loanReceiptDataListener = new LoanReceiptDataListener();
            EasyExcel.read(inputStream, LoanReceiptExcelDto.class, loanReceiptDataListener).sheet().doRead();
            Map<Integer, String> headMap = loanReceiptDataListener.getHeadMap();
            if (headMap.size() != 86) {
                return ApiResponse.errorApiResponse("导入数据格式错误，请确认");
            }
            List<LoanReceiptExcelDto> excelDtoList = loanReceiptDataListener.getList();
            if (excelDtoList.size() <= 0) {
                return ApiResponse.errorApiResponse("无需要导入的数据，请确认");
            }
            excelDtoList.forEach(item -> {
                item.getCustName().trim();
                item.getCustCode().trim();
                item.getSystemContractNo().trim();
                item.getPaperContractNo().trim();
                item.getCurrency().trim();
                item.getBillEndDate().trim();
                item.getPromissoryStatus().trim();
                item.getEmplName().trim();
            });
            List<LoanReceipt> list = new ArrayList<>();
            BeanUtil.copyProperties(excelDtoList, list);
            loanReceiptDao.saveOrUpdateBatch(list);
            return ApiResponse.builder().status(ApiResponse.DEFAULT_STATUS_SUCCESS).msg("操作成功").build();
        } catch (IOException e) {
            e.printStackTrace();
            return ApiResponse.errorApiResponse(e.getMessage());
        }
    }

}

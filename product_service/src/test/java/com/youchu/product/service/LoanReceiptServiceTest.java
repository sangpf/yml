package com.youchu.product.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.vip.vjtools.vjkit.mapper.BeanMapper;
import com.vip.vjtools.vjkit.mapper.JsonMapper;
import com.youchu.product.common.ApiResponse;
import com.youchu.product.dao.LoanReceiptDao;
import com.youchu.product.dto.LoanReceiptExcelDto;
import com.youchu.product.entity.Employee;
import com.youchu.product.entity.LoanReceipt;
import com.youchu.product.listener.LoanReceiptDataListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class LoanReceiptServiceTest extends BaseTest {

    @Resource
    private LoanReceiptDao loanReceiptDao;

    @Test
    public void uploadExcel() {
        File file = new File("C:\\Users\\linqilei\\Desktop\\小企业2020年04月台账.xls");
        try {
            InputStream inputStream = new FileInputStream(file);
            LoanReceiptDataListener loanReceiptDataListener = new LoanReceiptDataListener();
            EasyExcel.read(inputStream, LoanReceiptExcelDto.class, loanReceiptDataListener).sheet().doRead();
            Map<Integer, String> headMap = loanReceiptDataListener.getHeadMap();
            if (headMap.size() != 86) {
                log.info("导入数据格式错误，请确认");
            }
            List<LoanReceiptExcelDto> excelDtoList = loanReceiptDataListener.getList();
            if (excelDtoList.size() <= 0) {
                log.info("无需要导入的数据，请确认");
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
            List<LoanReceipt> list = BeanMapper.mapList(excelDtoList, LoanReceipt.class);
            log.info("list内容 : {}",JSONUtil.toJsonStr(list));
            loanReceiptDao.saveOrUpdateBatch(list);
            log.info("操作成功");
        } catch (IOException e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
    }

}

package com.youchu.product.listener;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.youchu.product.dto.LoanReceiptExcelDto;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class LoanReceiptDataListener extends AnalysisEventListener<LoanReceiptExcelDto> {

    List<LoanReceiptExcelDto> list = new ArrayList<LoanReceiptExcelDto>();

    Map<Integer, String> map = new HashMap<>();

    public List<LoanReceiptExcelDto> getList() {
        return list;
    }

    public Map<Integer, String> getHeadMap() {
        return map;
    }

    /**
     * 读取表头数据
     *
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("表头数据:{}", JSONUtil.toJsonStr(headMap));
        map = headMap;

    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     * @param context
     */
    @Override
    public void invoke(LoanReceiptExcelDto data, AnalysisContext context) {
        log.info("解析到一条数据:{}", JSONUtil.toJsonStr(data));
        list.add(data);
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
//        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        log.info("存储数据库成功！");
    }
}

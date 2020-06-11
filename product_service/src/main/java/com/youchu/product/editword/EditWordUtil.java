package com.youchu.product.editword;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * word 文档 定义 ${key}
 * 后端替换 key 值
 */
public class EditWordUtil {

    public static void CreatWordByModel(String  tmpFile, Map<String, String> contentMap, String exportFile) throws Exception{
        InputStream in = null;
        in = new FileInputStream(new File(tmpFile));

        HWPFDocument document = null;
        document = new HWPFDocument(in);
        // 读取文本内容
        Range bodyRange = document.getRange();
        // 替换内容
        for (Map.Entry<String, String> entry : contentMap.entrySet()) {
            bodyRange.replaceText("${" + entry.getKey() + "}", entry.getValue());
        }
        OutputStream out = null;
        //导出到文件
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.write((OutputStream)byteArrayOutputStream);
            out = new FileOutputStream(exportFile);
            out.write(byteArrayOutputStream.toByteArray());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            in.close();
            document.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        map.put("name","刁某某");
        map.put("jine","999.89");
        map.put("qixian","24期");
        map.put("fkrq","2020-08-09");
        map.put("c1","25CE");
        map.put("c2","◎");
        map.put("c3","□");
        map.put("k1","员工工资,办公设备采购");
        map.put("k2","员工工资,办公设备采购");
        map.put("k3","情况说明");
        map.put("k4","淘气");
        map.put("k5","2020");
        map.put("k6","08");
        map.put("k7","10");
        map.put("k8","检查结论及措施建议");
        map.put("ydyt","员工工资,办公设备采购^p按时吃饭" +
                "不定时的打卡");
        CreatWordByModel("D:/100.doc", map,"D:/downWord.doc");
    }


}

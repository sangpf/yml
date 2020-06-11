package com.youchu.product.pdfconvert;

import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *  模版 m6 动态新增 押品名称
 */
public class EditRowUtil {

    public static void main(String[] args) {
        editM6Row("D:\\m6.docx");
    }

    /**
     * m6 快捷贷日常检查 模版 动态修改 押品名称 增加 row
     */
    public static void editM6Row(String m6url){
        try {
            String inPath= m6url;
            String outPath= "D:\\m6_new.docx";
            FileInputStream in = new FileInputStream(inPath);
            XWPFDocument document = new XWPFDocument(in);
            List<XWPFTable> tables = document.getTables();//获取word中所有的表格

            FileOutputStream out = new FileOutputStream(outPath);
            XWPFTable table = tables.get(0);//获取第一个表格

            List<XWPFTableRow> rows = table.getRows();

            int rowNum = 0;
            int targetNum = 0;
            for (XWPFTableRow row : rows){
                List<XWPFTableCell> tableCells = row.getTableCells();
                for (XWPFTableCell cell : tableCells){
                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    String text = paragraphs.get(0).getText();
                    if (text.equals("押品名称")){
                        targetNum = rowNum+2;
                    }
                }
                rowNum++;
            }

            WordModel2PdfUtil.insertRow(table, targetNum, targetNum+1);//此方法在下方，直接复制拿走

            XWPFTableRow row = table.getRow(targetNum);
            List<XWPFTableCell> tableCells = row.getTableCells();

            XWPFTableCell cell_0 = tableCells.get(0);
            XWPFTableCell cell_1 = tableCells.get(1);
            XWPFTableCell cell_2 = tableCells.get(2);
            XWPFTableCell cell_3 = tableCells.get(3);

            cell_0.setText("iphone8");
            cell_1.setText("秦淮区58号");
            cell_2.setText("1");
            cell_3.setText("50");

            System.out.println(targetNum);

            document.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

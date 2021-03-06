package com.youchu.product.pdftool;

import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

/**
 * 给 pdf 文档添加水印
 */
public class WaterPrintUtil {

    public static void main(String[] args) throws DocumentException, IOException {
        GenerateWatermark("D:\\tempFile\\word\\10001.pdf", "D:\\tempFile\\word\\10002.pdf");
    }

    public static void GenerateWatermark(String inPdf, String outPdf){
        // 要输出的pdf文件
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(outPdf)));
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            // 将pdf文件先加水印然后输出
            setWatermark(bos, inPdf, format.format(cal.getTime()) + "  下载使用人：" + "测试user", 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *  bos   输出文件的位置
     * @param input  原PDF位置
     * @param waterMarkName 页脚添加水印
     * @param permission  权限码
     * @throws DocumentException
     * @throws IOException
     */
    public static void setWatermark(BufferedOutputStream bos, String input, String waterMarkName, int permission)
            throws DocumentException, IOException {
        PdfReader reader = new PdfReader(input);
        PdfStamper stamper = new PdfStamper(reader, bos);
        int total = reader.getNumberOfPages() + 1;
        PdfContentByte content;
//        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
        BaseFont base = BaseFont.createFont("D:\\work_space\\yc\\YOU\\product_service\\src\\main\\resources\\msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        PdfGState gs = new PdfGState();
        for (int i = 1; i < total; i++) {
//            content = stamper.getOverContent(i);// 在内容上方加水印
            content = stamper.getUnderContent(i);//在内容下方加水印
            gs.setFillOpacity(0.2f);
            // content.setGState(gs);
            content.beginText();
            content.setColorFill(Color.LIGHT_GRAY);
            content.setFontAndSize(base, 75);
            content.setTextMatrix(70, 200);
            content.showTextAligned(Element.ALIGN_CENTER, "0000000000桑朋飞", 300, 350, 35);
//            Image image = Image.getInstance("D:/water.jpg");
            /*
              img.setAlignment(Image.LEFT | Image.TEXTWRAP);
              img.setBorder(Image.BOX); img.setBorderWidth(10);
              img.setBorderColor(BaseColor.WHITE); img.scaleToFit(100072);//大小
              img.setRotationDegrees(-30);//旋转
             */
//            image.setAbsolutePosition(200, 206); // set the first background
            // image of the absolute
//            image.scaleToFit(200, 200);
//            content.addImage(image);   // 设置 添加图片水印
            content.setColorFill(Color.BLACK);
            content.setFontAndSize(base, 8);
            content.showTextAligned(Element.ALIGN_CENTER, "下载时间：" + waterMarkName + "", 300, 10, 0);
            content.endText();

        }
        stamper.close();
    }

}

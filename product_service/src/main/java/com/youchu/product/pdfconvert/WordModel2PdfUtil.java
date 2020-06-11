package com.youchu.product.pdfconvert;

import java.io.*;
import java.net.URLEncoder;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youchu.product.common.AjaxResult;
import com.youchu.product.pdftool.WaterPrintUtil;
import com.youchu.product.pythontool.HelloPython;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * 1,通过给word文档增加标签的方式, 达到编辑word的目的
 * 2,word转pdf 通过调用python实现
 * 3,加水印
 * Word工具类(带导出)
 * 依赖外部jar ：poi version 3.9
 * 支持 word 2003+
 */
public class WordModel2PdfUtil {

    public static String tempFilePath = "D:/tempFile/word/";

    public static void main(String[] args) throws Exception{
        Map<String, Object> result = null;
        try {
            result = generateWord2Pdf("", new HashMap<>());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

    public static AjaxResult generateWord2Pdf_1(){
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String,Object> c1 = new HashMap<String, Object>();
        c1.put("width", 15);
        c1.put("height", 15);
        c1.put("type", "jpg");
        c1.put("content", "D:\\c1.jpg");

        Map<String,Object> cc = new HashMap<String, Object>();
        cc.put("width", 15);
        cc.put("height", 15);
        cc.put("type", "jpg");
        cc.put("content", "D:\\cc.jpg");

        Map<String,Object> jpg_1 = new HashMap<String, Object>();
        jpg_1.put("width", 300);
        jpg_1.put("height", 150);
        jpg_1.put("type", "jpg");
        jpg_1.put("content", "D:\\dog.jpg");

        param.put("${cc}", cc);
        param.put("${c1}", c1);
        param.put("${name}", "李明");
        param.put("${jpg_1}", jpg_1);

        System.out.println(param);

        try {
            String result = replaceAndGenerateWord("D:\\123.docx", param,
                    "100000012.docx", null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();
    }

    public static AjaxResult generateWord2Pdf(String modelType, Map<String, Object> param1) throws Exception{
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String,Object> jpg_1 = new HashMap<String, Object>();
        ArrayList<String> mapList = new ArrayList<>();
        mapList.add("D:\\dog.jpg");
        mapList.add("D:\\jpg_2.jpg");
        int width = 500;
        int height = 400;
        jpg_1.put("width", width);
        jpg_1.put("height", height);
        jpg_1.put("type", "jpg");
        jpg_1.put("content", "D:\\dog.jpg");

        Map<String,Object> jpg_2 = new HashMap<String, Object>();
        jpg_2.put("width", width);
        jpg_2.put("height", height);
        jpg_2.put("type", "jpg");
        jpg_2.put("content", "D:\\jpg_2.jpg");

        Map<String,Object> jpg_3 = new HashMap<String, Object>();
        jpg_3.put("width", width);
        jpg_3.put("height", height);
        jpg_3.put("type", "jpg");
        jpg_3.put("content", "D:\\jpg_3.jpg");

        Map<String,Object> c1 = new HashMap<String, Object>();
        c1.put("width", 15);
        c1.put("height", 15);
        c1.put("type", "jpg");
        c1.put("content", "D:\\c1.jpg");

        Map<String,Object> cc = new HashMap<String, Object>();
        cc.put("width", 15);
        cc.put("height", 15);
        cc.put("type", "jpg");
        cc.put("content", "D:\\cc.jpg");

        ArrayList<String> payKindCheck = new ArrayList<>();
        payKindCheck.add("0");
        payKindCheck.add("1");
        payKindCheck.add("0");

        param.put("cc", cc);
        param.put("c1", c1);
        param.put("m1_1", jpg_1);
        param.put("m1_2", jpg_2);
        param.put("m1_3", jpg_3);
        param.put("payKind", payKindCheck);
        param.put("custName", "李明");
        param.put("loanAmout", "999万");
        param.put("loanLength", "36期");
        param.put("${date}", "2020年09月10日");
        param.put("checkDate", "2020年09月15日");
        param.put("loanDate", "2020-09-10");
        param.put("loanPurpose", "采购商品,员工工资,购买食品");
        param.put("checked", "警察暴力执法致非裔男子死亡事件,这两天在美国明尼苏达州掀起抗议浪潮,其中就包括此事件发生地明尼阿波利斯。");
        param.put("requireCheck", "这两天在美国明尼苏达州掀起抗议浪潮,其中就包括此事件发生地明尼阿波利斯。");
        param.put("specialRequireCheck", "“今日俄罗斯”(RT)电视台28日报道说,明尼苏达州州长沃尔兹(Tim Walz)在执法部门未能在明尼阿波利斯“提供安全保障”后,宣布召集国民警卫队,以阻止暴乱以及抢劫事件的发生。");
        param.put("specialChecked", "此前,就非裔男子弗洛伊德之死的激烈抗议演变成破坏、纵火以及抢劫。");
        param.put("${12}", "美国有线电视新闻网(CNN)报道称,州长沃尔兹28日当天签署了一项行政命令,来启动国民警卫队的部署。");
        param.put("checkAddr", "金融城2号楼");
        param.put("addrChange", "无变动");
        param.put("staff", "李冰");
        param.put("detailMsg4useAmout", "在这份行政命令中,州长办公室称,“不幸的是,一些人从事了非法与危险的活动,包括纵火、骚乱、抢劫以及破坏公共与私人财产。”命令强调需要“和平示威”。");
        param.put("msgSource", "根据日前社交媒体上的视频,该非裔男子名叫弗洛伊德,被逮捕时被3名警察按在地上,其中一名白人警察用膝盖顶住他的脖子,另外1名警察站在一边,弗洛伊德神情痛苦、声音嘶哑,一直在说自己无法呼吸,随后疑似陷入昏迷。");
        param.put("useAmoutByContract", "26日开始,明尼阿波利斯市大批民众走上街头抗议,不少人举着印有“黑人的命也是命”等字样的标语牌,要求为弗洛伊德伸张正义。");
        param.put("${19}", "27日,抗议活动仍在继续,据哥伦比亚广播公司(CBS)旗下地方媒体报道,当天示威者不仅砸烂了警察局的玻璃,甚至还砸商店抢东西。");
        param.put("${20}", "收到造假数亿元的银行询证函，因为想着帮客户“应付”审计，日后还能方便存款，山东一银行行长寇某竟然同意盖章。没想到，这一如意算盘落空，其本人最终也被判刑。");
        param.put("${21}", "李明");
        param.put("${22}", "2020");
        param.put("${23}", "08");
        param.put("${24}", "15");
        param.put("${25}", "认为寇某违反规定");
        param.put("${26}", "值得注意的是，寇某同意盖章的两份询证函，涉案金额达8.6亿元，而参与询证的会计师事务所，是瑞华和德勤。");
        param.put("${27}", "中国裁判文书网上公布的山东省淄博市中级人民法院二审刑事裁定书揭开了这起案件的诸多细节。");
        param.put("${28}", "李冰");
        param.put("${29}", "2020");
        param.put("${30}", "10");
        param.put("${31}", "08");
        param.put("${32}", "收到询证函后，作为齐商银行桓台支行行长的寇某看出了其中的端倪");
        param.put("${33}", "当寇某在办公室看到询证函后，发现两份询证函都有虚假之处，其中索引号为“东岳化工-兴桓路齐商-10”的询证函中，委托贷款的资金使用方填写的是齐商银行，实际齐商银行没有作为资金使用方为东岳化工做过委托贷款，而是由东岳集团和资金使用方直接进行资金往来，并没有通过银行，而且东岳化工委托贷款的总金额不超过2亿，但银行询证函上的委托贷款金额是4.18亿元；索引号“高分子一齐商兴桓路支行-16”的银行询证函情况也类似");
        param.put("${34}", "询证函应先由负责前台业务的主任从系统核实内容后加盖业务章。但是寇某没有交前台主任处理，而是直接安排盖了该行的行政章。");
        param.put("${35}", "李冰");
        param.put("${36}", "2008");
        param.put("${37}", "08");
        param.put("${38}", "08");

        System.out.println(param);

        try {
            String result = replaceAndGenerateWord("D:\\m6.docx", param,
                    "100000012.docx", null, null);

            // 生成word文件路径  tempFilePath + fileName
            // 将 word文档转成 pdf
            HelloPython.runPython("D:\\tempFile\\word\\100000012.docx", "D:\\tempFile\\word\\10001.pdf");

            Thread.sleep(1000);
            // 给pdf加水印
//            WaterPrintUtil.GenerateWatermark("D:\\tempFile\\word\\10001.pdf", "D:\\tempFile\\word\\10002.pdf");
        } catch (InterruptedException e) {
            e.printStackTrace();
            return AjaxResult.errorResult();
        }
        return AjaxResult.successResult();

    }

    /**
     * 替换word中的自定义字符串以及图片（适用于word2003+ 版本）
     * 注：2003版本word不支持替换图片，2007版本以上可以替换图片
     */
    public static String replaceAndGenerateWord(String filePath, Map<String, Object> param, String fileName,
                                                HttpServletRequest request, HttpServletResponse response){
        String[] sp = filePath.split("\\.");
        //判断文件是否有后缀名
        if(sp.length > 0){
            try{
                //处理docx文档 2007-2013
                if(sp[sp.length - 1].equalsIgnoreCase("docx")){
                    OPCPackage pack = POIXMLDocument.openPackage(filePath);
                    CustomXWPFDocument document = new CustomXWPFDocument(pack);
                    if (param != null && param.size() > 0) {
                        //处理段落
                        List<XWPFParagraph> paragraphList = document.getParagraphs();
                        processParagraphs_new(paragraphList, param, document);

                        //处理表格
                        Iterator<XWPFTable> it = document.getTablesIterator();
                        while (it.hasNext()) {
                            XWPFTable table = it.next();
                            List<XWPFTableRow> rows = table.getRows();

                            for (XWPFTableRow row : rows) {

                                List<XWPFTableCell> cells = row.getTableCells();
                                for (XWPFTableCell cell : cells) {
                                    List<XWPFParagraph> paragraphListTable =  cell.getParagraphs();
                                    processParagraphs_new( paragraphListTable, param, document);
                                }
                            }

                        }
                        createDir(tempFilePath);
                        FileOutputStream fos = new FileOutputStream(new File(tempFilePath.concat(fileName)));
                        document.write(fos);
                        fos.flush();
                        fos.close();
//                        doExport(fileName, tempFilePath.concat(fileName), request, response);
                        return tempFilePath.concat(fileName);
                    }
                    //处理doc文档 97-2003
                }else if(sp[sp.length - 1].equalsIgnoreCase("doc")){
                    HWPFDocument document = new HWPFDocument(new FileInputStream(filePath));
                    Range range = document.getRange();
                    for (Map.Entry<String, Object> entry : param.entrySet()) {
                        Object value = entry.getValue();
                        if(value instanceof String){
                            range.replaceText(entry.getKey(), entry.getValue().toString());
                        }else if(value instanceof Map){
                            //TODO word2003暂时不能处理图片
                        }
                    }
                    createDir(tempFilePath);
                    FileOutputStream fos = new FileOutputStream(new File(tempFilePath.concat(fileName)));
                    document.write(fos);
                    fos.flush();
                    fos.close();
//                    doExport(fileName, tempFilePath.concat(fileName), request, response);
                    return tempFilePath.concat(fileName);
                }
            }catch(Exception e){
                e.printStackTrace();
                return "fail";
            }
        }else{
            return "fail";
        }
        return "success";
    }

    /**
     * 处理段落
     * @param paragraphList
     * @throws FileNotFoundException
     * @throws InvalidFormatException
     */
    public static void processParagraphs(List<XWPFParagraph> paragraphList, Map<String, Object> param, CustomXWPFDocument doc)
            throws InvalidFormatException, FileNotFoundException{
        if(paragraphList != null && paragraphList.size() > 0){
            //首选循环段落
            for(XWPFParagraph paragraph : paragraphList){
                //获取段落的text
                boolean needDel = false;
                String text = paragraph.getText();
                if(text != null){
                    for (Entry<String, Object> entry : param.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        //替换
                        if(value instanceof String){
                            String text2 = text.replace(key, value.toString());
                            if(!text2.equals(text)){
                                needDel = true;
                            }
                            text = text2;
                        }else if(value instanceof Map){
                            if(text.indexOf(key) != -1){
                                //特殊处理图片
                                int length = paragraph.getRuns().size();
                                //将原有的Run去掉
                                if (length > 0) {
                                    for (int i=(length-1); i>=0; i--) {
                                        paragraph.removeRun(i);
                                    }
                                }
                                String imgurl = (String)((Map<?, ?>) value).get("content");
                                String type = (String)((Map<?, ?>) value).get("type");
                                int width = (Integer) ((Map<?, ?>) value).get("width");
                                int height = (Integer) ((Map<?, ?>) value).get("height");
                                int pictureType = getPictureType(type);

                                String blipId = doc.addPictureData(new FileInputStream(new File(imgurl)), pictureType);
                                doc.createPicture(blipId, doc.getNextPicNameNumber(pictureType), width, height, paragraph);

                                XWPFRun newRun = paragraph.createRun();
                                newRun.setText("正确选择  ", 0);
                                paragraph.addRun(newRun);

                                doc.createPicture(blipId, doc.getNextPicNameNumber(pictureType), width, height, paragraph);

                                XWPFRun newRun_1 = paragraph.createRun();
                                newRun_1.setText("错误选择  ", 0);
                                paragraph.addRun(newRun_1);
                            }
                        }
                    }
                }
                int length = paragraph.getRuns().size();
                //将原有的Run去掉（原因是paragraph将XWPFRun分割成了一个乱七八糟的数组，例：${1}$，这个获取出来的是[$,{,1,},$],
                // 不能满足我们替换的要求，这里进行特殊处理）
                if(needDel){
                    if (length > 0) {
                        for (int i=(length-1); i>=0; i--) {
                            paragraph.removeRun(i);
                        }
                        //在段落里面插入我们替换过后的文本
                        XWPFRun newRun = paragraph.insertNewRun(0);
                        newRun.setText(text, 0);
                        paragraph.addRun(newRun);
                    }
                }
            }
        }
    }

    /**
     * 处理段落
     * @param paragraphList
     * @throws FileNotFoundException
     * @throws InvalidFormatException
     */
    public static void processParagraphs_new(List<XWPFParagraph> paragraphList, Map<String, Object> mapData, CustomXWPFDocument doc)
            throws InvalidFormatException, FileNotFoundException{
        if(paragraphList != null && paragraphList.size() > 0){
            //首选循环段落
            for(XWPFParagraph paragraph : paragraphList){
                //获取段落的text
                boolean needDel = false;
                String pText = paragraph.getText();
                if ("".equals(pText.trim())){
                    continue;
                }
                List<XWPFRun> runs = paragraph.getRuns();
                ArrayList<String> keyList = new ArrayList<>();
                for (XWPFRun run : runs) {
                    String text = run.getText(0);
                    keyList.add(text);
                }

                //将原有的Run去掉
                int length = paragraph.getRuns().size();
                if (length > 0) {
                    for (int i=(length-1); i>=0; i--) {
                        paragraph.removeRun(i);
                    }
                }

                int checkFlag = 0;    // 复选框 标志位
                for (String key : keyList) {
                    Object value = mapData.get(key);
                    // 如果字典中没有定义, 则保留原来的
                    if (value == null){     // 字典无值 保留原来
                        XWPFRun newRun_1 = paragraph.createRun();
                        newRun_1.setText(key, 0);
                        paragraph.addRun(newRun_1);
                    }
                    if (value instanceof String) {  // 字典有值 替换
                        // 新增新的
                        XWPFRun newRun_1 = paragraph.createRun();
                        newRun_1.setText(value.toString(), 0);
                        paragraph.addRun(newRun_1);

                    }else if (value instanceof Map){    // 处理图片
                        String imgurl = (String)((Map<?, ?>) value).get("content");
                        String type = (String)((Map<?, ?>) value).get("type");
                        int width = (Integer) ((Map<?, ?>) value).get("width");
                        int height = (Integer) ((Map<?, ?>) value).get("height");
                        int pictureType = getPictureType(type);
                        // 插入图片
                        String blipId = doc.addPictureData(new FileInputStream(new File(imgurl)), pictureType);
                        doc.createPicture(blipId, doc.getNextPicNameNumber(pictureType), width, height, paragraph);
                    } else if (value instanceof ArrayList) {  // 处理复选框
                        List<String> checks = (ArrayList) value;
                        String ischeck = checks.get(checkFlag);
                        if ("1".equals(ischeck)) {   // 被选中
                            // 插入图片
                            String blipId = doc.addPictureData(new FileInputStream(new File("D:\\c1.jpg")),
                                    CustomXWPFDocument.PICTURE_TYPE_JPEG);
                            doc.createPicture(blipId, doc.getNextPicNameNumber(CustomXWPFDocument.PICTURE_TYPE_JPEG),
                                    15, 15, paragraph);
                        } else {    // 未被选中
                            // 插入图片
                            String blipId = doc.addPictureData(new FileInputStream(new File("D:\\cc.jpg")),
                                    CustomXWPFDocument.PICTURE_TYPE_JPEG);
                            doc.createPicture(blipId, doc.getNextPicNameNumber(CustomXWPFDocument.PICTURE_TYPE_JPEG),
                                    15, 15, paragraph);
                        }
                        checkFlag++;
                    }
                }

            }
        }
    }

    /**
     * 根据图片类型，取得对应的图片类型代码
     * @param picType
     * @return int
     */
    private static int getPictureType(String picType){
        int res = CustomXWPFDocument.PICTURE_TYPE_PICT;
        if(picType != null){
            if(picType.equalsIgnoreCase("png")){
                res = CustomXWPFDocument.PICTURE_TYPE_PNG;
            }else if(picType.equalsIgnoreCase("dib")){
                res = CustomXWPFDocument.PICTURE_TYPE_DIB;
            }else if(picType.equalsIgnoreCase("emf")){
                res = CustomXWPFDocument.PICTURE_TYPE_EMF;
            }else if(picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")){
                res = CustomXWPFDocument.PICTURE_TYPE_JPEG;
            }else if(picType.equalsIgnoreCase("wmf")){
                res = CustomXWPFDocument.PICTURE_TYPE_WMF;
            }
        }
        return res;
    }

    /**
     * 导出
     *
     * @param fileName
     * @param filePath
     * @param request
     * @param response
     */
    public static void doExport(String fileName, String filePath, HttpServletRequest request, HttpServletResponse response){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File file = null;
//        HttpServletResponse response = (HttpServletResponse)RpcContext.getContext().getResponse(HttpServletResponse.class);
        try {
            file = new File(filePath);
//        HttpServletRequest request = (HttpServletRequest)RpcContext.getContext().getRequest(HttpServletRequest.class);
            request.setCharacterEncoding("UTF-8");
            String agent = request.getHeader("User-Agent").toUpperCase();
            if ((agent.indexOf("MSIE") > 0) || ((agent.indexOf("RV") != -1) && (agent.indexOf("FIREFOX") == -1)))
                fileName = URLEncoder.encode(fileName, "UTF-8");
            else {
                fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
            }
            response.setContentType("application/x-msdownload;");
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            response.setHeader("Content-Length", String.valueOf(file.length()));
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(response.getOutputStream());

            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
                bos.write(buff, 0, bytesRead);
        }
        catch (Exception e) {
            e.printStackTrace();
//          System.out.println("导出文件失败！");
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
                file.delete();
            } catch (Exception e) {
//            LOGGER.error("导出文件关闭流出错！", e);
            }
        }
    }

    /**
     * insertRow 在word表格中指定位置插入一行，并将某一行的样式复制到新增行
     * @param copyrowIndex 需要复制的行位置
     * @param newrowIndex 需要新增一行的位置
     * */
    public static void insertRow(XWPFTable table, int copyrowIndex, int newrowIndex) {
        // 在表格中指定的位置新增一行
        XWPFTableRow targetRow = table.insertNewTableRow(newrowIndex);
        // 获取需要复制行对象
        XWPFTableRow copyRow = table.getRow(copyrowIndex);
        //复制行对象
        targetRow.getCtRow().setTrPr(copyRow.getCtRow().getTrPr());
        //或许需要复制的行的列
        List<XWPFTableCell> copyCells = copyRow.getTableCells();
        //复制列对象
        XWPFTableCell targetCell = null;
        for (int i = 0; i < copyCells.size(); i++) {
            XWPFTableCell copyCell = copyCells.get(i);
            targetCell = targetRow.addNewTableCell();
            targetCell.getCTTc().setTcPr(copyCell.getCTTc().getTcPr());
            if (copyCell.getParagraphs() != null && copyCell.getParagraphs().size() > 0) {
                targetCell.getParagraphs().get(0).getCTP().setPPr(copyCell.getParagraphs().get(0).getCTP().getPPr());
                if (copyCell.getParagraphs().get(0).getRuns() != null
                        && copyCell.getParagraphs().get(0).getRuns().size() > 0) {
                    XWPFRun cellR = targetCell.getParagraphs().get(0).createRun();
                    cellR.setBold(copyCell.getParagraphs().get(0).getRuns().get(0).isBold());
                }
            }
        }

    }

    /**
     * 创建目录
     * @param basePath
     */
    public static void createDir(String basePath){
        File file = new File(basePath);
        if (!file.exists())
            file.mkdirs();
    }

}


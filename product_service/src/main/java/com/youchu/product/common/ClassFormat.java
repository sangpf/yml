package com.youchu.product.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将大写 字母 批量改为 _小写
 */
public class ClassFormat {

    public static void main(String[] args) {
        String name = "bizId\n" +
                "    bizType\n" +
                "    bizStatus\n" +
                "    custName\n" +
                "    custCode\n" +
                "    emplCode\n" +
                "    emplName\n" +
                "    currOperator\n" +
                "    checkModel\n" +
                "    billNo\n" +
                "    currency\n" +
                "    billAmout\n" +
                "    billLength\n" +
                "    billUnit\n" +
                "    billBeginDate\n" +
                "    billEndDate\n" +
                "    billBlance\n" +
                "    firstTrackDate\n" +
                "    lastRoutineDate\n" +
                "    lastComprehensiveDate\n" +
                "    lastImplementDate\n" +
                "    noticeDate";

        String s = upperCharToUnderLine(name);
        System.out.println(s);

    }


    public static String upperCharToUnderLine(String param) {
        Pattern p=Pattern.compile("[A-Z]");
        if(param==null ||param.equals("")){
            return "";
        }
        StringBuilder builder=new StringBuilder(param);
        Matcher mc=p.matcher(param);
        int i=0;
        while (mc.find()) {
            builder.replace(mc.start()+i, mc.end()+i, "_"+mc.group().toLowerCase());
            i++;
        }

        if('_' == builder.charAt(0)){
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

}












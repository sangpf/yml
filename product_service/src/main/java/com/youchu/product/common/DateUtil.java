package com.youchu.product.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = null;
        try {
            curDate = dateFormat.parse("2020-01-31");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date endTime = aMonthLater(curDate, 1);  // 一个月后
        String format = dateFormat.format(endTime);
        System.out.println("一个月后 :"+format);

        Boolean withOneMonth = isWithOneMonth(1, endTime);
        System.out.println("是否截至日期前一个月 :"+withOneMonth);
    }

    /**
     * 返回 指定月后的日期
     * @param  curDate  起始日期
     * @param m  几个月后
     */
    public static Date aMonthLater(Date curDate, int m){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.add(Calendar.MONTH, m);

        Date endTime = calendar.getTime();
        return endTime;
    }

    /**
     * 判断当前日期 是否在截至日期之前 的 m个月内  m = 1
     * @param m  当前日期往后推 m 个月
     * @param endTime  截至日期
     */
    public static Boolean isWithOneMonth(int m, Date endTime){
        Date curDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.add(Calendar.MONTH, m);
        Date monthLaterTime = calendar.getTime();

        boolean before = curDate.before(endTime);
        boolean after = monthLaterTime.after(endTime);
        return before&&after;
    }

    /**
     * 判断 当前日期 是否在截至日期的 d 天之内
     * @param d
     * @param endTime
     * @return
     */
    public static Boolean isWithOneDay(int d, Date endTime){
        Date curDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.add(Calendar.DATE, d);
        Date monthLaterTime = calendar.getTime();

        boolean before = curDate.before(endTime);
        boolean after = monthLaterTime.after(endTime);
        return before&&after;
    }

    /**
     * 超出时限
     * @return
     */
    public static Boolean isOverTime(Date endTime){
        Date curDate = new Date();
        boolean after = curDate.after(endTime);
        return after;
    }

}

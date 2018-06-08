package com.baiyu.common.utils;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author baiyu
 * @description: DateUtil  日期操作工具类
 * @date: 2018/6/5
 */
public class DateUtil {

    private static final Logger LOGGER = Logger.getLogger(DateUtil.class);

    private static final String FRAMAT_YYYYMMDDHHMMDSS= "yyyyMMddHHmmss";
    private static final String FRAMAT_YYYY_MM_DD_HHMMDD = "yyyy-MM-dd HH:mm:ss";
    private static final String FRAMAT_YYYY_MM_DD = "yyyy-MM-dd";


    /**
     * 获取格式化对象
     *
     * @param format
     * @return
     */
    private static DateFormat getInstanceDateFormat(String format){
        return new SimpleDateFormat(format);
    }

    /**
     * 字符串转日期
     *
     * @param dateStr  日期字符串
     * @param format   格式化格式
     * @return
     */
    public static Date strToDate(String dateStr, String format) {
        if (StringUtil.isEmpty(dateStr) || StringUtil.isEmpty(format)) {
            LOGGER.error("dateStr and format can not be null");
            return null;
        }
        try {
            Date date = getInstanceDateFormat(format).parse(dateStr);
            return date;
        } catch (ParseException e) {
            LOGGER.error("parse error", e);
            return null;
        }
    }

    /**
     * 日期转字符串
     *
     * @param date      日期
     * @param format    格式化格式
     * @return
     */
    public static String dateToStr(Date date, String format) {
        if (BeanUtil.isEmpty(date) || StringUtil.isEmpty(format)) {
            LOGGER.error("date and format can not be null");
            return null;
        }
        return getInstanceDateFormat(format).format(date);
    }

    /**
     * 获取当前毫秒数
     *
     * @return
     */
    public static long getTimeInMillis(){
        Calendar calendar = Calendar.getInstance();
        return calendar.getTimeInMillis();
    }

    /**
     * 获取日期的最后一秒钟
     *
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date){
        if (BeanUtil.isEmpty(date)){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        calendar.set(Calendar.HOUR_OF_DAY,23);
        calendar.set(Calendar.MINUTE,59);
        calendar.set(Calendar.SECOND,59);
        return calendar.getTime();
    }


}

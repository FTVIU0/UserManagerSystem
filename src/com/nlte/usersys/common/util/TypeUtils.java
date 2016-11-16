package com.nlte.usersys.common.util;

import com.nlte.usersys.common.exception.DateException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hp on 2016/11/14.
 */
public class TypeUtils {
    public static String dateToStr(Date date, String pattern) {
        String format = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            format = sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DateException("日期转换字符串出错");
        }
        return format;
    }

    public static Date strToDate(String string, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = sdf.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new DateException("字符串转换日期出错");
        }
        return date;
    }

}

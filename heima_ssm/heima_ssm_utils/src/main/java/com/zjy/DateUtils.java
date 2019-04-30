package com.zjy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy
 */
public class DateUtils {

    // 日期转换为字符串
    public static String date2Stirng(Date date, String patt) {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }


    // 字符串转换为日期
    public static Date string2Date(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(str);
        return date;
    }
}

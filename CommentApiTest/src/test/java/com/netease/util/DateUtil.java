package com.netease.util;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by hzliuyan15 on 2015/4/1.
 */
public class DateUtil {

    //RFC 822 timestamp
    private static final ThreadLocal<DateFormat> df
            = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            df.setTimeZone(tz);
            return df;
        }
    };

    private static final ThreadLocal<DateFormat> dateDf
            = new ThreadLocal<DateFormat>(){
        @Override
        protected DateFormat initialValue() {
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat dateDf = new SimpleDateFormat("yyyy-MM-dd");
            dateDf.setTimeZone(tz);
            return dateDf;
        }
    };

    private static SimpleDateFormat RFC822DATEFORMAT;
    static {
        RFC822DATEFORMAT
                = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'z", Locale.US);
        TimeZone tz = TimeZone.getTimeZone("GMT");
        RFC822DATEFORMAT.setTimeZone(tz);
    }

    public static String formatRFC822(Date date){
        return RFC822DATEFORMAT.format(date);
    }

    public static Date parseRFC822(String dateStr) throws ParseException {
        return RFC822DATEFORMAT.parse(dateStr);
    }

    public static String format(Timestamp timestamp) {
        return df.get().format(timestamp);
    }

    public static Timestamp parse(String dateStr) throws ParseException {
        return new Timestamp(df.get().parse(dateStr).getTime());
    }

    public static String formatDate(Date date) {
        return dateDf.get().format(date);
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String dateStr = formatRFC822(date);
        long i = DateUtil.parseRFC822(dateStr).getTime();
        long j = System.currentTimeMillis();
        System.out.println(i);
        System.out.println(j);
        long timeInMillis = DateUtil.parseRFC822(dateStr).getTime() - System.currentTimeMillis();
        if(Math.abs(timeInMillis) > DateUtils.MILLIS_PER_MINUTE * 15){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

    }

}


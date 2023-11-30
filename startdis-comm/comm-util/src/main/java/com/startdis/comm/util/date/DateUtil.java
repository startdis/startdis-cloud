package com.startdis.comm.util.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String SHORT_DATE_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取上个季度
     *
     * @return
     */
    public static Integer getLastQuarter() {
        LocalDate currentDate = LocalDate.now();
        int currentQuarter = (currentDate.getMonthValue() - 1) / 3;
        return currentQuarter;
    }

    /**
     * 获取上个季度的年份
     *
     * @return
     */
    public static Integer getYearByLastQuarter() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentQuarter = (currentDate.getMonthValue() - 1) / 3 + 1; // 获取当前季度

        int previousQuarter;
        int previousYear;

        if (currentQuarter == 1) {
            previousQuarter = 4;
            previousYear = currentYear - 1;
        } else {
            previousQuarter = currentQuarter - 1;
            previousYear = currentYear;
        }
        return previousYear;
    }

    /**
     * 获取当前季度
     *
     * @return
     */
    public static Integer getThisQuarter() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int quarter = (month + 2) / 3;
        return quarter;
    }

    /**
     * 获取当前年份
     *
     * @return
     */
    public static Integer getThisYear() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    public static String toStringDate(Date date) {
        return toString(date, SHORT_DATE_FORMAT);
    }
    public static String toStringDate2(Date date) {
        return toString(date, DATE_FORMAT);
    }

    private static String toString(Date date, String format) {
        SimpleDateFormat formatter;
        if ((date == null) || (format == null) || (format.length() == 0)) {
            return null;
        }
        formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
}

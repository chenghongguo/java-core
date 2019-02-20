package com.hongguo.java8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: chenghongguo
 * @date: 2019-01-16
 * @description:
 */
public class DateTimeTest {

    public static void main(String[] args) throws Exception {
        String string = "2018-12-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = sdf.parse(string);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        LocalDate salesPeriodDate = LocalDate.now().plusMonths(2L);
        int salesPeriodYear = salesPeriodDate.getYear();
        int salesPeriodMonth = salesPeriodDate.getMonthValue();
        int startTimeYear = calendar.get(Calendar.YEAR);
        int startTimeMonth = calendar.get(Calendar.MONTH) + 1;
        if (startTimeYear == salesPeriodYear) {
            if (startTimeMonth <= salesPeriodMonth) {
                System.out.println("1 in");
            } else {
                System.out.println("1 in out");
            }
        } else if (startTimeYear < salesPeriodYear) {
            System.out.println("2 in");
        } else {
            System.out.println("3 out");
        }
    }

    @Test
    public void test01() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        Date startTime = Date.from(LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
        Date endTime = Date.from(LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf.format(startTime));
        System.out.println(sdf.format(endTime));
    }
}

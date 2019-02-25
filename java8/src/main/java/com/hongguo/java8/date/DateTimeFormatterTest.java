package com.hongguo.java8.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class DateTimeFormatterTest {

    @Test
    public void test1() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(dateTimeFormatter);
        System.out.println(format);
        LocalDate localDate = LocalDate.parse("2019-10-10");
        System.out.println(localDate);
        LocalDateTime localDateTime1 = LocalDateTime.parse("2019-10-10T12:12:12");
        System.out.println(localDateTime1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse("2019-02-10 12:13:12", formatter);
        System.out.println(localDateTime2);
    }
}

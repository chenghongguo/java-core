package com.hongguo.java8.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;

/**
 * @author hongguo_cheng
 * @date 2019-02-23
 * @description
 */
public class LocalDateTest {

    /**
     * LocalDate 创建
     */
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate now = LocalDate.now(ZoneId.systemDefault());
        System.out.println(now);
        LocalDate now1 = LocalDate.of(2019, 03, 30);
        System.out.println(now1);
        LocalDate of = LocalDate.of(2019, Month.APRIL, 30);
        System.out.println(of);
        LocalDate localDate1 = LocalDate.ofEpochDay(1);
        System.out.println(localDate1);
        LocalDate parse = LocalDate.parse("2019-02-20");
        System.out.println(parse);

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate parse1 = LocalDate.parse("2018-12-12", formatter);
        System.out.println(parse1);
    }

    @Test
    public void test2() {
        LocalDate localDate = LocalDate.now();
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println(dayOfMonth);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek.getValue());
        int dayOfYear = localDate.getDayOfYear();
        System.out.println(dayOfYear);
        Era era = localDate.getEra();
        System.out.println(era.getValue());
        boolean after = localDate.isAfter(LocalDate.of(2028, 12, 12));
        System.out.println(after);
        boolean equal = localDate.isEqual(LocalDate.now());
        System.out.println(equal);

        // 是否闰年
        boolean leapYear = localDate.isLeapYear();
        System.out.println(leapYear);

        int i = localDate.lengthOfMonth();
        System.out.println(i);
        int i1 = localDate.lengthOfYear();
        System.out.println(i1);
    }

    @Test
    public void test3() {
        LocalDate localDate = LocalDate.now();
        LocalDate minus = localDate.minusDays(5);
        System.out.println(minus);
        LocalDate localDate1 = localDate.plusDays(4);
        System.out.println(localDate1);

        LocalDate localDate2 = localDate.withDayOfMonth(12);
        System.out.println(localDate2);

        LocalDate localDate3 = localDate.withMonth(12);
        System.out.println(localDate3);
    }
}

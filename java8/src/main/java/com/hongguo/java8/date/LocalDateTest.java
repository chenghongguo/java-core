package com.hongguo.java8.date;

import com.hongguo.java8.utils.DateUtils;
import org.junit.Test;

import java.time.*;
import java.time.chrono.Era;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author hongguo_cheng
 * @date 2019-02-23
 * @description
 */
public class LocalDateTest {

    @Test
    public void test8() {
        LocalDate startDate = LocalDate.of(2019, Month.MARCH, 2);
        LocalDate endDate = LocalDate.now().plusDays(4);
        System.out.println(endDate.isAfter(startDate));
    }

    @Test
    public void test7() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        System.out.println(DateUtils.convertLocalTimeToDate(localDate, localTime));
    }

    /**
     * LocalDate 转 Date
     */
    @Test
    public void test6() {
        LocalDate localDate = LocalDate.now();
        System.out.println(DateUtils.convertLocalDateToDate(localDate));
    }

    /**
     * LocalDateTime 转 Date
     */
    @Test
    public void test5() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(DateUtils.convertLocalDateTimeToDate(localDateTime));
    }

    /**
     * Date转LocalDateTime
     */
    @Test
    public void test4() {
        Date date = new Date();
        System.out.println(DateUtils.convertToLocalDateTime(date));
        System.out.println(DateUtils.convertToLocalDate(date));
        System.out.println(DateUtils.convertToLocalTime(date));
    }

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

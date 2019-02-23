package com.hongguo.java8.date;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * @author hongguo_cheng
 * @date 2019-02-23
 * @description
 */
public class InstantTest {

    @Test
    public void test1() {
        Instant instant = Instant.now();
        System.out.println(instant);
        int nano = instant.getNano();
        System.out.println(nano);
        long l = instant.toEpochMilli();
        System.out.println(l);
    }

    @Test
    public void test2() {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());
    }

    @Test
    public void test3() {
        LocalDate today = LocalDate.now();
        System.out.println("Today: " + today);
        LocalDate birthday = LocalDate.of(1989, Month.JANUARY, 3);
        System.out.println("Birthday:" + birthday);
        Period period = Period.between(birthday, today);
        System.out.println(period.getYears() + ", "
                + period.getMonths() + ", " + period.getDays());
    }

    @Test
    public void test4() {
        Instant now = Instant.now();
        System.out.println(now);
        Instant add = Instant.now().plusSeconds(10);
        System.out.println(add);
        Duration duration = Duration.between(now, add);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toMillis());
    }

    @Test
    public void test5() {
        LocalDate startDate = LocalDate.of(1993, Month.OCTOBER, 19);
        System.out.println("开始时间  : " + startDate);
        LocalDate endDate = LocalDate.of(2017, Month.JUNE, 16);
        System.out.println("结束时间 : " + endDate);
        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两天之间的差在天数   : " + daysDiff);
    }
}

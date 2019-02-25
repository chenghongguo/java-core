package com.hongguo.java8.date;

import com.hongguo.java8.utils.DateUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author hongguo_cheng
 * @date 2019-02-23
 * @description
 */
public class LocalDateTimeTest {

    @Test
    public void test1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);
    }

    @Test
    public void test2() {
        Date now = new Date();
        System.out.println(DateUtils.getEndDayOfMonth(now));
        System.out.println(DateUtils.getFirstDayOfMonth(now));
    }

    @Test
    public void test3() {
        Date now = new Date();
        System.out.println(DateUtils.getFirstTimeOfDay(now));
        System.out.println(DateUtils.getEndTimeOfDay(now));
    }
}

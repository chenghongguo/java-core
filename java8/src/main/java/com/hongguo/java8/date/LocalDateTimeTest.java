package com.hongguo.java8.date;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
}

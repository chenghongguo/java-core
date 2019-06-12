package com.hongguo.java8.localdate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author: chenghongguo
 * @date: 2019-06-11
 * @description:
 */
public class LocalDateTest {

    @Test
    public void test2() {
        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        System.out.println(localDateTime);

    }

    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println(LocalDate.now().isLeapYear());
    }
}

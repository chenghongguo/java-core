package com.hongguo.java8.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author: chenghongguo
 * @date: 2019-06-11
 * @description:
 */
public class DayOfWeekTest {

    @Test
    public void test2() {
        DayOfWeek from = DayOfWeek.from(LocalDate.now());
        System.out.println(from);
    }

    @Test
    public void test1() {
        DayOfWeek.values();
        DayOfWeek of = DayOfWeek.of(3);
        System.out.println(of);
    }
}

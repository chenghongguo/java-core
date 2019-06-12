package com.hongguo.java8.localdate;

import org.junit.Test;

import java.time.LocalTime;

/**
 * @author: chenghongguo
 * @date: 2019-06-11
 * @description:
 */
public class LocalTimeTest {

    @Test
    public void test1() {
        System.out.println(LocalTime.now().getHour());
        System.out.println(LocalTime.now().getMinute());
        System.out.println(LocalTime.now().getSecond());
        System.out.println(LocalTime.now().getNano());
    }
}

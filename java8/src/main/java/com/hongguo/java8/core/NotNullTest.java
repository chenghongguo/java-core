package com.hongguo.java8.core;

import lombok.NonNull;
import org.junit.Test;

import java.util.Objects;

/**
 * @author: chenghongguo
 * @date: 2019-06-19
 * @description:
 */
public class NotNullTest {

    @Test
    public void test1() {
        System.out.println(msg(null));
    }

    private String msg(@NonNull String msg) {
        System.out.println(msg);
        return msg;
    }

    @Test
    public void test2() {
        boolean equals = Objects.equals("2", "1");
        System.out.println(equals);

        Integer a = 2000;
        Integer b = 2000;
        System.out.println(a.equals(b));
    }
}

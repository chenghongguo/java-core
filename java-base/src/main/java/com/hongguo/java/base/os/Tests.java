package com.hongguo.java.base.os;

import org.junit.Test;

import java.util.Locale;

/**
 * Tests
 *
 * @author chenghongguo
 * @date 2019/12/18
 * @since 1.0.0
 */
public class Tests {

    @Test
    public void test() {
        long l = Runtime.getRuntime().totalMemory();
        System.out.println(l / 1024 / 1024);
    }

    @Test
    public void test2() {
        boolean equals = Locale.getDefault().equals(Locale.getDefault());
        System.out.println(equals);
    }

    @Test
    public void test3() {
        String remoteIp = "127.0.0.,   .0.0", splitter = ",";
        if (remoteIp.indexOf(splitter) > 0) {
            System.out.println(remoteIp.substring(0, remoteIp.indexOf(splitter)).trim());
            System.out.println(remoteIp.substring(remoteIp.indexOf(splitter)).trim());
        }
    }
}

package com.hongguo.jvm.gc;

/**
 * Test1
 *
 * @author chenghongguo
 * @date 2019/11/15
 * @since 1.0.0
 */
public class Test1 {
    public static void main(String[] args) {
        int _1M = 1024 * 1024;
        byte[] b1 = new byte[_1M * 2];
        byte[] b2 = new byte[_1M * 2];
        byte[] b3 = new byte[_1M * 3];
        System.out.println("hello");
    }
}
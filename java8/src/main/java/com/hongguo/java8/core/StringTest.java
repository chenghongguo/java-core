package com.hongguo.java8.core;

import org.junit.Test;

/**
 * @author: chenghongguo
 * @date: 2019-02-20
 * @description:
 */
public class StringTest {

    @Test
    public void test1() {
        String st1 = "abc";
        String st2 = "abc";
        System.out.println(st1 == st2);
        String st3 = new String("abc");
        String st4 = new String("abc");
        System.out.println(st1 == st3);
        System.out.println(st3 == st4);
        System.out.println(System.identityHashCode(st1));
        System.out.println(System.identityHashCode(st2));
        System.out.println(System.identityHashCode(st3));
        System.out.println(System.identityHashCode(st4));
    }
}

package com.hongguo.java8.core;

import org.junit.Test;

/**
 * @author: chenghongguo
 * @date: 2019-02-20
 * @description:
 */
public class IntegerTest {

    @Test
    public void test1() {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
// true
        System.out.println(i1 == i2);
// true
        System.out.println(i1 == i2 + i3);
// false
        System.out.println(i1 == i4);
// false
        System.out.println(i4 == i5);
// true
        System.out.println(i4 == i5 + i6);
// true
        System.out.println(40 == i5 + i6);
    }
}

package com.hongguo.java8.defaultmethod;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public interface A {

    default void hello() {
        System.out.println("hello from A");
    }
}

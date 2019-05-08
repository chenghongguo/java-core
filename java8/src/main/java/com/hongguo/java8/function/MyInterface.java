package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-05-07
 * @description:
 */
@FunctionalInterface
public interface MyInterface {

    void test();

    default void test2() {
        System.out.println("test2");
    }
}

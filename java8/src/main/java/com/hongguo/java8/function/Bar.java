package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
@FunctionalInterface
public interface Bar {

    String method();

    default void defaultBar() {
    }

    default void defaultCommon() {

    }
}

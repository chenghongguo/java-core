package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
@FunctionalInterface
public interface Baz {

    String method();

    default void defaultBaz() {
    }

    default void defaultCommon() {

    }
}

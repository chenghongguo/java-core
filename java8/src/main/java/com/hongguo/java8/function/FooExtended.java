package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
@FunctionalInterface
public interface FooExtended extends Baz, Bar {
    @Override
    default void defaultCommon() {
        Baz.super.defaultCommon();
    }
}

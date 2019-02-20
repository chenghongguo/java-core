package com.hongguo.java8;

/**
 * @author: chenghongguo
 * @date: 2019-01-30
 * @description:
 */
@FunctionalInterface
public interface MyFun<T> {

    int func(T[] values, T v);
}

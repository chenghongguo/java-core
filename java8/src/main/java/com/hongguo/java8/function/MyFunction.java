package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-02-22
 * @description:
 */
@FunctionalInterface
public interface MyFunction<T, R> {

    R apply(T t);
}

package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-02-21
 * @description:
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T t);
}

package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-02-22
 * @description:
 */
@FunctionalInterface
public interface MyConsumer<T> {

    void accept(T t);
}

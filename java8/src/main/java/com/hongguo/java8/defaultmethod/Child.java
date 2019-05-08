package com.hongguo.java8.defaultmethod;

/**
 * @author: chenghongguo
 * @date: 2019-05-07
 * @description:
 */
public interface Child extends Parent {
    @Override
    default void welcome() {
        message("Child: Hi!");
    }
}

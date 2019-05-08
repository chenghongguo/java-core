package com.hongguo.java8.defaultmethod;

/**
 * @author: chenghongguo
 * @date: 2019-05-07
 * @description:
 */
public interface Parent {

    void message(String body);

    default void welcome() {
        message("Parent: Hi!");
    }

    String getLastMessage();
}

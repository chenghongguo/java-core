package com.hongguo.java8.defaultmethod;

import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public interface OrderService {

    List<Object> getList();

    Object get();

    default void sort() {
        System.out.println("sort....");
    }

    static void end() {
        System.out.println("end");
    }
}

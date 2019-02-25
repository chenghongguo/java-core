package com.hongguo.java8.defaultmethod;

import org.junit.Test;

import java.util.Optional;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class OrderServiceTest {

    @Test
    public void test1() {
        OrderService orderService = new OrderServiceImpl();
        orderService.sort();
        OrderService.end();
    }

    @Test
    public void test2() {
        Optional optional = Optional.empty();
        System.out.println(optional);
    }
}

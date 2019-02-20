package com.hongguo.java.dynamic.core;

/**
 * @author: chenghongguo
 * @date: 2018-12-21
 * @description:
 */
public class RealSubject implements Subject {
    @Override
    public void send(String message) {
        System.out.println("send " + message);
    }

    @Override
    public void hello(String hello) {
        System.out.println("hello " + hello);
    }
}

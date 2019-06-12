package com.hongguo.java8.core.interfaces;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
public class D implements A, B {
    @Override
    public String echo() {
        return "hello D";
    }

    public static void main(String[] args) {
        D d = new D();
        System.out.println(d.echo());
    }
}

package com.hongguo.java8.defaultmethod;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class C implements B, A {
    public static void main(String[] args) {
        new C().hello();
    }

    @Override
    public void hello() {
        A.super.hello();
    }
}

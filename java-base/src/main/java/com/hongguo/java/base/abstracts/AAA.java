package com.hongguo.java.base.abstracts;

/**
 * AAA
 *
 * @author chenghongguo
 * @date 2019/8/29
 * @since 1.0.0
 */
public class AAA implements BBB{
    @Override
    public void f() {

    }

    @Override
    public void g() {

    }

    public static void main(String[] args) {
        BBB b = new AAA();
        b.newMethod();
    }
}

interface BBB {
    void f();
    void g();

    default void newMethod() {
        System.out.println("newMethod");
    }
}

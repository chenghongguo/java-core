package com.hongguo.jvm.memory;

/**
 * StaticDispatch
 *
 * @author chenghongguo
 * @date 2019/11/20
 * @since 1.0.0
 */
public class StaticDispatch {

    static abstract class Human {}

    static class Man extends Human {}

    static class Woman extends Human {}

    public void sayHello(Human guy) {
        System.out.println("hello, guy");
    }

    public void sayHello(Man man) {
        System.out.println("hello, man");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello, woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);
    }
}

package com.hongguo.java8;

/**
 * House
 *
 * @author: chenghongguo
 * @date: 2019-07-23
 * @since 1.0.0
 */
public class House {

    Window w1 = new Window(1);

    House() {
        System.out.println("House()");
        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);

    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}

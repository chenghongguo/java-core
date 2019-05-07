package com.hongguo.java8.core;

/**
 * @author: chenghongguo
 * @date: 2019-04-18
 * @description:
 */
public class Child extends Parent {

    public static void main(String[] args) {
        Child child = new Child();
        child.setAge(10);
        System.out.println(child.getAge());
    }
}

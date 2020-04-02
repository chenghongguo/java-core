package com.hongguo.java.base.interfaces;

/**
 * Parent
 *
 * @author chenghongguo
 * @date 2020/3/27
 * @since 1.0.0
 */
public class Parent {

    public Parent() {
        System.out.println("before draw");
        draw();
        System.out.println("after draw");
    }

    public void draw() {
        System.out.println("Parent draw");
    }
}

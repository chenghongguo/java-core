package com.hongguo.java.base.interfaces;

/**
 * Sub
 *
 * @author chenghongguo
 * @date 2020/3/27
 * @since 1.0.0
 */
public class Sub extends Parent {

    public Sub() {
        System.out.println("Sub");
    }

    @Override
    public void draw() {
        System.out.println("Sub draw");
    }

    public static void main(String[] args) {
        new Sub();
    }
}

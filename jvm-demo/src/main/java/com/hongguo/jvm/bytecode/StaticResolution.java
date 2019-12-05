package com.hongguo.jvm.bytecode;

/**
 * StaticResolution
 *
 * @author chenghongguo
 * @date 2019/11/20
 * @since 1.0.0
 */
public class StaticResolution {

    public static void sayHello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}

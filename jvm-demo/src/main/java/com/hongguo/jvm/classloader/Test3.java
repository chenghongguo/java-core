package com.hongguo.jvm.classloader;

/**
 * Test3
 *
 * @author chenghongguo
 * @date 2019/10/11
 * @since 1.0.0
 */
public class Test3 {
    public static void main(String[] args) {
        Parent3[] parent3s = new Parent3[10];
        parent3s[0] = new Parent3();
    }
}

class Parent3 {
    static {
        System.out.println("parent3 static block");
    }
}

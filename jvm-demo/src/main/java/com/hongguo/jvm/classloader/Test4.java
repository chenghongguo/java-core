package com.hongguo.jvm.classloader;

/**
 * Test4
 *
 * @author chenghongguo
 * @date 2019/10/11
 * @since 1.0.0
 */
public class Test4 {

    public static void main(String[] args) {
        System.out.println(Child4.a);
        Child4.doSth();
    }
}

class Parent4 {
    public static int a = 2;

    static {
        System.out.println("Parent4 static block");
    }

    public static void  doSth() {
        System.out.println("do sth");
    }
}

class Child4 extends Parent4 {
    static {
        System.out.println("Child4 static block");
    }
}
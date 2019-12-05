package com.hongguo.jvm.classloader;

/**
 * Test1
 *
 * @author chenghongguo
 * @date 2019/10/9
 * @since 1.0.0
 */
public class Test1 {

    public static void main(String[] args) {
        System.out.println(Child1.str);
    }
}

class Parent1 {
    public static String str = "hello world";

    static  {
        System.out.println("Parent static block");
    }
}

class Child1 extends Parent1 {
    public static String str2 = "welcome";

    static {
        System.out.println("Child static block");
    }
}



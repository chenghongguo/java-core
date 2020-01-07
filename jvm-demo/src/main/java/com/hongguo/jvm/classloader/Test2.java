package com.hongguo.jvm.classloader;

/**
 * Test2
 * 类加载流程：
 *      加载 --> 链接(验证--准备--解析) --> 初始化 --> 使用 --> 卸载
 * 使用常量时：
 *      该常量会复制到调用方法所在类的常量池（编译期间）中，所以定义该常量的类不会被加载
 * @author chenghongguo
 * @date 2019/10/10
 * @since 1.0.0
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(Child2.a);
    }
}

class Parent2 {
    public static final int a = 1;

    static {
        System.out.println("Parent2 static block");
    }
}

class Child2 extends  Parent2 {
    public static int b = 3;

    static {
        System.out.println("Child2 static block");
    }
}

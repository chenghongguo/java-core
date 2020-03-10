package com.hongguo.java8.functionalinterface;

/**
 * Test2
 *
 * @author chenghongguo
 * @date 2020/2/18
 * @since 1.0.0
 */
public class Test2 {

    public static void main(String[] args) {
        SampleInterface1 interface1 = () -> {};
        System.out.println(interface1.getClass().getInterfaces()[0]);

        SampleInterface2 interface2 = () -> {};
        System.out.println(interface2.getClass().getInterfaces()[0]);

        // 编译错误，因为Lambda表达式必须要有对应的context环境
//        () -> {};
    }
}

@FunctionalInterface
interface SampleInterface1 {
    void method();
}

@FunctionalInterface
interface SampleInterface2 {
    void method2();
}
package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-05-07
 * @description:
 */
public class MyInterfaceImpl implements MyInterface {

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.test();
    }

    @Override
    public void test() {
        System.out.println("sub test");
        test2();
    }
}

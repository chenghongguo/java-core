package com.hongguo.java.base.abstracts;

/**
 * PureInterface
 *
 * @author chenghongguo
 * @date 2019/8/29
 * @since 1.0.0
 */
public interface PureInterface {
    int BBB = 111;
    class A {

    }

     static void main(String[] args) {
        PureInterface e = new B();
        System.out.println(PureInterface.BBB);
        System.out.println(e);
        A a = new A();
        System.out.println(a);
    }
}

class B implements PureInterface {
    int BBB = 222;
}
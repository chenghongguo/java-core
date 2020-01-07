package com.hongguo.jvm.init;

/**
 * Test
 *
 * @author chenghongguo
 * @date 2019/10/16
 * @since 1.0.0
 */
public class Test {

    static {
        i = 0;
//        System.out.println(i);
    }

    public static void main(String[] args) {
        System.out.println(Test.i);
    }

    static int i = 1;
}

package com.hongguo.jvm.bytecode;

/**
 * Test3
 *
 * @author chenghongguo
 * @date 2019/11/2
 * @since 1.0.0
 */
public class Test3 {

    static {
        System.out.println("Test3 static code");
    }

    public int add(int a, int b) {
        return a + b;
    }
}

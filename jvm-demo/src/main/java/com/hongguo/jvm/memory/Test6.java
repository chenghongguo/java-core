package com.hongguo.jvm.memory;

/**
 * Test6
 *
 * @author chenghongguo
 * @date 2019/11/8
 * @since 1.0.0
 */
public class Test6 {
    private Object object = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[_1MB];

    public static void main(String[] args) {
        Test6 testA = new Test6();
        Test6 testB = new Test6();

        testA.object = testB;
        testB.object = testA;

        testA = null;
        testB = null;

        System.gc();
    }
}

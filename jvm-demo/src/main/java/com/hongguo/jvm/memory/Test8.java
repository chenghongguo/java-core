package com.hongguo.jvm.memory;

/**
 * Test8
 *
 * @author chenghongguo
 * @date 2019/11/18
 * @since 1.0.0
 */
public class Test8 {
    public static void main(String[] args) {
        {
            byte[] b = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }
}

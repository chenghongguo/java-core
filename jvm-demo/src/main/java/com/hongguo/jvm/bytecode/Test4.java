package com.hongguo.jvm.bytecode;

/**
 * Test4
 *
 * @author chenghongguo
 * @date 2019/11/7
 * @since 1.0.0
 */
public class Test4 {
    public static void main(String[] args) {

        byte[] h = new byte[64 * 1024 * 1024];
        h = null;
        System.gc();
        int a = 0;
        System.out.println(a);
    }
}

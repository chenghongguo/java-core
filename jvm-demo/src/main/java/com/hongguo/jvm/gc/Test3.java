package com.hongguo.jvm.gc;

/**
 * Test3
 *
 * @author chenghongguo
 * @date 2019/11/21
 * @since 1.0.0
 */
public class Test3 {

    public static void main(String[] args) {
        gc();
        System.out.println("11111111");
        gc();
        System.out.println("2222222222");
        gc();
        System.out.println("3333333333");
        gc();
        System.out.println("4444444444");
    }

    private static void gc() {
        byte[] b = new byte[4 * 1024 * 1024];
    }
}

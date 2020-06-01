package com.hongguo.java.base.references;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * SoftReferenceTest
 *
 * @author chenghongguo
 * @date 2020/4/11
 * @since 1.0.0
 */
public class SoftReferenceTest {
    public static void main(String[] args) throws Exception {
        byte[] buffer = new byte[1024 * 1024 * 10];
        SoftReference<byte[]> b = new SoftReference<>(buffer);

        System.out.println(b.get());
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println(b.get());

        byte[] bytes = new byte[1024 * 1024 * 10];
        System.out.println(b.get());
    }
}

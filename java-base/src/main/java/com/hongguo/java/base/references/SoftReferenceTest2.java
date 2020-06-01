package com.hongguo.java.base.references;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * SoftReferenceTest2
 *
 * @author chenghongguo
 * @date 2020/4/28
 * @since 1.0.0
 */
public class SoftReferenceTest2 {

    private static List<SoftReference> list = new ArrayList<>();

    public static void main(String[] args) {
        testSoftReference();
    }

    private static void testSoftReference() {
        byte[] buffer = null;
        for (int i = 0; i < 10; i++) {
            buffer = new byte[1024 * 1024];
            SoftReference<byte[]> sr = new SoftReference<>(buffer);
            list.add(sr);
        }

        System.gc();

        // 打印软引用对象
        list.forEach(sr -> System.out.print(sr + " "));

        System.out.println("\n ----------------");

        // 打印软引用中的对象
        list.forEach(sr -> System.out.print(sr.get() + " "));

        System.out.println("\n ******************");

        System.out.println(buffer);
    }
}

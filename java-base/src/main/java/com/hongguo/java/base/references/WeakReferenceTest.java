package com.hongguo.java.base.references;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * WeakReferenceTest
 *
 * @author chenghongguo
 * @date 2020/4/11
 * @since 1.0.0
 */
public class WeakReferenceTest {

    private static List<WeakReference> list = new ArrayList<>();

    public static void main(String[] args) {
        testWeakReference();
    }

    private static void testWeakReference() {
        for (int i = 0; i < 10; i++) {
            byte[] buff = new byte[1024 * 1024];
            WeakReference<byte[]> sr = new WeakReference<>(buff);
            list.add(sr);
        }

        System.gc();

        // 打印软引用中的对象
        list.forEach(sr -> System.out.print(sr.get() + " "));
    }
}

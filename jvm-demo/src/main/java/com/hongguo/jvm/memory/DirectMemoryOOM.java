package com.hongguo.jvm.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * DirectMemoryOOM
 *
 * @author chenghongguo
 * @date 2019/11/7
 * @since 1.0.0
 */
public class DirectMemoryOOM {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1M);
        }
    }
}

package com.hongguo.java.base.references;

/**
 * StrongReference
 *
 * @author chenghongguo
 * @date 2020/4/11
 * @since 1.0.0
 */
public class StrongReference {
    public static void main(String[] args) {
        allocateStrongReference();
    }

    private static void allocateStrongReference() {
        byte[] bytes = new byte[1024 * 1024 * 20];
    }
}

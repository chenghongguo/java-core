package com.hongguo.java.base.references;

/**
 * M
 *
 * @author chenghongguo
 * @date 2020/4/11
 * @since 1.0.0
 */
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}

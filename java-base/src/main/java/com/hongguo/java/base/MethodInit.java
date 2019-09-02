package com.hongguo.java.base;

/**
 * MethodInit
 *
 * @author chenghongguo
 * @date 2019/8/21
 * @since 1.0.0
 */
public class MethodInit {
    int i = f();
    int j = g(i);

    int f() {
        return 11;
    }

    int g(int n) {
        return n * 10;
    }
}

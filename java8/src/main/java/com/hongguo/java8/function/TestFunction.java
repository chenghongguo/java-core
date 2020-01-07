package com.hongguo.java8.function;

import java.util.function.Function;

/**
 * TestFunction
 *
 * @author chenghongguo
 * @date 2019/11/6
 * @since 1.0.0
 */
public class TestFunction {

    public static int method(int type, Function<Integer, Integer> function) {
        return function.apply(type);
    }

    public static void main(String[] args) {
        int result = TestFunction.method(2, str -> {
            if (str == 1) {
                return a();
            } else {
                return b();
            }
        });
        System.out.println(result);
    }

    private static int a() {
        System.out.println("a");
        return 11;
    }

    private static int b() {
        System.out.println("b");
        return 22;
    }
}

package com.hongguo.java8;

/**
 * @author: chenghongguo
 * @date: 2019-01-30
 * @description:
 */
public class MyArrayOps {
    public static <T> int countMatching(T[] values, T v) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == v) {
                count++;
            }
        }
        return count;
    }
}

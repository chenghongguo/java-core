package com.hongguo.java.base;

import javax.validation.constraints.NotNull;

/**
 * TestNotNull
 *
 * @author chenghongguo
 * @date 2019/12/18
 * @since 1.0.0
 */
public class TestNotNull {

    public static void string(@NotNull String content) {
        System.out.println(content);
    }

    public static void main(String[] args) {
        string(null);
    }
}

package com.hongguo.java8;

/**
 * @author: chenghongguo
 * @date: 2019-01-30
 * @description:
 */
public class MyStringOps {

    public static String strReverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    public String reverse(String str) {
        return strReverse(str);
    }
}

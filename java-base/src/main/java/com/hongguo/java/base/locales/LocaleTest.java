package com.hongguo.java.base.locales;

import org.junit.Test;

import java.util.Locale;

/**
 * LocaleTest
 *
 * @author chenghongguo
 * @date 2020/4/13
 * @since 1.0.0
 */
public class LocaleTest {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        Locale n = new Locale("ss", "US");
        System.out.println(locale + ", " + n);
        System.out.println(locale.equals(n));
    }

    @Test
    public void test() {
        String s = "hello";
        String s2 = " world";
        String concat = s.concat(s2);
        System.out.println(concat);
    }
}

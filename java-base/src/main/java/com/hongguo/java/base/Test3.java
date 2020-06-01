package com.hongguo.java.base;

import org.junit.Test;

import java.util.Locale;

/**
 * Test3
 *
 * @author chenghongguo
 * @date 2020/4/3
 * @since 1.0.0
 */
public class Test3 {

    @Test
    public void test1() {
        Locale locale = new Locale("id");
        System.out.println(locale.getLanguage());
    }
}




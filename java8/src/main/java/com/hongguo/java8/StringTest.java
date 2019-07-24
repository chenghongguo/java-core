package com.hongguo.java8;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * StringTest
 *
 * @author: chenghongguo
 * @date: 2019-07-16
 * @since 1.0.0
 */
public class StringTest {

    @Test
    public void test4() {
        int time = 0;
        int maxRetry = 2;
        String result = null;
        do {
            time++;
            try {
                System.out.println(time);
                result = "hello";
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (null == result && time < maxRetry);
        System.out.println(result);
    }

    @Test
    public void test1() {
        String join = StringUtils.join(new Long[]{3L, 4L}, "-");
        System.out.println(join);
    }

    @Test
    public void test2() {
        System.out.println(this.getClass().getSimpleName());
        char c = 0;
        System.out.println(c);
        boolean b = Boolean.FALSE;
        System.out.println(b);
    }

    @Test
    public void test3() {
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2);

        i1 = 128;
        i2 = 128;
        System.out.println(i1.equals(i2));
    }
}

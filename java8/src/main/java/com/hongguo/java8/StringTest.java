package com.hongguo.java8;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * StringTest
 *
 * @author: chenghongguo
 * @date: 2019-07-16
 * @since 1.0.0
 */
public class StringTest {

    @Test
    public void test9() {
        String s = buildKey("img-text", "ids");
        System.out.println(s);
    }

    String buildKey(final String... keys) {
        if (keys.length <= 0) {
            return null;
        }
        StringJoiner joiner = new StringJoiner(":");
        joiner.add("xue");
        joiner.add("course");
        Arrays.stream(keys).filter(s -> s.length() > 0).forEach(joiner::add);
        return joiner.toString();
    }

    @Test
    public void test8() {
        Long s = 1000L;
        double d = s;
        System.out.println(d);
    }

    @Test
    public void test7() {
        List<Long> list = new ArrayList<>();
        list.add(10L);
        list.add(100L);
        list.add(1000L);
        String[] array = list.stream().map(Object::toString).toArray(String[]::new);
        for (String a : array) {
            System.out.println(a);
        }
    }

    @Test
    public void test6() {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("hello2");
        set.add("hello3");
        String[] strings = set.toArray(new String[0]);
        System.out.println(strings);
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test
    public void test5() {
        StringJoiner joiner = new StringJoiner(":");
        joiner.add("hello");
        joiner.add("");
        System.out.println(joiner.toString());
    }

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

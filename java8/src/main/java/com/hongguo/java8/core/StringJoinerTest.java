package com.hongguo.java8.core;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2019-02-27
 * @description:
 */
public class StringJoinerTest {

    @Test
    public void test1() {
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("java");
        stringJoiner.add("c++");
        stringJoiner.add("python");
        System.out.println(stringJoiner.toString());
    }

    @Test
    public void test2() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("java");
        stringJoiner.add("c++");
        stringJoiner.add("python");
        System.out.println(stringJoiner.toString());
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("java", "c++", "python");
        String collect = list.stream().collect(Collectors.joining(","));
        System.out.println(collect);
    }

    @Test
    public void test4() {
        StringJoiner joiner = new StringJoiner(",");
        System.out.println(joiner);
    }
}

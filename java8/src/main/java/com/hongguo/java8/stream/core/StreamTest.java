package com.hongguo.java8.stream.core;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * StreamTest
 *
 * @author chenghongguo
 * @date 2020/3/17
 * @since 1.0.0
 */
public class StreamTest {

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 7, 4, 5);
//        list = Collections.emptyList();
        int i = list.stream().mapToInt(Integer::intValue).max().orElse(1);
        System.out.println(i);
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("hello", "world");
        list.stream().map(String::length).forEach(System.out::println);
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("hello", "world");
        list.stream().forEach(System.out::println);

        list.forEach(System.out::println);

        JSONObject.toJSONString("hello");
    }
}

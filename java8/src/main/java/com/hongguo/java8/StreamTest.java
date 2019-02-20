package com.hongguo.java8;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2019-01-29
 * @description:
 */
public class StreamTest {

    private List<String> list;

    @Before
    public void before() {
        list = Arrays.asList("a", "afdb", "ahc", "bgd", "eqf", "eed", "2d3", "d30", "12");
    }

    @Test
    public void testForEach() {
        list.stream().forEach(System.out::println);
        System.out.println("==================");
        list.stream().forEach(e -> System.out.println(e));
        System.out.println("------------------");
        list.forEach(System.out::println);
    }

    @Test
    public void testFilter() {
        list.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        list.stream().limit(3).forEach(System.out::println);
    }

    @Test
    public void testSorted() {
        list.stream().sorted().forEach(System.out::println);
        System.out.println("============");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("=============");
        list.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
    }

    @Test
    public void testMap() {
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        list.stream().map(s ->  {
            if (s.length() > 2) {
                return s;
            }
            return null;
        }).forEach(System.out::println);
    }
}

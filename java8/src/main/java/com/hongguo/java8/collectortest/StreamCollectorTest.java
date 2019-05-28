package com.hongguo.java8.collectortest;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author: chenghongguo
 * @date: 2019-05-22
 * @description:
 */
public class StreamCollectorTest {

    @Test
    public void test3() {
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            System.out.println(start);
            partition(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println(duration);
        }
    }

    private Map<Boolean, List<Integer>> partition(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumbersCollector());
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("hello", "world", "java", "java", "python");
        for (int i = 0; i < 100; i++) {
            Map<String, String> collect =
                    list.parallelStream().collect(new MySetCollector2<>());
            collect.forEach((k, v) -> System.out.println(k + ", " + v));
        }
    }

    @Test
    public void test1() {
        List<String> list = Arrays.asList("hello", "world", "java", "java", "python");
        Set<String> set = list.stream().collect(new MySetCollector<>());
        set.forEach(System.out::println);
    }
}

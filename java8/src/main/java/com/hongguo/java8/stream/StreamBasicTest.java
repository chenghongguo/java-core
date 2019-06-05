package com.hongguo.java8.stream;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
public class StreamBasicTest {

    @Test
    public void test1() {
        Stream<String> stream = Stream.of("a", "b", "c").filter(item -> item.contains("b"));
        Optional<String> any = stream.findAny();
        any.ifPresent(System.out::println);
        Optional<String> first = stream.findFirst();
    }
}

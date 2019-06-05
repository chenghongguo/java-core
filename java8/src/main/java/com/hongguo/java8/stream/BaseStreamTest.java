package com.hongguo.java8.stream;

import org.junit.Test;

import java.util.stream.Stream;

/**
 * @author: chenghongguo
 * @date: 2019-05-28
 * @description:
 */
public class BaseStreamTest {

    @Test
    public void test1() {
        NullPointerException nullPointerException = new NullPointerException();
        try (Stream<String> stream = Stream.of("hello", "world", "hello world")) {
            stream.onClose(() -> {
                System.out.println("first onclose");
                throw nullPointerException;
            }).onClose(() -> {
                System.out.println("second close");
                throw nullPointerException;
            }).forEach(System.out::println);
        }
    }
}

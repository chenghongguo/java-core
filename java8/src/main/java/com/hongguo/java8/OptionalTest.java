package com.hongguo.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2019-01-29
 * @description:
 */
public class OptionalTest {

    @Test
    public void testOptionalOf() {
        List<String> list = null;
        List<String> collect = Optional.ofNullable(list).orElse(new ArrayList<>()).stream().collect(Collectors.toList());
        collect.forEach(obj -> System.out.println(obj));
    }

    @Test
    public void testOptionalOfNullable() {
        Optional<String> name = Optional.ofNullable(null);
        name.ifPresent(value -> System.out.println(value));

        Optional empty = Optional.ofNullable(null);
        System.out.println(empty.orElse("empty or else"));
        System.out.println(empty.orElseGet(() -> "Default value"));
    }
}

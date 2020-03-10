package com.hongguo.java.base;

import java.util.Arrays;
import java.util.List;

/**
 * ClassNameDemo
 *
 * @author chenghongguo
 * @date 2020/1/16
 * @since 1.0.0
 */
public class ClassNameDemo {
    public static void main(String[] args) {
        System.out.println(int.class.getName());
        System.out.println(String.class.getName());
        System.out.println(Object.class.getName());
        List<String> names = Arrays.asList("12", "23", "12", "45");
        names.stream().distinct().forEach(System.out::println);
    }
}

package com.hongguo.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * IntStreamTest
 *
 * @author chenghongguo
 * @date 2020/2/26
 * @since 1.0.0
 */
public class IntStreamTest {

    @Test
    public void test7() {
        List<String> list = Arrays.asList("hello", "world");
        StringBuilder collect = list.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(collect);
        StringJoiner joiner = new StringJoiner(",");
        list.forEach(joiner::add);
        System.out.println(joiner.toString());
    }

    @Test
    public void test6() {
        List<String> list = Arrays.asList("hello", "world");
        LinkedList collect = list.stream().collect(() -> new LinkedList(), (theList, item) -> theList.add(item), (list1, list2) -> list1.addAll(list2));
        collect.forEach(System.out::println);
        System.out.println("------------");

        LinkedList<Object> collect1 = list.stream().collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
        collect1.forEach(System.out::println);
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("hello", "world");
        List<String> collect = list.stream().collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void test4() {
        List<Integer> numbers = Arrays.asList(4, 5, 3, 9);
        Integer sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        System.out.println("----");
        Optional<Integer> reduce = numbers.stream().reduce(Integer::sum);
        reduce.ifPresent(System.out::println);
        System.out.println("--------");
        numbers.stream().reduce(Integer::max).ifPresent(System.out::println);

        Integer reduce1 = numbers.stream().map(n -> 1).reduce(0, Integer::sum);
        System.out.println(reduce1);
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("hello", "world");
        list.stream().map(word -> word.split("")).distinct().forEach(System.out::println);
        System.out.println("------");
        list.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().forEach(System.out::println);
    }

    @Test
    public void tes2() {
        int sum = IntStream.range(1, 10).sum();
        System.out.println(sum);
        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 10).average();
        optionalDouble.ifPresent(System.out::println);

        IntStream.of(1, 13, 3, 4, 5).sorted().forEach(System.out::println);
    }

    @Test
    public void test1() {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        int sum = intStream.sum();
        System.out.println(sum);
    }
}

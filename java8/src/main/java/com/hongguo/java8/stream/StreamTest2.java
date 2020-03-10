package com.hongguo.java8.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * StreamTest2
 *
 * @author chenghongguo
 * @date 2020/2/27
 * @since 1.0.0
 */
public class StreamTest2 {

    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> result = list.stream()
                .reduce(new ArrayList<>(),
                        new BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {
                                acc.add(item);
                                System.out.println("item:" + item);
                                System.out.println("acc + :" + acc);
                                System.out.println("BiFunction");
                                return acc;
                            }
                        },
                        new BinaryOperator<ArrayList<Integer>>() {
                            @Override
                            public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
                                System.out.println("BinaryOpertator.............");
                                acc.addAll(item);
                                System.out.println("item:" + item);
                                System.out.println("acc + :" + acc);
                                return acc;
                            }
                        });
        System.out.println("result: =" + result);
    }

    @Test
    public void testMapReduce3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Optional<Integer> optional = list.stream().reduce(Integer::min);
        optional.ifPresent(System.out::println);
        optional = list.stream().reduce(Integer::max);
        optional.ifPresent(System.out::println);
        Optional<Integer> max = list.stream().max(Comparator.comparingInt(a -> -a));
        max.ifPresent(System.out::println);
    }

    @Test
    public void testMapReduce2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println("------------");
        Optional<Integer> optional = list.stream().reduce(Integer::sum);
        optional.ifPresent(System.out::println);
    }

    @Test
    public void testMapReduce1() {
        List<String> list = Arrays.asList("hello", "world", "hello world2");
//        Integer sum = list.stream().map(i -> i.length()).reduce(0, Integer::sum);
        Integer sum = list.stream().map(String::length).reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    public void testFlatMap1() {
        List<String> list = Arrays.asList("hello", "world");
        list.stream().map(i -> i.split("")).flatMap(Stream::of).distinct().forEach(System.out::println);
    }
}

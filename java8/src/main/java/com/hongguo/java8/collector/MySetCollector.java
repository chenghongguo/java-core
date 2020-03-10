package com.hongguo.java8.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * MySetCollector
 *
 * @author chenghongguo
 * @date 2020/3/10
 * @since 1.0.0
 */
public class MySetCollector<T> implements Collector<T, Set<T>, Map<T, T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        return (set, item) -> {
            System.out.println("set:" + set + ", " + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        return (left, right) -> {
            left.addAll(right);
            return left;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        return set -> {
            Map<T, T> map = new HashMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED, Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello", "world", "hello world", "a", "b", "c", "d", "e");
        for (int i = 0; i < 10; i++) {
            Map<String, String> map = list.parallelStream().collect(new MySetCollector<>());
            System.out.println(map);
        }
    }
}

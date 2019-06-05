package com.hongguo.java8.collectortest;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author: chenghongguo
 * @date: 2019-06-04
 * @description:
 */
public class MyListCollector<Employee> implements Collector<Employee, List<Employee>, List<Employee>> {

    @Override
    public Supplier<List<Employee>> supplier() {
        return null;
    }

    @Override
    public BiConsumer<List<Employee>, Employee> accumulator() {
        return null;
    }

    @Override
    public BinaryOperator<List<Employee>> combiner() {
        return null;
    }

    @Override
    public Function<List<Employee>, List<Employee>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}

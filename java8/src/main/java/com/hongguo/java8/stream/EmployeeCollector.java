package com.hongguo.java8.stream;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
public class EmployeeCollector implements Collector<Employee, List<Employee>, Map<String, Double>> {

    @Override
    public Supplier<List<Employee>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Employee>, Employee> accumulator() {
        return (list, employee) -> {
            list.add(employee);
        };
    }

    @Override
    public BinaryOperator<List<Employee>> combiner() {
        return null;
    }

    @Override
    public Function<List<Employee>, Map<String, Double>> finisher() {
        return list -> {
            Map<String, Double> collect = list.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.summingDouble(Employee::getSalary)));
            return collect;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.IDENTITY_FINISH);
    }
}

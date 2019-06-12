package com.hongguo.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
public class StreamBasicTest {

    private List<Employee> employees;

    @Before
    public void init() {
        employees = new ArrayList<>();
        employees.add(new Employee(1, "张三", 5, "研发部", 1000.00, Status.FREE));
        employees.add(new Employee(2, "李四", 7, "测试部", 2340.00, Status.VOCATION));
        employees.add(new Employee(3, "王五", 9, "研发部", 5670.00, Status.BUSY));
        employees.add(new Employee(4, "赵六", 2, "前端部", 7890.00, Status.BUSY));
        employees.add(new Employee(5, "田七", 1, "前端部", 3000.00, Status.FREE));
        employees.add(new Employee(6, "赵四", 3, "研发部", 4000.00, Status.BUSY));
        employees.add(new Employee(7, "刘能", 4, "研发部", 2000.00, Status.BUSY));
    }

    @Test
    public void test5() {
        employees.stream().collect(new EmployeeCollector()).forEach((k, v) -> System.out.println("k = " + k + ", v = " + v));
    }

    @Test
    public void test4() {
        Collector<Employee, ?, LinkedList<Employee>> toLinkedList = Collector.of(LinkedList::new, LinkedList::add, (left, right) -> {
            left.addAll(right);
            return left;
        });
        employees.stream().collect(toLinkedList).forEach(System.out::println);
    }

    @Test
    public void test3() {
        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });

        System.out.println(reducedParams);

        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    System.out.println("combiner was called");
                    return a + b;
                });
        System.out.println(reducedParallel);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("abc1", "abc2", "abc3");
        Optional<String> stream = list.stream().filter(element -> {
            System.out.println("filter() was called");
            return element.contains("2");
        }).map(element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();
    }

    @Test
    public void test1() {
        Stream<String> stream = Stream.of("a", "b", "c").filter(item -> item.contains("b"));
        Optional<String> any = stream.findAny();
        any.ifPresent(System.out::println);
        // streams can’t be reused.
        stream.findFirst();
    }
}

package com.hongguo.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: chenghongguo
 * @date: 2019-02-18
 * @description:
 */
public class StreamTest {

    private List<Employee> employees;

    @Before
    public void init() {
        employees = Arrays.asList(
                new Employee(1, "张三", 1, "研发部", 1000.00, Status.FREE),
                new Employee(2, "李四", 2, "测试部", 2340.00, Status.VOCATION),
                new Employee(3, "王五", 1, "研发部", 5670.00, Status.BUSY),
                new Employee(4, "赵六", 2, "前端部", 7890.00, Status.BUSY),
                new Employee(5, "田七", 1, "前端部", 3000.00, Status.FREE),
                new Employee(6, "赵四", 2, "研发部", 4000.00, Status.BUSY),
                new Employee(7, "刘能", 2, "研发部", 2000.00, Status.BUSY),
                new Employee(7, "刘能", 2, "研发部", 2000.00, Status.BUSY)
        );
    }

    @Test
    public void test14() {
        employees.sort(Comparator.comparing(Employee::getSalary));
        employees.forEach(employee -> System.out.println(employee));
    }

    // 分组
    @Test
    public void test13() {
        ConcurrentMap<Status, List<Employee>> collect2 = employees.stream().collect(Collectors.groupingByConcurrent(Employee::getStatus));
        System.out.println(collect2);
        System.out.println(collect2.get(Status.BUSY));
    }

    /**
     * 需求：搜索名字中 “四” 出现的次数
     */
    @Test
    public void test12() {
        Optional<Integer> count = employees.stream().map(Employee::getName)
                .flatMap(StreamTest::filterCharacter).map(ch -> {
                    if (ch.equals('四')) {
                        return 1;
                    } else {
                        return 0;
                    }
                }).reduce(Integer::sum);
        System.out.println(count.get());
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * map - reduce
     */
    @Test
    public void test11() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Double> reduce = employees.stream().map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce.get());
    }

    /**
     * 收集
     * collect(Collector c)  将流转换为其他形式。
     */
    @Test
    public void test10() {
        employees.stream().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-------------");
        employees.stream().collect(Collectors.toSet()).forEach(System.out::println);

        // 分组
        Map<Status, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
        Map<Status, Map<String, List<Employee>>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getDeptName)));
        System.out.println(map);
        System.out.println("--------------");
        // 分区
        Map<Boolean, List<Employee>> mapResult = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 1000));
        System.out.println(mapResult);
        Map<Boolean, Map<Boolean, List<Employee>>> partMap = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 4000, Collectors.partitioningBy(e -> e.getStatus().equals(Status.VOCATION))));
        System.out.println(partMap);

        // 聚合运算
        Optional<Employee> collect1 = employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(e -> e.getSalary())));
        System.out.println(collect1.get());
        DoubleSummaryStatistics summaryStatistics = employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(summaryStatistics.getMax() + ", " + summaryStatistics.getMin() + ", "
                + summaryStatistics.getAverage() + ", " + summaryStatistics.getCount() + ", " + summaryStatistics.getSum());
    }

    /**
     * 终止操作
     * count: 总数
     * max：最大值
     * min：最小值
     * forEach：内部迭代
     */
    @Test
    public void test9() {
        long count = employees.stream().filter(e -> e.getSalary() > 3000).count();
        System.out.println(count);
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(e -> e.getSalary()));
        System.out.println(max.get());
    }

    /**
     * 查找与匹配
     * allMatch(Predicate p) 检查是否匹配所有元素
     * anyMatch(Predicate p) 检查是否至少匹配一个元素
     * noneMatch(Predicatep) 检查是否没有匹配所有元素
     * findFirst() 返回第一个元素
     * findAny() 返回当前流中的任意元素
     */
    @Test
    public void test8() {
        boolean allMatch = employees.stream().allMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(allMatch);
        boolean anyMatch = employees.stream().anyMatch(e -> e.getStatus().equals(Status.BUSY));
        System.out.println(anyMatch);
        boolean noneMatch = employees.stream().noneMatch(e -> e.getSalary() < 3000);
        System.out.println(noneMatch);
        Optional<Employee> first = employees.stream().sequential().filter(e -> e.getSalary() > 1000).findFirst();
        System.out.println(first.isPresent() ? first.get() : null);
        Optional<Employee> first1 = employees.parallelStream().filter(e -> e.getSalary() > 1000).findFirst();
        System.out.println(first1.get());
        Optional<Employee> any = employees.stream().parallel().filter(e -> e.getSalary() > 2000).findAny();
        System.out.println(any.get());
    }

    @Test
    public void test7() {
        employees.stream().sorted(Comparator.comparingDouble(e -> e.getSalary())).forEach(System.out::println);
    }

    @Test
    public void test6() {
        Optional<Double> reduce = employees.stream().map(e -> e.getSalary()).reduce(Double::max);
        System.out.println(reduce.get());
        Optional<Double> reduce1 = employees.stream().map(e -> e.getSalary()).reduce(Double::min);
        System.out.println(reduce1.get());
    }

    @Test
    public void test5() {
        String s = employees.stream().map(e -> e.getName()).collect(Collectors.joining(","));
        System.out.println(s);
    }

    // 分片
    @Test
    public void test4() {
        Map<Boolean, List<Employee>> map = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getGender() == 1));
        System.out.println(map);
        System.out.println("-------------------");
        Map<Boolean, Map<Boolean, List<Employee>>> collect = employees.stream().collect(Collectors.partitioningBy(employee -> employee.getGender() == 1, Collectors.partitioningBy(employee -> employee.getStatus() == Status.BUSY)));
        System.out.println(collect);
    }

    // 分组
    @Test
    public void test3() {
        employees.stream().filter(e -> e.getDeptName().equals("研发部")).forEach(System.out::println);
        System.out.println("------------------");
        Map<Status, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
        System.out.println("-----------------");
        Map<Status, Map<String, List<Employee>>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getDeptName)));
        System.out.println(collect);
    }

    // 映射
    @Test
    public void test2() {
        List<String> strings = employees.stream().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(strings);
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
                "hello world welcome");

        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("-----------------------------");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }

    // 聚合运算
    @Test
    public void test1() {
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(e -> e.getSalary()));
        System.out.println(max.get());
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(e -> e.getSalary()));
        System.out.println(min.get());
    }
}

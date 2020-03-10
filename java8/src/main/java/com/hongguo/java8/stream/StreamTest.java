package com.hongguo.java8.stream;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author: chenghongguo
 * @date: 2019-02-18
 * @description:
 */
public class StreamTest {

    private List<Employee> employees;
    private List<Employee> employees2;

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

        employees2 = Arrays.asList(
                new Employee(1, "张三2", 5, "研发部", 1000.00, Status.FREE),
                new Employee(2, "李四2", 7, "测试部", 2340.00, Status.VOCATION),
                new Employee(3, "王五2", 9, "研发部", 5670.00, Status.BUSY),
                new Employee(4, "赵六2", 2, "前端部", 7890.00, Status.BUSY),
                new Employee(5, "田七2", 1, "前端部", 3000.00, Status.BUSY)
        );
    }

    @Test
    public void  test52() {
        Stream<String> stream = Arrays.asList("hello", "world", "hello world").stream();
        stream.mapToInt(String::length).forEach(System.out::println);
    }

    @Test
    public void test51() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
        String[] array = new String[]{"a", "b", "c"};
        Stream<String> stream1 = Arrays.stream(array);
        stream1.filter(s -> {
            System.out.println("fkjdsjfdsljflkds");
            return true;
        }).filter(s -> {
            System.out.println("fjdskjflds");
            return false;
        });
    }

    @Test
    public void test50() {
        employees2.stream().filter(employee -> Status.BUSY.equals(employee.getStatus()))
                .forEach(employee -> employee.setGender(3));
        employees2.forEach(System.out::println);
    }

    @Test
    public void test49() {
        // 比较集合的forEach与stream的forEach：操作结果一致，但是集合的forEach执行效率较高
        employees.forEach(e -> {
            e.setSalary(1000.00);
            System.out.println(e);
        });
        System.out.println("-----1---------");
        System.out.println(employees);
        System.out.println("------1--------");
        employees2.stream().forEach(e -> {
            e.setSalary(2000.00);
            System.out.println(e);
        });
        System.out.println("------2--------");
        System.out.println(employees2);
        System.out.println("------2--------");
    }

    @Test
    public void test48() {
        Consumer<String> consumer = msg -> System.out.println(msg);

        consumer.accept("hongguo");
    }

    @Test
    public void test47() {
        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 4).peek(e -> {
            String age = e + "_abc";
            System.out.println(age);
        })
                .map(String::toUpperCase).peek(e -> System.out.println("Map value: " + e)).collect(Collectors.toList());
    }

    @Test
    public void test46() {
        List<String> list = Arrays.asList("hello", "world", "hello world", "test");
        list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);

        Consumer consumer = (msg) -> System.out.println("test");
        consumer.accept("hello");
    }

    @Test
    public void test45() {
        Map<String, Optional<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingDouble(Employee::getSalary)))));
        collect.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    @Test
    public void test44() {
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(2, 100).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(candidate)));
        System.out.println(collect.get(true));
        System.out.println(collect.get(false));
    }

    private boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
    }

    @Test
    public void test43() {
        int candidate = 100;
        boolean b = IntStream.range(2, candidate).noneMatch(i -> candidate % i == 0);
        System.out.println(b);
    }

    @Test
    public void test42() {
        List<String> list = Arrays.asList("hello", "world", "java", "python");
        list.stream().filter(item -> item.length() > 4).map(item -> item.toUpperCase()).forEach(System.out::println);
    }

    @Test
    public void test41() {
        String collect = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

    @Test
    public void test40() {
        Double sum = employees.stream().collect(Collectors.summingDouble(e -> e.getSalary()));
        System.out.println(sum);
    }

    @Test
    public void test39() {
        Map<Boolean, Long> map = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 4000, Collectors.counting()));
        map.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    @Test
    public void test38() {
        Map<Status, Double> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.summingDouble(Employee::getSalary)));
        map.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    @Test
    public void test37() {
        Map<String, Double> map = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.summingDouble(Employee::getSalary)));
        map.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    @Test
    public void test36() {
        Double sum = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
    }

    @Test
    public void test35() {
        long start = System.currentTimeMillis();
        Map<String, List<String>> listMap = employees.parallelStream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.mapping(Employee::getName, Collectors.toList())));
        listMap.forEach((k, v) -> System.out.println(k + ", " + v));
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test34() {
        long start = System.currentTimeMillis();
        Map<String, List<String>> listMap = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.mapping(Employee::getName, Collectors.toList())));
        listMap.forEach((k, v) -> System.out.println(k + ", " + v));
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test33() {
        Map<String, Long> collect = employees.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + ", " + v));
    }

    @Test
    public void test32() {
        String collect = employees2.stream().map(Employee::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }

    @Test
    public void test31() {
        employees2.stream().collect(Collectors.groupingBy(Employee::getStatus)).forEach((k, v) -> System.out.println(k + ", " + v));
    }

    @Test
    public void test30() {
        Map<Boolean, List<Employee>> listMap = employees.stream().collect(Collectors.partitioningBy(Employee::isDev));
        List<Employee> employees = listMap.get(Boolean.TRUE);
        System.out.println(employees);
    }

    @Test
    public void test29() {
        LocalDate startDate = LocalDate.of(2019, Month.MAY, 19);
        LocalDate forbidPeriodDate = LocalDate.now().plusDays(4);
        boolean after = forbidPeriodDate.isAfter(startDate);
        System.out.println(after);
    }

    @Test
    public void test28() {
        String[] array = new String[]{"hello", "world", "hello world"};
        Stream<String> stream = Stream.of(array);
        stream.forEach(System.out::println);
        System.out.println("------------");

        Stream<String> stringStream = Arrays.stream(array);
        stringStream.forEach(System.out::println);
    }

    @Test
    public void test27() {
        Stream.iterate(1, item -> item * 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void test26() {
        Stream<String> generate = Stream.generate(String::new).limit(10);
        generate.forEach(System.out::println);
    }

    @Test
    public void test25() {
        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        Integer count = listStream.flatMap(list -> list.stream()).map(item -> item * 2).reduce(0, Integer::sum);
        System.out.println(count);
    }

    @Test
    public void test24() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        LongStream longStream = stream.mapToLong(Integer::longValue);
        longStream.forEach(System.out::println);
        stream = Stream.of(1, 2, 3, 4);
        int sum = stream.mapToInt(item -> item.intValue()).sum();
        System.out.println(sum);
    }

    @Test
    public void test23() {
        employees2.forEach(employee -> {
            employee.setGender(300);
        });

        employees2.forEach(System.out::println);
    }

    @Test
    public void test22() {
        String s = JSONObject.toJSONString("");
        System.out.println(s);
        s = JSONObject.toJSONString(null);
        System.out.println(s);
    }

    @Test
    public void test21() {
        employees.removeIf(employee -> {
            if (employee.getId() > 2) {
                return false;
            } else {
                return true;
            }
        });
        System.out.println(employees);
    }

    @Test
    public void test20() {
        employees.stream().filter(employee -> employees2.stream().noneMatch(employee1 -> employee1.getId().equals(employee.getId()))).forEach(System.out::println);
    }

    @Test
    public void test19() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> all = null;
        List<Integer> collect = Optional.ofNullable(all).orElse(new ArrayList<>()).stream().collect(Collectors.toList());
        list1.addAll(collect);
        System.out.println(list1);
    }

    @Test
    public void test18() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);

        System.out.println("====求交集===");
        List<Integer> list = list1.stream().filter(t -> list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);


        System.out.println("====求差集===");
        list = list1.stream().filter(t -> !list2.contains(t)).collect(Collectors.toList());
        list.stream().forEach(System.out::println);


        System.out.println("====求并集===");
        list.addAll(list1);
        list.addAll(list2);
        list = list.stream().distinct().collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test17() {
        List<String> list = Arrays.asList("[1-2]", "[2-3]");
        System.out.println(list);
    }

    @Test
    public void test16() {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            for (int i = 0; i < 3; i++) {
                employee.setGender(i);
                Employee bean = toBean(employee, Employee.class);
                System.out.println(JSONObject.toJSONString(bean) + ", " + JSONObject.toJSONString(employee));
                list.add(bean);
            }
        }

        System.out.println("===================");
        System.out.println(list.size());
        System.out.println("===================");
        list.forEach(System.out::println);
    }

    public static <T> T toBean(Object source, Class<T> target) {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(source);
        return JSONObject.parseObject(jsonObject.toJSONString(), target);
    }

    @Test
    public void test15() {
        employees.stream().sorted(Comparator.comparingInt(Employee::getGender)).collect(Collectors.toList())
                .forEach(employee -> System.out.println(employee));
        employees.sort(Comparator.comparing(Employee::getSalary));
        employees.forEach(employee -> System.out.println(employee));
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

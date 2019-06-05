package com.hongguo.java8.collectortest;

import com.hongguo.java8.stream.Employee;
import com.hongguo.java8.stream.Status;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author: chenghongguo
 * @date: 2019-06-04
 * @description:
 */
public class MyListTest {

    // 全量数据
    private List<Employee> employees;
    // 部分数据
    private List<Employee> employees2;
    // 托底数据
    private List<Employee> employees3;

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
                new Employee(5, "田七2", 1, "前端部", 3000.00, Status.BUSY)
        );

        employees3 = Arrays.asList(
                new Employee(0, "张三2", 5, "研发部", 1000.00, Status.FREE)
        );
    }

    @Test
    public void test1() {
        List<Employee> collect = employees2.stream()
                .map(employee -> employees.stream().anyMatch(employee1 -> employee.getId().equals(employee1.getId())) ? employee : null)
                .filter(Objects::nonNull).collect(new MyListCollector<>());
        collect.forEach(System.out::println);
    }
}

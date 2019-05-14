package com.hongguo.java8.methodreference;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2019-05-13
 * @description:
 */
public class StudentTest {

    private List<Student> students = new ArrayList<>();

    @Before
    public void before() {
        students.add(new Student("zhangsan", 20));
        students.add(new Student("lisi", 50));
        students.add(new Student("wangwu", 10));
        students.add(new Student("zhaoliu", 90));
    }

    @Test
    public void test3() {
        LocalDate forbidPeriodDate = LocalDate.now().plusDays(4);
        System.out.println(forbidPeriodDate);
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add(null);
        System.out.println(list);
    }

    @Test
    public void test1() {
        students.sort(Student::compareByScore);
        students.forEach(System.out::println);
    }
}

package com.hongguo.java8.methodreference;

import org.junit.Before;
import org.junit.Test;

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
    public void testInstanceMethodRef2() {
        StudentComparator comparator = new StudentComparator();
        students.sort(comparator::compare);
        students.forEach(System.out::println);
    }

    @Test
    public void testStaticMethodRef2() {
        students.sort(Student::compareByName);
        students.forEach(System.out::println);
    }

    @Test
    public void testStaticMethodRef() {
        students.sort(Student::compareByScore);
        students.forEach(System.out::println);
    }

    @Test
    public void test1() {
        students.sort(Student::compareByScore);
        students.forEach(System.out::println);
    }
}

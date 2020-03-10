package com.hongguo.java8.functionalinterface;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * BiFunctionTest
 *
 * @author chenghongguo
 * @date 2020/2/20
 * @since 1.0.0
 */
public class BiFunctionTest {

    private List<Student> students;

    @Before
    public void before() {
        Student s1 = new Student(20, "zhangsan");
        Student s2 = new Student(30, "lisi");
        Student s3 = new Student(40, "wangwu");
        students = Arrays.asList(s1, s2, s3);
    }

    @Test
    public void testAndThen() {
        Function<Integer, Integer> function = value -> value * value;

        BiFunction<Integer, Integer, Integer> biFunction = (value2, value3) -> value2 + value3;

        // result = (10 + 5) * (10 + 5)
        Integer result = biFunction.andThen(function).apply(10, 5);
        System.out.println(result);
    }

    @Test
    public void testApply() {
        List<Student> students = findStudentByAge(20, this.students);
        students.forEach(student -> System.out.println(student.getAge()));
        System.out.println("-------------------");
        students = findStudentByAge2(20, students, (age, studentList) ->
                studentList.stream().filter(student -> student.getAge() > age).collect(Collectors.toList()));
        students.forEach(student -> System.out.println(student.getAge()));
    }

    private List<Student> findStudentByAge(Integer age, List<Student> students) {
        BiFunction<Integer, List<Student>, List<Student>> biFunction = (ageOfStu, studentList) ->
                studentList.stream().filter(student -> student.getAge() > ageOfStu).collect(Collectors.toList());
        return biFunction.apply(age, students);
    }

    private List<Student> findStudentByAge2(Integer age, List<Student> students, BiFunction<Integer, List<Student>, List<Student>> biFunction) {
        return biFunction.apply(age, students);
    }
}

class Student {
    private Integer age;

    private String name;

    public Student(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

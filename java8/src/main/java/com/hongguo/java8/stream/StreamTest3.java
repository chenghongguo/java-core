package com.hongguo.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamTest3
 *
 * @author chenghongguo
 * @date 2020/3/3
 * @since 1.0.0
 */
public class StreamTest3 {

    private List<Person> persons;

    @Before
    public void before() {
        persons = new ArrayList<>();
        persons.add(new Person("zhangsan", 20, 90));
        persons.add(new Person("lisi", 30, 80));
        persons.add(new Person("wangwu", 25, 100));
        persons.add(new Person("wangwu", 40, 70));
    }

    @Test
    public void test() {
        Stream<Person> stream = persons.stream();
        Stream<String> stringStream = Stream.of("hello", "world");
        String[] array = new String[]{"a", "b"};
        Stream<String> arrayStream = Stream.of(array);
        Stream<String> stringStream1 = Arrays.stream(array);
    }

    @Test
    public void test1() {
        persons.stream().collect(Collectors.groupingBy(Person::getAge)).forEach((k, v) -> System.out.println(k + "=" + v));
    }

    @Test
    public void test2() {
        Map<String, Map<Integer, List<Person>>> map = persons.stream().collect(Collectors.groupingBy(Person::getName, Collectors.groupingBy(Person::getScore)));
        Map<Integer, List<Person>> lisi = map.get("lisi");
        List<Person> people = lisi.get(80);
        people.forEach(System.out::println);
    }

    @Test
    public void test3() {
        Map<Boolean, List<Person>> map = persons.stream().collect(Collectors.partitioningBy(item -> item.getScore() >= 90));
        List<Person> people = map.get(true);
        people.forEach(System.out::println);
    }

    @Test
    public void test4() {
        persons.stream().collect(Collectors.partitioningBy(item -> item.getScore() >= 90, Collectors.partitioningBy(i -> i.getAge() > 20)))
                .forEach((k, v) -> System.out.println(k + "=" + v));
    }
}

class Person {
    private String name;
    private int age;
    private int score;

    public Person(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}

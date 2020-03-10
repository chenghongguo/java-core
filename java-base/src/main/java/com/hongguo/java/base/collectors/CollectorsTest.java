package com.hongguo.java.base.collectors;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * CollectorsTest
 *
 * @author chenghongguo
 * @date 2020/3/5
 * @since 1.0.0
 */
public class CollectorsTest {

    private List<Person> persons;

    @Before
    public void before() {
        persons = new ArrayList<>();
        persons.add(null);
        persons.add(null);
        persons.add(new Person("zhangsan", 20, 90));
        persons.add(new Person("lisi", 30, 80));
        persons.add(new Person("wangwu", 25, 100));
        persons.add(new Person("wangwu", 40, 70));
        persons.add(null);
    }

    @Test
    public void test6() {
        Map<Boolean, List<Integer>> map = IntStream.range(2, 100).boxed().collect(new PrimeNumberCollector());
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    @Test
    public void test5() {
        Long collect = Stream.iterate(1, item -> item + 1).limit(100000).parallel().mapToLong(item -> item).sum();
        System.out.println(collect);
    }

    @Test
    public void test4() {
        persons.sort(Comparator.nullsLast(Comparator.comparingInt(Person::getAge)));
        System.out.println(persons);
    }

    @Test
    public void test3() {
        persons.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge, Comparator.reverseOrder()));
        System.out.println(persons);
    }

    @Test
    public void testToMap() {
        Map<Integer, Person> map = persons.stream().collect(toMap(Person::getScore, Function.identity()));
        map.forEach((k, v) -> System.out.println(k + "=" + v));
    }

    @Test
    public void testToCollection() {
        TreeSet<String> treeSet = persons.stream().map(Person::getName).collect(toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);
    }

    @Test
    public void testJoiner() {
        String collect = persons.stream().map(Person::getName).collect(joining());
        System.out.println(collect);

        collect = persons.stream().map(Person::getName).collect(joining(","));
        System.out.println(collect);

        collect = persons.stream().map(Person::getName).collect(joining(",", "[", "]"));
        System.out.println(collect);
    }

    @Test
    public void testSumInt() {
        Integer sum = persons.stream().mapToInt(Person::getAge).sum();
        System.out.println(sum);

        long sum1 = persons.stream().mapToLong(Person::getAge).sum();
        System.out.println(sum1);

        IntSummaryStatistics statistics = persons.stream().collect(summarizingInt(Person::getAge));
        System.out.println(statistics);
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
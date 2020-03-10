package com.hongguo.java.base;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * StringTest
 *
 * @author chenghongguo
 * @date 2020/3/4
 * @since 1.0.0
 */
public class StringTest {

    private List<Person> peoples;

    @Before
    public void before() {
        peoples = Arrays.asList(new Person("zhan#gsan", 20), new Person("li#si", 30));
    }

    @Test
    public void test() {
        peoples.forEach(person -> replace2Space.apply(person));
        peoples.forEach(System.out::println);
        String dsl = "jurisdiction";
    }

    private Function<Person, Person> replace2Space = person -> {
        person.setName(person.getName().replace("#", " "));
        return person;
    };

    @Test
    public void  test1() {
        for (Person person : peoples) {
           person.setAge(50);
        }

        peoples.forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

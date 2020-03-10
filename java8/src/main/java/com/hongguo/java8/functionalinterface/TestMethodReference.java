package com.hongguo.java8.functionalinterface;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * TestMethodReference
 *
 * @author chenghongguo
 * @date 2020/2/18
 * @since 1.0.0
 */
public class TestMethodReference {

    @Test
    public void testStringSort() {
        List<String> list = Arrays.asList("a", "b", "A", "B");
//        list.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        list.sort(String::compareToIgnoreCase);
        list.forEach(System.out::println);
    }

    @Test
    public void testSupplier() {
        Supplier<Person> supplier = Person::new;
        Person person = supplier.get();
        System.out.println(person);
    }

    @Test
    public void testFunction() {
        Function<Integer, Person> personFunction = Person::new;
        Person apply = personFunction.apply(100);
        System.out.println(apply);
    }
}

class Person {

    private Integer age;

    public Person() {}

    public Person(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
package com.hongguo.java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * FinallyTest
 *
 * @author chenghongguo
 * @date 2019/7/30
 * @since 1.0.0
 */
public class FinallyTest {

    public static void main(String[] args) {
        int i = f();
        System.out.println(i);

        StringBuilder s = fun();
        System.out.println(s.toString());

        System.out.println(string());

        System.out.println(list());

        System.out.println(person());

        System.out.println(date().getTime());

        try {
            throw new RuntimeException();
        } finally {
            System.out.println("fjkdsl");
        }
    }

    public static int f() {
        Integer i = 10;
        try {
            return i;
        } catch (Exception e) {
            i = 20;
            return i;
        } finally {
            i = 30;
        }
    }

    public static StringBuilder fun() {
        StringBuilder s = new StringBuilder("Hello");
        try {
            s.append("World");
            return s;
        } catch (Exception e) {
            return s;
        } finally {
            s.append("Finally");
        }
    }

    public static String string() {
        String s = new String("hello");
        try {
            s = new String("world");
            return s;
        } catch (Exception e) {
            return s;
        } finally {
            s = s + "finally";
        }
    }

    public static List<String> list() {
        List<String> list = new ArrayList<>();
        try {
            list.add("hello");
            list.add("world");
            int i = 10 / 0;
        } catch (Exception e) {
            list.add("catch");
            return list;
        } finally {
            list.add("finally");
            return list;
        }
    }

    public static Date date() {
        Date date = new Date();
        try {
            Thread.sleep(1000);
            return date;
        } catch (Exception e) {
            return date;
        } finally {
            date = new Date();
            System.out.println("----->" + date.getTime());
        }
    }

    public static Person person() {
        Person person = new Person();
        person.setId(100);
        person.setName("1000");
        try {
            person = new Person();
            person.setId(200);
            person.setName("2000");
            return person;
        } catch (Exception e) {
            return person;
        } finally {
            person.setId(300);
            person.setName("3000");
        }
    }
}

class Person {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
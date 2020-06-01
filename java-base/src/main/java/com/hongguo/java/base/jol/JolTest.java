package com.hongguo.java.base.jol;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 * JolTest
 *
 * @author chenghongguo
 * @date 2020/4/10
 * @since 1.0.0
 */
public class JolTest {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("---------------");
        new Thread(() -> {
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
    }

    @Test
    public void test1() {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    @Test
    public void testStu() {
        Student student = new Student();
        student.setAge(10);
        student.setName("hongguo");
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
        synchronized (student) {
            System.out.println(ClassLayout.parseInstance(student).toPrintable());
        }
    }
}

class Student {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;

    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

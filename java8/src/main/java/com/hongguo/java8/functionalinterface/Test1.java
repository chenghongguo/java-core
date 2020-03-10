package com.hongguo.java8.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Test1
 *
 * @author chenghongguo
 * @date 2020/2/18
 * @since 1.0.0
 */
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
                String name = Thread.currentThread().getName();
                System.out.println("name === " + name);
            }
        });
        list.forEach(i -> System.out.println(i * 2));

        MyInterface myInterface = () -> {
            System.out.println("hello");
        };

        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}

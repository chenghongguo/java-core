package com.hongguo.java8.consumer;

import org.junit.Test;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * ConsumerTest
 *
 * @author: chenghongguo
 * @date: 2019-07-15
 * @since 1.0.0
 */
public class ConsumerTest {

    @Test
    public void test() {
        Consumer<Integer> consumer = t -> System.out.println(t);

        IntConsumer intConsumer = t -> System.out.println(t);

        consumer(consumer);
        consumer(consumer::accept);

        // Cannot resolve method 'println(<method reference>)'
//        System.out.println(intConsumer::accept);
        consumer(intConsumer::accept);
        consumer(System.out::println);
//        consumer(intConsumer);
    }

    private void consumer(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

    @Test
    public void test2() {
        Optional<String> optional = Optional.ofNullable("hongguo");
        optional.ifPresent(System.out::println);
    }
}

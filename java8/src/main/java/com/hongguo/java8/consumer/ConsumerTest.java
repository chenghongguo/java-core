package com.hongguo.java8.consumer;

import java.util.function.BiConsumer;

/**
 * ConsumerTest
 *
 * @author: chenghongguo
 * @date: 2019-07-15
 * @since 1.0.0
 */
public class ConsumerTest {

    public void test(BiConsumer<String, String> consumer) {
        consumer.accept("a", "b");
    }
}

package com.hongguo.java8.function;

import org.junit.Test;

/**
 * @author: chenghongguo
 * @date: 2019-02-21
 * @description:
 */
public class FunctionalInterfaceTest {

    @Test
    public void test1() {
        boolean a = has(s -> s.contains("四"), "赵四");
        System.out.println(a);
    }

    private boolean has(MyPredicate<String> predicate, String str) {
        return predicate.test(str);
    }

    @Test
    public void test2() {
        accept(s -> System.out.println(s), "hongguo");
    }

    private void accept(MyConsumer<String> consumer, String msg) {
        consumer.accept(msg);
    }

    @Test
    public void test3() {
        Integer apply = apply(l -> l.intValue(), 1000L);
        System.out.println(apply);
    }

    private Integer apply(MyFunction<Long, Integer> function, Long age) {
        return function.apply(age);
    }

    @Test
    public void test4() {
        String s = get(() -> "hongguo");
        System.out.println(s);
    }

    private String get(MySupplier<String> supplier) {
        return supplier.get();
    }
}

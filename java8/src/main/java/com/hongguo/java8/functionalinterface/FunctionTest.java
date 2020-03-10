package com.hongguo.java8.functionalinterface;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * FunctionTest
 *
 * @author chenghongguo
 * @date 2020/2/19
 * @since 1.0.0
 */
public class FunctionTest {

    @Test
    public void test() {
        List<Object> list = Arrays.asList(new Object[]{new Object(), null});
        long count = list.stream().filter(Objects::nonNull).count();
        System.out.println(count);
    }

    @Test
    public void testIdentity() {
        Function<Integer, Integer> function = Function.identity();
        Assert.assertEquals(Integer.valueOf(100), function.apply(100));
        Assert.assertEquals(Integer.valueOf(10), function.apply(10));
    }

    @Test
    public void testAndThen() {
        Function<Integer, Integer> after = value -> value + 5;
        Function<Integer, Integer> function = value -> value * 5;
        int result = function.andThen(after).andThen(after).apply(2);
        Assert.assertEquals(20, result);
    }

    @Test
    public void testCompose() {
        Function<Integer, Integer> before = value -> value + 5;
        Function<Integer, Integer> function = value -> value * 5;
        int result = function.compose(before).compose(before).apply(2);
        Assert.assertEquals(60, result);
    }

    @Test
    public void testApply() {
        int result = compute(2, value -> value * 2);
        Assert.assertEquals(4, result);

        result = compute(3, value -> value * value);
        Assert.assertEquals(9, result);

        result = compute(5, value -> value + 5);
        Assert.assertEquals(10, result);
    }

    private int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }
}

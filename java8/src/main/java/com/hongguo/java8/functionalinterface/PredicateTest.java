package com.hongguo.java8.functionalinterface;

import org.junit.Test;

import java.util.function.Predicate;

/**
 * PredicateTest
 *
 * @author chenghongguo
 * @date 2020/2/20
 * @since 1.0.0
 */
public class PredicateTest {

    @Test
    public void test() {
        Predicate<String> predicate = s -> s.length() > 5;
        boolean result = predicate.test("123467");
        System.out.println(result);
    }

    @Test
    public void testAnd() {
        Predicate<String> predicate = s -> s.length() > 5;
        boolean result = predicate.test("123467");
        System.out.println(result);
        System.out.println("-------------------");
        Predicate<String> predicate1 = s -> s.length() > 10;
        boolean test = predicate.and(predicate1).test("123467");
        System.out.println(test);
    }

    @Test
    public void testOr() {
        Predicate<String> predicate = s -> s.length() > 5;
        boolean result = predicate.test("123467");
        System.out.println(result);
        System.out.println("-------------------");
        Predicate<String> predicate1 = s -> s.length() > 10;
        boolean test = predicate.or(predicate1).test("123467");
        System.out.println(test);
    }

    @Test
    public void testNegate() {
        Predicate<String> predicate = s -> s.length() > 5;
        System.out.println(predicate.test("123"));
        Predicate<String> negate = predicate.negate();
        System.out.println(negate.test("123"));
    }

    @Test
    public void testIsEqual() {
        Predicate<Object> equal = Predicate.isEqual("123");
        System.out.println(equal.test("1235"));
    }
}

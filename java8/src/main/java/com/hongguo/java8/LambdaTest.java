package com.hongguo.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: chenghongguo
 * @date: 2019-01-29
 * @description:
 */
public class LambdaTest {

    @Test
    public void testThread() {
        new Thread(() -> System.out.println("test")).start();
    }

    @Test
    public void testMessage() {
        GreetingService service = System.out::println;
        service.sayMessage("test");
    }

    @Test
    public void testConsumer() {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");

        f.andThen(f2).accept("test");
        f.andThen(f).andThen(f).andThen(f).accept("test11");
    }

    @Test
    public void testFunction() {
        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 2;

        System.out.println(f.compose(g).apply(2));
        System.out.println(f.andThen(g).apply(2));

        System.out.println(Function.identity().apply("abc"));
    }

    @Test
    public void testPredicate() {
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> g = o -> o.startsWith("f");

        Assert.assertFalse(p.negate().test("ss"));

        Assert.assertTrue(p.and(g).test("test"));

        Assert.assertTrue(p.or(g).test("ts"));
    }

    @Test
    public void testStream() {
        List<String> list = Arrays.asList("a", "b", "c");
        Stream stream = list.stream();
        Stream parallelListStream = list.parallelStream();
        System.out.println(stream);
        System.out.println(parallelListStream);
        Stream<String> a = Stream.of("a", "b");
        System.out.println(a.count());
    }

    @Test
    public void testFilter() {
        Stream<String> s = Stream.of("test", "t2", "3t", "food");
        s.filter(n -> n.contains("t")).forEach(System.out::println);
    }

    @Test
    public void testStreamInit() {
        Stream stream = Stream.iterate(0, i -> i + 2).limit(5);
        Stream stream1 = Stream.generate(() -> Math.random() * 100).limit(10);
        BaseStream baseStream = Stream.concat(stream, stream1).parallel();
        Iterator iterator = baseStream.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testStreamClose() {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 2).limit(5);
        Stream stream1 = Stream.generate(() -> Math.random() * 100).limit(10);
        BaseStream baseStream = Stream.concat(stream, stream1).onClose(() -> System.out.println("close"));
        baseStream.close();
    }

    @Test
    public void testStreamMapToInt() {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 2).limit(5);
        stream.mapToInt(i -> i * 2).forEach(System.out::println);
    }

    @Test
    public void testStreamMap() {
        List<String> list = Arrays.asList("Hello", "World");
        list.stream().map(word -> word.split("")).distinct().collect(Collectors.toList())
                .forEach(System.out::print);
    }

    @Test
    public void testStreamFlatMap() {
        List<String> list = Arrays.asList("Hello", "World");
        list.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList())
                .forEach(System.out::print);
    }

    @Test
    public void testOptional() throws Throwable {
        Optional o = Optional.ofNullable("test");
        System.out.println(o.orElse("hello"));
        System.out.println(o.orElseThrow(() -> new Exception("exception")));
    }

    @Test
    public void test() {
        mapFun(new HashMap<>());
    }

    private void mapFun(Map<String, Integer> map) {
        System.out.println(map);
    }

    private static String stringOp(StringFun fun, String s) {
        return fun.fun(s);
    }

    @Test
    public void testStrReverse() {
        String inStr = "lambdas add power to Java";
        String outStr = stringOp(MyStringOps::strReverse, inStr);
        System.out.println("Original string:" + inStr);
        System.out.println("String reversed: " + outStr);
    }

    @Test
    public void testReverse() {
        String inStr = "lambdas add power to Java";
        MyStringOps ops = new MyStringOps();
        String outStr = stringOp(ops::reverse, inStr);
        System.out.println("Original string:" + inStr);
        System.out.println("String reversed: " + outStr);
    }

    static <T> int myOp(MyFun<T> f, T[] values, T v) {
        return f.func(values, v);
    }

    @Test
    public void testMyArray() {
        Integer[] values = {1, 2, 3, 4, 2, 3, 4, 4, 5};
        String[] strs = {"One", "Two", "Three", "Two"};

        int count = myOp(MyArrayOps::countMatching, values, 4);
        System.out.println(count);

        count = myOp(MyArrayOps::countMatching, strs, "Two");
        System.out.println(count);
    }
}

package com.hongguo.java8.spliterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * SpliteratorTest
 *
 * @author chenghongguo
 * @date 2020/3/13
 * @since 1.0.0
 */
public class SpliteratorTest {

    @Test
    public void test3() {
        Consumer<Integer> consumer = t -> System.out.println(t);

        IntConsumer intConsumer = t -> System.out.println(t);

        consumer(consumer);
        consumer(consumer::accept);

        consumer(intConsumer::accept);

    }

    private void consumer(Consumer<Integer> consumer) {
        consumer.accept(100);
    }

    @Test
    public void test2() {
        List<Integer> list = Arrays.asList(1, 2, -3, -4, 5);

        System.out.println("Contents of list: ");
        Spliterator<Integer> spliterator = list.spliterator();
        while (spliterator.tryAdvance(System.out::println)) ;

        List<Integer> list2 = new ArrayList<>();
        spliterator = list.spliterator();
        while (spliterator.tryAdvance((n) -> list2.add(Math.abs(n)))) ;

        System.out.println("Absolute values of contents of arraylist: ");
        spliterator = list2.spliterator();
        while (spliterator.tryAdvance(System.out::println)) ;
    }

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, -3, -4, 5);
        Stream<Integer> stream = list.stream();
        Spliterator<Integer> spliterator = stream.spliterator();
        System.out.println("size = " + spliterator.estimateSize());
        System.out.println("exact size = " + spliterator.getExactSizeIfKnown());
        System.out.println(spliterator.characteristics());

        spliterator.forEachRemaining(System.out::println);

        Stream<Integer> stream1 = list.stream();
        spliterator = stream1.spliterator();

        Spliterator<Integer> spliterator2 = spliterator.trySplit();
        if (spliterator2 != null) {
            System.out.println("output from split2");
            spliterator2.forEachRemaining(System.out::println);
        }
        System.out.println("output from split");
        spliterator.forEachRemaining(System.out::println);
    }
}

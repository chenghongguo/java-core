package com.hongguo.java8.stream;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * ParallelStreamTest
 *
 * @author chenghongguo
 * @date 2020/3/9
 * @since 1.0.0
 */
public class ParallelStreamTest {

    @Test
    public void test4() {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, 10_000_000L).parallel().forEach(accumulator::add);
        System.out.println(accumulator.total);
    }

    @Test
    public void test3() {
        long l = measureSum(i ->
                LongStream.rangeClosed(1, i).parallel().reduce(0L, Long::sum), 10_000_000);
        System.out.println(l);
    }

    @Test
    public void test2() {
        long l = measureSum(i ->
                LongStream.rangeClosed(1, i).reduce(0L, Long::sum), 10_000_000);
        System.out.println(l);
    }

    private long measureSum(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.println("result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    @Test
    public void test1() {
        Long sum = Stream.iterate(1L, i -> i + 1)
                .limit(10)
                .parallel()
                .reduce(0L, Long::sum);
        System.out.println(sum);
    }

    @Test
    public void test() {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}

class Accumulator {
    public AtomicLong total = new AtomicLong(0);

    public void add(long value) {
        total.addAndGet(value);
    }
}
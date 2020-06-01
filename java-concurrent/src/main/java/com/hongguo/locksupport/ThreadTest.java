package com.hongguo.locksupport;

/**
 * ThreadTest
 *
 * @author chenghongguo
 * @date 2020/5/16
 * @since 1.0.0
 */
public class ThreadTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ", " + Thread.interrupted());
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ", " + Thread.interrupted());
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + ", " + Thread.interrupted());
        }, "t1");

        t1.start();
    }
}

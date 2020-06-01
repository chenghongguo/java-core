package com.hongguo.java.base.threads;

import java.util.concurrent.TimeUnit;

/**
 * DeadLockTest
 *
 * @author chenghongguo
 * @date 2020/4/21
 * @since 1.0.0
 */
public class DeadLockTest {

    private static String A = "A";

    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockTest().deadLock();
    }

    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}

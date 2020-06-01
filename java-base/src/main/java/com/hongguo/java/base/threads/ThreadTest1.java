package com.hongguo.java.base.threads;

import java.util.concurrent.TimeUnit;

/**
 * ThreadTest1
 *
 * @author chenghongguo
 * @date 2020/4/18
 * @since 1.0.0
 */
public class ThreadTest1 {

    private boolean running = true;

    public static void main(String[] args) throws Exception {
        ThreadTest1 t = new ThreadTest1();
        Thread t1 = new Thread(() -> {
            System.out.println("start");
            while (t.running) {

            }
            System.out.println("end");
        });

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            t.running = false;
        });

        t1.start();
//        t2.start();

        t1.join();
//        t2.join();
    }
}

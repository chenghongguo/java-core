package com.hongguo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReenterLock
 *
 * @author chenghongguo
 * @date 2019/12/9
 * @since 1.0.0
 */
public class ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReenterLock r1 = new ReenterLock();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}

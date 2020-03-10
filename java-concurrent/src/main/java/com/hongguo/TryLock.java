package com.hongguo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * IntLock
 *
 * @author chenghongguo
 * @date 2019/12/9
 * @since 1.0.0
 */
public class TryLock implements Runnable {
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                while (true) {
                    if (lock1.tryLock()) {
                        try {
                            Thread.sleep(500);
                            if (lock2.tryLock()) {
                                try {
                                    System.out.println("lock1: finish job");
                                    return;
                                } finally {
                                    lock2.unlock();
                                }
                            }
                        } finally {
                            lock1.unlock();
                        }
                    }
                }
            } else {
                while (true) {
                    if (lock2.tryLock()) {
                        try {
                            Thread.sleep(500);
                            if (lock1.tryLock()) {
                                try {
                                    System.out.println("lock2: finish job");
                                    return;
                                } finally {
                                    lock1.unlock();
                                }
                            }
                        } finally {
                            lock2.unlock();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        TryLock r1 = new TryLock(1);
        TryLock r2 = new TryLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}

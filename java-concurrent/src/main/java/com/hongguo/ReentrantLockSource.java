package com.hongguo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLockSource
 *
 * @author chenghongguo
 * @date 2020/5/16
 * @since 1.0.0
 */
public class ReentrantLockSource {
    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock(true);

        startT1(lock);
        TimeUnit.MILLISECONDS.sleep(200);

        startT2(lock);
        TimeUnit.MILLISECONDS.sleep(200);

//        startT3(lock);
    }

    private static void startT1(ReentrantLock lock) {
        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.DAYS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();
    }

    private static void startT2(ReentrantLock lock) {
        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.HOURS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }

    private static void startT3(ReentrantLock lock) {
        new Thread(() -> {
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t3").start();
    }
}

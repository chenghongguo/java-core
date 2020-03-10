package com.hongguo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * IntLock
 *
 * @author chenghongguo
 * @date 2019/12/9
 * @since 1.0.0
 */
public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getId() + " ok");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getId() + " get lock failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        TimeLock r1 = new TimeLock();
        TimeLock r2 = new TimeLock();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}

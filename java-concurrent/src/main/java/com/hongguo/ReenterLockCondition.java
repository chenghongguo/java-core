package com.hongguo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReenterLockCondition
 *
 * @author chenghongguo
 * @date 2019/12/10
 * @since 1.0.0
 */
public class ReenterLockCondition implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("Thread is going on.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        ReenterLockCondition r1 = new ReenterLockCondition();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }
}

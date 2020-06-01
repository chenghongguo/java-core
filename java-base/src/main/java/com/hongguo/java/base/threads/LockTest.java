package com.hongguo.java.base.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * LockTest
 *
 * @author chenghongguo
 * @date 2020/4/23
 * @since 1.0.0
 */
public class LockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition read = lock.newCondition();
        Condition write = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    System.out.println("A11");
                    read.await();
                    System.out.println("A22");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            write.signal();
        }).start();

        new Thread(() -> {
            lock.lock();
            try {
                while (true) {
                    System.out.println("B11");
                    write.await();
                    System.out.println("B22");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            read.signal();
        }).start();

    }
}

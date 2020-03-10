package com.hongguo;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLockDemo
 *
 * @author chenghongguo
 * @date 2019/12/13
 * @since 1.0.0
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws Exception {
        try {
            lock.lock();
            Thread.sleep(1000);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws Exception {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRun = () -> {
            try {
//                demo.handleRead(readLock);
                demo.handleRead(lock);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable writeRun = () -> {
            try {
//                demo.handleWrite(writeLock, new Random().nextInt());
                demo.handleWrite(lock, new Random().nextInt());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        for (int i = 0; i  < 18; i++) {
            new Thread(readRun).start();
        }
        for (int i = 18; i < 20; i++) {
            new Thread(writeRun).start();
        }
    }
}

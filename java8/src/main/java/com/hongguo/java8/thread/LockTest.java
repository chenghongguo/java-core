package com.hongguo.java8.thread;

/**
 * @author: chenghongguo
 * @date: 2019-02-27
 * @description:
 */
public class LockTest {

    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        new Thread(() -> {
            int sum = demo.getSum();
            System.out.println(Thread.currentThread().getName() + ", " + sum);
        }, "A").start();

        new Thread(() -> {
            demo.setSum(100);
            System.out.println(Thread.currentThread().getName() + ", " + demo.getSum());
        }, "B").start();
    }
}

class ThreadDemo {
    private int sum = 0;

    public synchronized int getSum() {
        return sum;
    }

    public synchronized void setSum(int sum) {
        this.sum = sum;
    }
}

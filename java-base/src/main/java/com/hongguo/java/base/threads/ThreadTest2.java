package com.hongguo.java.base.threads;

/**
 * ThreadTest2
 *
 * @author chenghongguo
 * @date 2020/4/29
 * @since 1.0.0
 */
public class ThreadTest2 {

    public static void main(String[] args) throws Exception {
        T t = new T();
        Thread t1 = new Thread(() -> {
            t.m1();
        }, "t1");

        Thread t2 = new Thread(() -> {
            T.m2();
        }, "t2");

        Thread t3 = new Thread(() -> {
            t.m1();
        }, "t3");

        t2.start();
        t2.join();

        t1.start();
        t1.join();

        t3.start();
        t3.join();

        System.out.println("done");
    }

}

class T {

    private static int count = 0;

    public void m1() {
        System.out.println("m1 start");
        synchronized (this) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ", count=" + count++);
        }
    }

    public static void m2() {
        System.out.println("m2 start");
        synchronized (T.class) {
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ", count=" + count++);
        }
    }
}

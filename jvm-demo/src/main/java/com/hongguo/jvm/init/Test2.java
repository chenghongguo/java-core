package com.hongguo.jvm.init;

/**
 * Test2
 *
 * @author chenghongguo
 * @date 2019/10/24
 * @since 1.0.0
 */
public class Test2 {
    static {
        if (true) {
            System.out.println(Thread.currentThread() + "init class");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "start");
                Test2 test2 = new Test2();
                System.out.println(Thread.currentThread() + "end");
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        t1.start();
        t2.start();
    }
}

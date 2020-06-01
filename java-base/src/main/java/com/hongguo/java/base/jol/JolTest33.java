package com.hongguo.java.base.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁，两个线程交替执行，查看对象头信息
 *
 * @author chenghongguo
 * @date 2020/5/28
 */
public class JolTest33 {

    public static void main(String[] args) throws Exception {
        // JVM 开启偏向锁延迟时间默认为4s，如果没有手动睡眠，则会直接进入到轻量级锁
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println(Thread.currentThread().getName() + ", " + ClassLayout.parseInstance(o).toPrintable());
        new Thread(() -> {
            synchronized (o) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ", " + ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();

        Thread.sleep(1000);
        new Thread(() -> {
            synchronized (o) {
                System.out.println(Thread.currentThread().getName() + ", " + ClassLayout.parseInstance(o).toPrintable());
            }
        }).start();
    }
}

package com.hongguo.java.base.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * 偏向锁
 *
 * @author chenghongguo
 * @date 2020/5/28
 */
public class JolTest3 {

    public static void main(String[] args) throws Exception {
        // JVM 开启偏向锁延迟时间默认为4s，如果没有手动睡眠，则会直接进入到轻量级锁
        Thread.sleep(5000);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}

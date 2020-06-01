package com.hongguo.java.base.jol;

import org.openjdk.jol.info.ClassLayout;

import java.util.stream.IntStream;

/**
 * 轻量级锁
 *
 * @author chenghongguo
 * @date 2020/5/28
 */
public class JolTest4 {

    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        Object o = new Object();
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }

        IntStream.range(0, 4).forEach(i -> new Thread(() -> {
            synchronized (o) {
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
            }
        }).start());
    }
}

package com.hongguo.mianshiti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * T03_NotifyHoldingLock
 *
 * @author chenghongguo
 * @date 2020/5/17
 * @since 1.0.0
 */
public class T03_NotifyHoldingLock {

    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T03_NotifyHoldingLock t = new T03_NotifyHoldingLock();
        final Object o = new Object();

        // 先启动t2，再启动t1
        new Thread(() -> {
            System.out.println("t2 start");
            synchronized (o) {
                if (t.size() != 5) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2 end");
                o.notify();
            }
        }, "t2").start();

        new Thread(() -> {
            System.out.println("t1 start");
            synchronized (o) {
                for (int i = 0; i < 10; i++) {
                    t.add(new Object());
                    System.out.println("add " + i);
                    if (t.size() == 5) {
                        o.notify();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();
    }

}

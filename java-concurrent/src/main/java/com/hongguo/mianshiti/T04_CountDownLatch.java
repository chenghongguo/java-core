package com.hongguo.mianshiti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * T04_CountDownLatch
 *
 * @author chenghongguo
 * @date 2020/5/17
 * @since 1.0.0
 */
public class T04_CountDownLatch {

    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T04_CountDownLatch t = new T04_CountDownLatch();
        CountDownLatch latch = new CountDownLatch(1);

        new Thread(() -> {
            System.out.println("t2 start");
            if (t.size() != 5) {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2 end");
        }, "t2").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("t1 add " + i);
                if (t.size() == 5) {
                    latch.countDown();
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
            System.out.println("t1 end");
        }, "t1").start();
    }
}

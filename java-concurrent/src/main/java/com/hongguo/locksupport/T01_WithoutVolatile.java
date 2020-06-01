package com.hongguo.locksupport;

import java.util.ArrayList;
import java.util.List;

/**
 * T01_WithoutVolatile
 *
 * @author chenghongguo
 * @date 2020/5/16
 * @since 1.0.0
 */
public class T01_WithoutVolatile {
    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T01_WithoutVolatile c = new T01_WithoutVolatile();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                c.add(new Object());
                System.out.println("add " + i);
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }, "t1").start();


        new Thread(() -> {
            while (true) {
                if (c.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 end");
        }, "t2").start();
    }
}

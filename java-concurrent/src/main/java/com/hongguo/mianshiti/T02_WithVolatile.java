package com.hongguo.mianshiti;

import java.util.ArrayList;
import java.util.List;

/**
 * T01_WithoutVolatile
 *
 * @author chenghongguo
 * @date 2020/5/17
 * @since 1.0.0
 */
public class T02_WithVolatile {

    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        T02_WithVolatile t = new T02_WithVolatile();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add " + i);
            }
        }, "t1").start();

        new Thread(() -> {
            while (true) {
                if (t.size() == 5) {
                    break;
                }
            }
            System.out.println("t2 end");
        }, "t2").start();
    }

}

package com.hongguo.mianshiti;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * T04_LockSupport
 *
 * @author chenghongguo
 * @date 2020/5/17
 * @since 1.0.0
 */
public class T04_LockSupport {

    volatile List<Object> list = new ArrayList<>();

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }


    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        T04_LockSupport t = new T04_LockSupport();
        t2 = new Thread(() -> {
            System.out.println("t2 start");
            if (t.size() != 5) {
                LockSupport.park();
            }
            System.out.println("t2 end");
            LockSupport.unpark(t1);
        }, "t2");

        t1 = new Thread(() -> {
            System.out.println("t1 start");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("t1 add " + i);
                if (t.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
            System.out.println("t1 end");
        }, "t1");

        t1.start();
        t2.start();
    }
}

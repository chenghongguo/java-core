package com.hongguo.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupportTest2
 *
 * @author chenghongguo
 * @date 2020/5/16
 * @since 1.0.0
 */
public class LockSupportTest2 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if ( i == 5) {
                    LockSupport.park();
                }

                if (i == 8) {
                    LockSupport.park();
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();
        LockSupport.unpark(t);
    }
}

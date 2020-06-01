package com.hongguo.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupportTest
 *
 * @author chenghongguo
 * @date 2020/5/16
 * @since 1.0.0
 */
public class LockSupportTest {

    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            System.out.println("before park");
            LockSupport.park();
            boolean interrupted = Thread.interrupted();
            System.out.println(interrupted);
        });

        t.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(t);
    }
}

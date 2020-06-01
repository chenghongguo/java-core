package com.hongguo;

import java.util.concurrent.TimeUnit;

/**
 * InterruptedTest
 *
 * @author chenghongguo
 * @date 2020/5/10
 * @since 1.0.0
 */
public class InterruptedTest {

    public static void main(String[] args) throws Exception {
        Thread sleepThread = new Thread(new SleepRunner(), "SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(), "BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);
        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("SleepThread interrupted is : " + sleepThread.isInterrupted());
        System.out.println("BusyThread interrupted is : " + busyThread.isInterrupted());

        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
}

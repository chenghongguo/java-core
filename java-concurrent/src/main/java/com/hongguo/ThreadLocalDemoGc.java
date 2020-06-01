package com.hongguo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocalDemoGc
 *
 * @author chenghongguo
 * @date 2020/4/25
 * @since 1.0.0
 */
public class ThreadLocalDemoGc {

    static volatile ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected void finalize() throws Throwable {
            System.out.println(this.toString() + " is gc");
        }
    };

    static volatile CountDownLatch cd = new CountDownLatch(10000);

    public static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if (tl.get() == null) {
                    tl.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") {
                        @Override
                        protected void finalize() throws Throwable {
                            System.out.println(this.toString() + " is gc");
                        }
                    });
                    System.out.println(Thread.currentThread().getId() + ":create SimpleDateFormat");
                }

                Date d = tl.get().parse("2019-01-01 12:12:" + i % 60);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                cd.countDown();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10000; i++) {
            service.execute(new ParseDate(i));
        }

        cd.await();
        System.out.println("mission conplete!");
        tl = null;
        System.gc();
        System.out.println("first GC complete!!");

        tl = new ThreadLocal<>();
        cd = new CountDownLatch(10000);

        for (int i = 0; i < 10000; i++) {
            service.execute(new ParseDate(i));
        }

        cd.await();
        Thread.sleep(1000);
        System.gc();
        System.out.println("second GC complete");
        tl.remove();
    }
}

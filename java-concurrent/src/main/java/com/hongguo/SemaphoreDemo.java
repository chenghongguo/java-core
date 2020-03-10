package com.hongguo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreDemo
 *
 * @author chenghongguo
 * @date 2019/12/10
 * @since 1.0.0
 */
public class SemaphoreDemo implements Runnable {

    final Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId() + ": done");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; i++) {
            service.execute(demo);
        }
        service.shutdown();
    }
}

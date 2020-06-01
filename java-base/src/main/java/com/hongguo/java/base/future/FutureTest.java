package com.hongguo.java.base.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * FutureTest
 *
 * @author chenghongguo
 * @date 2020/5/30
 */
public class FutureTest {

    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            System.out.println("pre exe");
            Thread.sleep(2000);
            Integer result = new Random().nextInt(100);
            System.out.println("post exe");
            return result;
        };

        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        System.out.println("main exe");
        try {
            System.out.println(futureTask.isDone());
            futureTask.cancel(true);
            Thread.sleep(3000);
            System.out.println(futureTask.isDone());
            System.out.println(futureTask.get(1, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

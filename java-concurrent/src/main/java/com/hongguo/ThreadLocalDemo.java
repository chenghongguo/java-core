package com.hongguo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocalDemo
 *
 * @author chenghongguo
 * @date 2020/4/25
 * @since 1.0.0
 */
public class ThreadLocalDemo {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new ParseDate(i));
        }
    }

    private static class ParseDate implements Runnable {
        int i = 0;

        public ParseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Date t = sdf.parse("2015-03-29 19:29:" + i % 60);
                System.out.println(i + ":" + t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

package com.hongguo.java.base.jvm;

import com.google.common.collect.Lists;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * OomTest
 *
 * @author chenghongguo
 * @date 2020/4/22
 * @since 1.0.0
 */
public class OomTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        int m = 1024 * 1024 * 4;
        String name = "oom-thread";
        new Thread(() -> {
            List<byte[]> bytes = Lists.newArrayList();

            while (true) {
                show(format(formatter));
                bytes.add(new byte[m]);
                sleep();
            }
        }, name).start();

        name = "not-oom-thread";
        new Thread(() -> {
            while (true) {
                show(format(formatter));
                sleep();
            }
        }, name).start();
    }

    private static void show(String msg) {
        System.out.println(msg);
    }

    private static String format(DateTimeFormatter formatter) {
        return String.format("data: {%s}, thread:{%s}", LocalDateTime.now().format(formatter), Thread.currentThread().getName());
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.hongguo;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo
 *
 * @author chenghongguo
 * @date 2020/1/9
 * @since 1.0.0
 */
public class CyclicBarrierDemo {

    public static class Soldier implements Runnable {

        private String soldier;

        private final CyclicBarrier cyclicBarrier;

        public Soldier(String soldier, CyclicBarrier cyclicBarrier) {
            this.soldier = soldier;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
                doWork();
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":任务完成");
        }
    }

    public static class BarrierRun implements Runnable {

        boolean flag;

        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵" + N + "个，完成任务]");
            } else {
                System.out.println("司令：[士兵" + N + "个，集合完毕]");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍！");
        for (int i = 0; i < 10; i++) {
            System.out.println("士兵 " + i + " 报道！");
            allSoldier[i] = new Thread(new Soldier("士兵" + i, cyclicBarrier));
            allSoldier[i].start();
        }
    }
}

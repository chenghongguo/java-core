package com.hongguo.shengsiyuan;

/**
 * WaitNotifyTest
 *
 * @author chenghongguo
 * @date 2020/5/21
 */
public class WaitNotifyTest {

    public static void main(String[] args) {
        MyObject lock = new MyObject();

        Thread in = new IncreseThread(lock);
        Thread in2 = new IncreseThread(lock);
        Thread de = new DecreseThread(lock);
        Thread de2 = new DecreseThread(lock);

        in.start();
        in2.start();
        de.start();
        de2.start();
    }
}

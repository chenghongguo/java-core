package com.hongguo.shengsiyuan;

/**
 * MyObject
 *
 * @author chenghongguo
 * @date 2020/5/21
 */
public class MyObject {
    private int counter;

    public synchronized void increse() {
        while (counter > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        System.out.println("counter = " + counter);
        notifyAll();
    }

    public synchronized void decrese() {
        while (counter == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        System.out.println("counter = " + counter);
        notifyAll();
    }
}

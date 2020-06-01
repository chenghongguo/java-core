package com.hongguo.shengsiyuan;

/**
 * IncreseThread
 *
 * @author chenghongguo
 * @date 2020/5/21
 */
public class IncreseThread extends Thread {
    private MyObject myObject;

    public IncreseThread(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            myObject.increse();
        }
    }
}

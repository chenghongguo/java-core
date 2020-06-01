package com.hongguo.shengsiyuan;

/**
 * IncreseThread
 *
 * @author chenghongguo
 * @date 2020/5/21
 */
public class DecreseThread extends Thread {
    private MyObject myObject;

    public DecreseThread(MyObject myObject) {
        this.myObject = myObject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 30; i++) {
            myObject.decrese();
        }
    }
}

package com.hongguo.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Test7
 *
 * @author chenghongguo
 * @date 2019/11/18
 * @since 1.0.0
 */
public class Test7 {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }
}

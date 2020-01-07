package com.hongguo.jvm.classloader;

import java.util.ArrayList;
import java.util.List;

/**
 * Test7
 *
 * @author chenghongguo
 * @date 2019/10/11
 * @since 1.0.0
 */
public class Test7 {

    public void testHeap() {
        List<Object> list = new ArrayList<>();
        for (;;) {
            list.add(new Object());
        }
    }

    int num = 1;
    public void testStack() {
        num++;
        this.testStack();
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        // test7.testHeap();
        test7.testStack();
    }
}

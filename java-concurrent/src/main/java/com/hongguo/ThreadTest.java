package com.hongguo;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * ThreadTest
 *
 * @author chenghongguo
 * @date 2020/4/29
 * @since 1.0.0
 */
public class ThreadTest {
    static int i;

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);

        for (ThreadInfo info : threadInfos) {
            System.out.println(info.getThreadId() + ", " + info.getThreadName());
        }
    }
}

class Base {
    private void a(int i) {
        System.out.println("Base.a");
    }
}

class Over extends Base {
    public void a(int i) {
        System.out.println("Over.a");
    }
}
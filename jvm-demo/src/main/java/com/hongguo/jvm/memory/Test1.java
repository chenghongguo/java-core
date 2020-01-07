package com.hongguo.jvm.memory;

/**
 * 触发OOM异常
 * -Xmx：堆最大值
 * -Xms：堆最小值
 * -XX:+HeapDumpOnOutOfMemoryError：内存溢出Error堆转储
 *
 * @author chenghongguo
 * @date 2019/11/6
 * @since 1.0.0
 */
public class Test1 {
    public static void main(String[] args) {
        while (true) {

        }
    }
}

package com.hongguo.java.base.lock;

/**
 * synchronized指令： monitorenter monitorexit
 * <p>
 * java反编译命令语法： javap <options> <classes>
 * -c：代码反汇编
 * -v -verbose：输出附加信息
 *
 * @author chenghongguo
 * @date 2020/5/28
 */
public class LockTest1 {
    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o) {
            System.out.println("hello");
        }
    }

    public String method() {
        return "hello";
    }

    public static String method2() {
        return "hello";
    }
}

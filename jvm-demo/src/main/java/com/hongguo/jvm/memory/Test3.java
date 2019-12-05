package com.hongguo.jvm.memory;

/**
 * DeadLock：死锁
 *
 * @author chenghongguo
 * @date 2019/11/6
 * @since 1.0.0
 */
public class Test3 {

    public static void main(String[] args) {
        new Thread(A::method, "Thread-A").start();
        new Thread(B::method, "Thread-B").start();
    }
}

class A {
    public static synchronized void method() {
        System.out.println("from method A");
        try {
            Thread.sleep(3000);
            B.method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class B {
    public static synchronized void method() {
        System.out.println("from method B");
        try {
            Thread.sleep(3000);
            A.method();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
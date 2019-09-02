package com.hongguo.java.base;

/**
 * PrivateOverride
 *
 * @author chenghongguo
 * @date 2019/8/27
 * @since 1.0.0
 */
public class PrivateOverride {
    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride privateOverride = new Derived();
        privateOverride.f();
    }
}

class Derived extends PrivateOverride {
    public void f() {
        System.out.println("public f()");
    }
}
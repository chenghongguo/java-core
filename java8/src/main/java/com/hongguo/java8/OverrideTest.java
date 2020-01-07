package com.hongguo.java8;

/**
 * OverrideTest
 *
 * @author chenghongguo
 * @date 2019/7/26
 * @since 1.0.0
 */
public class OverrideTest {

    private void f() {
        System.out.println("private f()");
    }

    public static void main(String[] args) {
        OverrideTest privateOverride = new Derived();
        privateOverride.f();

        Derived derived = new Derived();
        derived.f();
    }
}

class Derived extends OverrideTest {
    public void f() {
        System.out.println("public f()");
    }
}
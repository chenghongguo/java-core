package com.hongguo.jvm.bytecode;

/**
 * Test1
 *
 * @author chenghongguo
 * @date 2019/10/28
 * @since 1.0.0
 */
public class Test1 {

    private void test(GrandPa grandPa) {
        System.out.println("grandpa");
    }

    private void test(Father father) {
        System.out.println("father");
    }

    private void test(Son son) {
        System.out.println("son");
    }

    public static void main(String[] args) {
        GrandPa g1 = new Father();
        GrandPa g2 = new Son();

        Test1 test1 = new Test1();
        test1.test(g1);
        test1.test(g2);
    }
}

class GrandPa {

}

class Father extends GrandPa {
}

class Son extends Father {
}
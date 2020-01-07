package com.hongguo.jvm.memory;

/**
 * StackOverflowError：栈溢出
 *
 * @author chenghongguo
 * @date 2019/11/6
 * @since 1.0.0
 */
public class Test2 {

    private void test() {
        test();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test();
    }
}

package com.hongguo.java8;

import java.io.IOException;

/**
 * ExceptionsTest
 *
 * @author chenghongguo
 * @date 2019/7/30
 * @since 1.0.0
 */
public class ExceptionsTest {
}

abstract class AbstractClass {

    abstract void test1() throws IOException;

    abstract void test2() throws RuntimeException;

    abstract void test3() ;
}

class ClassTest extends AbstractClass {
    @Override
    void test1() throws IOException {

    }

    @Override
    void test2() {

    }

    @Override
    void test3(){

    }
}

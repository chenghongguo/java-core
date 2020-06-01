package com.hongguo.java8.function;

import org.openjdk.jol.info.ClassLayout;

import java.util.function.Function;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
public class FooTest {

    private String value = "Enclosing scope value";

    public static void main(String[] args) {
        Function<Integer, Integer> function = i -> i * 2;
        System.out.println(function.getClass());
        String s = ClassLayout.parseInstance(function.getClass()).toPrintable();
        System.out.println(s);
        System.out.println("-----------------");

        A a = new A();
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    static class A {

    }

    public String scope() {
        value = "";
        Foo fooIc = new Foo() {
            private String value = "Inner class value";

            @Override
            public String method(String string) {
                return this.value;
            }
        };
        String resultIc = fooIc.method("");
        String v = "test";
        Foo fooLambda = parameter -> {
            value = "Lambda value";
            return value;
        };
        String resultLambda = fooLambda.method("");
        return "Results: resultIc = " + resultIc + ", resultLambda = " + resultLambda;
    }
}

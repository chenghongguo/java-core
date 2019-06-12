package com.hongguo.java8.function;

/**
 * @author: chenghongguo
 * @date: 2019-06-05
 * @description:
 */
public class FooTest {

    private String value = "Enclosing scope value";

    public static void main(String[] args) {
        FooTest test = new FooTest();
        System.out.println(test.scope());
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

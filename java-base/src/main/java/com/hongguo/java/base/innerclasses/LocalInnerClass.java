package com.hongguo.java.base.innerclasses;

/**
 * LocalInnerClass
 *
 * @author chenghongguo
 * @date 2020/4/10
 * @since 1.0.0
 */
public class LocalInnerClass {
    private int count = 0;

    Counter getCounter(final String name) {
        class LocalCounter implements Counter {
            LocalCounter() {
                System.out.print("LocalCounter");
            }

            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        }
        return new LocalCounter();
    }

    Counter getCounter2(final String name) {
        {
            System.out.print("Counter()");
        }
        return new Counter() {
            @Override
            public int next() {
                System.out.print(name);
                return count++;
            }
        };
    }

    public static void main(String[] args) {
        LocalInnerClass localInnerClass = new LocalInnerClass();
        Counter c1 = localInnerClass.getCounter("Local Inner");
        Counter c2 = localInnerClass.getCounter2("Anonymous Inner");

        for (int i = 0; i < 5; i++) {
            System.out.println(c1.next());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(c2.next());
        }
    }
}

interface Counter {
    int next();
}

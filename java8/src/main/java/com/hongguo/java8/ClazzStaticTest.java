package com.hongguo.java8;

import java.util.Random;

/**
 * ClazzStaticTest
 *
 * @author chenghongguo
 * @date 2019/7/31
 * @since 1.0.0
 */
public class ClazzStaticTest {

    public static Random random = new Random(47);

    public static void main(String[] args) throws Exception {
        Class initable = Initable.class;
        System.out.println("After creating ref");

        System.out.println(Initable.final1);
        System.out.println(Initable.final2);
        System.out.println(Initable2.noFinal);

        Class init3 = Class.forName("com.hongguo.java8.Initable3");
        System.out.println(Initable3.noFinal);


        Class<?> intclass = int.class;
        System.out.println(intclass);
        intclass = double.class;
        System.out.println(intclass);
    }
}

class Initable {
    static final int final1 = 47;
    static final int final2 = new Random().nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int noFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int noFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}
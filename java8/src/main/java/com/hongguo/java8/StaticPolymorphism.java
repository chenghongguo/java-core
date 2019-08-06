package com.hongguo.java8;

/**
 * StaticPolymorphism
 *
 * @author chenghongguo
 * @date 2019/7/26
 * @since 1.0.0
 */
public class StaticPolymorphism {

    public static void main(String[] args) {
        StaticSuper sup = new StaticSub();
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());

        System.out.println(StaticSuper.staticGet());
        System.out.println(StaticSub.staticGet());
    }
}

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

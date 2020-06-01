package com.hongguo.java.base.extend;

/**
 * Sub
 *
 * @author chenghongguo
 * @date 2020/4/3
 * @since 1.0.0
 */
public class Sub extends Parent {

    public Sub() {
        super("hongguo", 30);
    }

    public Sub(String name, Integer age) {
        super(name, age);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.setAge(10);
        sub.setName("hongguo");
        System.out.println(sub);
        System.out.println(sub.getAge());
        System.out.println(sub.getName());
    }
}

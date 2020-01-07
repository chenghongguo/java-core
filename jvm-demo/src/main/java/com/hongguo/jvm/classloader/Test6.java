package com.hongguo.jvm.classloader;

/**
 * Test6
 *
 * @author chenghongguo
 * @date 2019/10/11
 * @since 1.0.0
 */
public class Test6 {

    public static void main(String[] args) {
        Parent6[] a = new Parent6[2];
        System.out.println(a.getClass().getClassLoader());
    }
}

class Parent6 {

}

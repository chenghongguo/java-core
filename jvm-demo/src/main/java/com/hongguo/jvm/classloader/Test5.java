package com.hongguo.jvm.classloader;

/**
 * Test5
 *
 * @author chenghongguo
 * @date 2019/10/11
 * @since 1.0.0
 */
public class Test5 {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        while (null != classLoader) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}

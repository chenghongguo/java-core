package com.hongguo.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * Test9
 *
 * @author chenghongguo
 * @date 2019/11/2
 * @since 1.0.0
 */
public class Test9 {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (null == is) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = classLoader.loadClass("com.hongguo.jvm.classloader.Test9").newInstance();
        System.out.println(obj.getClass().getClassLoader());
        System.out.println(Test9.class.getClassLoader());
        System.out.println(obj instanceof com.hongguo.jvm.classloader.Test9);
    }
}

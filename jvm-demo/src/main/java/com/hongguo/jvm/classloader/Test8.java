package com.hongguo.jvm.classloader;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Test8
 * 自定义ClassLoader
 * @author chenghongguo
 * @date 2019/10/12
 * @since 1.0.0
 */
public class Test8 extends ClassLoader {

    private String fileExtension = ".class";

    public Test8() {

    }

    public Test8(ClassLoader classLoader) {
        super(classLoader);
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        BufferedInputStream bufferedInputStream = null;

        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(className + fileExtension)));
            int len = bufferedInputStream.available();
            byte[] result = new byte[len];
            bufferedInputStream.read(result, 0, len);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        Test8 test8 = new Test8();
        Class<?> clazz = test8.loadClass("com.hongguo.jvm.classloader.Test5");
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object instanceof Test5);
    }


}

package com.hongguo.java8;

/**
 * ClassLoaderTest
 *
 * @author chenghongguo
 * @date 2019/7/31
 * @since 1.0.0
 */
public class ClassLoaderTest {

    static void printInfo(Class clazz) {
        System.out.println("Class name: " + clazz.getName() + ", is Interface?[" + clazz.isInterface() + "]");
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Canonical name: " + clazz.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;

        try {
            c = Class.forName("com.hongguo.java8.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }

        printInfo(c);

        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        System.out.println("**************************");
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Can't instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
        printInfo(obj.getClass().getSuperclass());

        System.out.println("-----------------------------");
        System.out.println(boolean.class.getName() + ", " + boolean.class.getCanonicalName() + ", " + boolean.class.getSimpleName());
        System.out.println(String.class.getName() + ", " + String.class.getCanonicalName() + ", " + String.class.getSimpleName());
        System.out.println(int.class.getName() + ", " + int.class.getCanonicalName() + ", " + int.class.getSimpleName());
        System.out.println(int[].class.getName() + ", " + int[].class.getCanonicalName() + ", " + int[].class.getSimpleName());
        System.out.println(FancyToy.class.getName() + ", " + FancyToy.class.getCanonicalName() + ", " + FancyToy.class.getSimpleName());
        System.out.println("+++++++++========================");
        System.out.println(Integer.TYPE + ", " + void.class + ", " + Void.TYPE);
    }
}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    Toy() {
    }

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
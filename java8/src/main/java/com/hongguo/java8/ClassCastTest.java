package com.hongguo.java8;

import org.junit.Test;

import java.util.*;

/**
 * ClassCastTest
 *
 * @author chenghongguo
 * @date 2019/7/31
 * @since 1.0.0
 */
public class ClassCastTest {

    @Test
    public void test1() {
        Class c1 = new ArrayList<Integer>().getClass();
        Class c2 = new ArrayList<String>().getClass();
        System.out.println(c1 == c2);
    }

    @Test
    public void test2() {
        List<Frob> list = new ArrayList<>();

        Map<Frob, Fnorkle> map = new HashMap<>();

        Quark<Fnorkle> quark = new Quark<>();

        Particle<Long, Double> p = new Particle<>();

        System.out.println(Arrays.asList(list.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(map.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.asList(p.getClass().getTypeParameters()));
    }

    public static void main(String[] args) {
        Building b = new Hourse();
        Class<Hourse> hourseClass = Hourse.class;
        Hourse h = hourseClass.cast(b);
        System.out.println(h);

        Hourse hourse = new Hourse();
        System.out.println(hourse);
        Class<Building> buildingClass = Building.class;
        Building building = buildingClass.cast(hourse);
        System.out.println(building);

        Class<? extends Hourse> aClass = buildingClass.asSubclass(Hourse.class);
        System.out.println(aClass);
    }
}

class Building {
}

class Hourse extends Building {
}

class Frob {
}

class Fnorkle {
}

class Quark<Q> {
}

class Particle<POSITION, MOMENTUM> {
}
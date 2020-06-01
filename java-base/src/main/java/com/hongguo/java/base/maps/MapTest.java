package com.hongguo.java.base.maps;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MapTest
 * Hashtable: key&value 均不能为null
 * HashMap: key&value 均可为null
 * ConcurrentHashMap: key&value 均不能null
 * TreeMap: key不能为null，value能为null
 *
 * @author chenghongguo
 * @date 2020/4/23
 * @since 1.0.0
 */
public class MapTest {

    @Test
    public void test7() {
        Map<String, Object> map = new HashMap<>();
        map.put("methodType", 0);

        System.out.println(map.get("methodType") == new Integer(0));

        System.out.println(Objects.equals(map.get("methodType"), 0));
    }

    @Test
    public void test5() {
        int a = 1;
        Integer b = 2;
        int c = 0;

        Boolean flag = false;

        Integer result = (flag ? a : c);
        System.out.println(result);
    }

    @Test
    public void test6() {
        f();
    }

    private int f() {
        Integer i = null;
        return i;
    }

    @Test
    public void test4() {
        Map<String, Object> map = new TreeMap<>();
//        map.put(null, null);
        map.put("hello", null);
        map.put("world", "world");
//        map.put(null, "world");
        System.out.println(map);
    }

    @Test
    public void test3() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put(null, null);
        System.out.println(map);
    }

    @Test
    public void test2() {
        Map<String, Object> map = new HashMap<>();
        map.put(null, null);
        map.put("hello", null);
        map.put(null, "world");
        System.out.println(map);
    }

    @Test
    public void test1() {
        Map<String, Object> map = new Hashtable<>();
        map.put(null, null);
        map.put("hello", null);
        System.out.println(map);
    }
}

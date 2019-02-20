package com.hongguo.java.dynamic;

import com.hongguo.java.dynamic.core.DynamicProxy;
import com.hongguo.java.dynamic.core.RealSubject;
import com.hongguo.java.dynamic.core.Subject;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2018-12-21
 * @description:
 */
public class DynamicTest {

    @Test
    public void testProxy() {
        Subject subject = new RealSubject();
        InvocationHandler handler = new DynamicProxy(subject);

        Subject proxyInstance = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        System.out.println(proxyInstance.getClass().getName());
        proxyInstance.hello("hello");
        proxyInstance.send("message");
    }

    @Test
    public void testEquals() {
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    @Test
    public void testArrayList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        List<String> strings = list.subList(0, 1);
        System.out.println(strings);

        String[] str = new String[]{"you", "wu"};
        List list1 = Arrays.asList(str);
        str[0] = "guanjin";

        System.out.println(str[0]);
    }

    @Test
    public void testMap() {
        Map<String, String> map = new HashMap<>(16);
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("d", "dd");

        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " =  " + map.get(key));
        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        map.forEach((k, v) -> {
            System.out.println(k + ", " + v);
        });
    }

    @Test
    public void testStreamMap() {
        List<String> list = Arrays.asList("123", "45634", "7892", "abch", "sdfhrthj", "mvkd");
        List<String> result = list.stream().map(s -> {
            if (s.length() > 5) {
                return s;
            }
            s = s + "abcdd";
            return s;
        }).collect(Collectors.toList());
        System.out.println(result);
    }
}

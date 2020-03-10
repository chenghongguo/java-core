package com.hongguo.java.base;

import org.junit.Test;

import java.util.*;

/**
 * CollectionsTest
 *
 * @author chenghongguo
 * @date 2019/8/12
 * @since 1.0.0
 */
public class CollectionsTest {

    @Test
    public void test2() {
        List<String> list = Arrays.asList("hello", "world", "nihao", "ceshia");
        list.sort(Comparator.comparingInt(String::length).thenComparing(String.CASE_INSENSITIVE_ORDER));
        System.out.println(list);
    }

    @Test
    public void test() {
        List<String> list = Arrays.asList("hello", "world");
        String[] strings = list.toArray(new String[0]);
        for (String str : strings) {
            System.out.println(str);
        }
    }

    @Test
    public void testToArray() {
        List<String> list = Arrays.asList("hello", "world");
        Object[] objects = list.toArray();
        for (Object obj : objects) {
            System.out.println(obj);
        }
    }

    @Test
    public void testFrequency() {
        List<String> b = Arrays.asList("1", "2", "3", "3");
        int frequency = Collections.frequency(b, "3");
        System.out.println(frequency);
    }

    @Test
    public void testEnumeration() {
        // 集合转枚举
        List<String> b = Arrays.asList("1", "2", "3");
        Enumeration<String> enumeration = Collections.enumeration(b);
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }

    @Test
    public void testDisjoint() {
        // 两个集合没有相同元素，则返回true
        List<String> a = Arrays.asList("hello", "world");
        List<String> b = Arrays.asList("1", "2", "3");
        boolean disjoint = Collections.disjoint(a, b);
        System.out.println(disjoint);
    }

    @Test
    public void testCopy() {
        List<String> a = Arrays.asList("hello", "world");
        List<String> b = Arrays.asList("1", "2", "3");
        Collections.copy(b, a);
        System.out.println(b);
    }

    @Test
    public void testCheckedCollection() {
        Collection<String> strings = Collections.checkedCollection(new ArrayList<>(), String.class);
        strings.add("abc");
        System.out.println(strings.getClass());
        List<Integer> list = Collections.checkedList(new ArrayList<>(), Integer.class);
        list.add(112);
        System.out.println(list.getClass());
    }

    @Test
    public void testBinarySearch() {
        List<String> list = Arrays.asList("hell", "world", "hello", "worldd");
        int hello = Collections.binarySearch(list, "world");
        System.out.println(hello);

        int hello1 = Collections.binarySearch(list, "hello", Comparator.comparingInt(String::length));
        System.out.println(hello1);
    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<>(Collections.nCopies(2, "hello"));
        System.out.println(list);

        Collections.fill(list, "world!");
        System.out.println(list);
    }
}

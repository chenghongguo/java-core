package com.hongguo.java8.core;

import org.junit.Test;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author: chenghongguo
 * @date: 2019-02-27
 * @description:
 */
public class ObjectsTest {

    @Test
    public void test1() {
        boolean isNull = Objects.isNull(null);
        System.out.println(isNull);

        int compare = Objects.compare(10, 20, Comparator.naturalOrder());
        System.out.println(compare);
    }
}

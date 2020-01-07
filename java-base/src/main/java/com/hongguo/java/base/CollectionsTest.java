package com.hongguo.java.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CollectionsTest
 *
 * @author chenghongguo
 * @date 2019/8/12
 * @since 1.0.0
 */
public class CollectionsTest {

    @Test
    public void test1() {
        List<String> list = new ArrayList<>(Collections.nCopies(5, "hello"));
        System.out.println(list);

        Collections.fill(list, "world!");
        System.out.println(list);
    }
}

package com.hongguo.java.base;

import java.util.ArrayList;
import java.util.List;

/**
 * GenericTypesTest
 *
 * @author chenghongguo
 * @date 2019/12/6
 * @since 1.0.0
 */
public class GenericTypesTest {

//    public static String method(List<String> list) {
//        System.out.println("invoke method(List<String> list)");
//        return "";
//    }

    public static int method(List<Integer> list) {
        System.out.println("invoke method(List<Integer> list)");
        return 1;
    }

    public static void main(String[] args) {
//        method(new ArrayList<String>());
        method(new ArrayList<Integer>());
    }
}

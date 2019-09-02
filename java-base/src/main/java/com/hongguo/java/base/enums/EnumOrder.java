package com.hongguo.java.base.enums;

/**
 * EnumOrder
 *
 * @author chenghongguo
 * @date 2019/8/21
 * @since 1.0.0
 */
public class EnumOrder {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", name " + s.name() + ", ordinal " + s.ordinal());
        }
    }
}

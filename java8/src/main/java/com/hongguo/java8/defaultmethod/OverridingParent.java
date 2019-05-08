package com.hongguo.java8.defaultmethod;

/**
 * @author: chenghongguo
 * @date: 2019-05-07
 * @description:
 */
public class OverridingParent extends ParentImpl {

    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }
}

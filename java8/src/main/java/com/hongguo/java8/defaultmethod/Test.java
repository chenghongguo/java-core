package com.hongguo.java8.defaultmethod;

import org.junit.Assert;

/**
 * @author: chenghongguo
 * @date: 2019-05-07
 * @description:
 */
public class Test {

    @org.junit.Test
    public void test4() {
        Child child = new OverridingChild();
        child.welcome();
        Assert.assertEquals("Class Parent: Hi!", child.getLastMessage());
    }

    @org.junit.Test
    public void test3() {
        Parent parent = new OverridingParent();
        parent.welcome();
        Assert.assertEquals("Class Parent: Hi!", parent.getLastMessage());
    }

    @org.junit.Test
    public void test1() {
        Parent parent = new ParentImpl();
        parent.welcome();
        Assert.assertEquals("Parent: Hi!", parent.getLastMessage());
    }

    @org.junit.Test
    public void test2() {
        Child child = new ChildImpl();
        child.welcome();
        Assert.assertEquals("Child: Hi!", child.getLastMessage());
    }
}

package com.hongguo.java.base.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * 对象头
 *
 * @author chenghongguo
 * @date 2020/5/28
 */
public class JolTest2 {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(VM.current().details());
        System.out.println(ClassLayout.parseInstance(o).instanceSize());
        System.out.println("o.hashCode = " + o.hashCode());
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }
}

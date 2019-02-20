package com.hongguo.java.dynamic.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: chenghongguo
 * @date: 2018-12-21
 * @description:
 */
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before send message");

        System.out.println("method: " + method);
        method.invoke(object, args);

        System.out.println("after send message");
        return null;
    }
}

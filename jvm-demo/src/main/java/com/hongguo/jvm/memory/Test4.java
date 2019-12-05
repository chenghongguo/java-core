package com.hongguo.jvm.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Test4
 *
 * @author chenghongguo
 * @date 2019/11/7
 * @since 1.0.0
 */
public class Test4 {
    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Test4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) -> proxy.invokeSuper(obj, args1));
            System.out.println("hello");
            enhancer.create();
        }
    }
}

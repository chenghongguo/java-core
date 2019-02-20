package com.hongguo.java.dynamic;

import com.hongguo.java.dynamic.cglib.SampleClass;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author: chenghongguo
 * @date: 2018-12-21
 * @description:
 */
public class CglibTest {

    @Test
    public void testCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method run ..");
                Object object = methodProxy.invokeSuper(o, objects);
                System.out.println("after method run...");
                return object;
            }
        });

        SampleClass sampleClass = (SampleClass) enhancer.create();
        sampleClass.test();
    }
}

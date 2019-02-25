package com.hongguo.java8.defaultmethod;

import java.util.Collections;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class OrderServiceImpl implements OrderService {
    @Override
    public List<Object> getList() {
        return Collections.emptyList();
    }

    @Override
    public Object get() {
        return new Object();
    }
}

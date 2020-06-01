package com.hongguo.java.base.bean;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * Processors
 *
 * @author chenghongguo
 * @date 2020/5/22
 */
public class Processors {

    private List<Long> beforeProcessors;

    private List<Long> afterProcessors;

    public List<Long> getBeforeProcessors() {
        return beforeProcessors;
    }

    public void setBeforeProcessors(List<Long> beforeProcessors) {
        this.beforeProcessors = beforeProcessors;
    }

    public List<Long> getAfterProcessors() {
        return afterProcessors;
    }

    public void setAfterProcessors(List<Long> afterProcessors) {
        this.afterProcessors = afterProcessors;
    }

    public static void main(String[] args) {
        Processors p = new Processors();
        p.setBeforeProcessors(Arrays.asList(27L, 29L));
        p.setAfterProcessors(Arrays.asList(27L, 29L));

        T t = new T();
        t.setProcessors(p);
        System.out.println(JSONObject.toJSONString(t));
    }
}

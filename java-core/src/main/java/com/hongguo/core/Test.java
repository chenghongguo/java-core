package com.hongguo.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * Test
 *
 * @author chenghongguo
 * @date 2020/5/12
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {

        String json = "{\"whiteList\":[\"test\",\"test2\"],\"blackList\":[\"test\",\"test4\"]}";
        JSONObject jsonObject = JSONObject.parseObject(json);

        JSONArray whiteList = jsonObject.getJSONArray("whiteList");
        Arrays.asList(whiteList).forEach(System.out::println);

        System.out.println("----------");

        JSONArray blackList = jsonObject.getJSONArray("blackList");
        Arrays.asList(blackList).forEach(System.out::println);
    }
}

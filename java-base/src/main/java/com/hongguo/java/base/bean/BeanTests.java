package com.hongguo.java.base.bean;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * BeanTests
 *
 * @author chenghongguo
 * @date 2019/12/14
 * @since 1.0.0
 */
public class BeanTests {

    @Test
    public void test1() throws Exception {
        List<PersonDTO> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            PersonDTO dto = new PersonDTO();
            dto.setId((long) i);
            dto.setName("test-" + i);
            dto.setAge(i + 10);
            list.add(dto);
        }
        list.forEach(System.out::println);
        System.out.println("========");
        List<PersonPO> poList = new ArrayList<>();
        BeanUtils.copyProperties(list, poList);
        poList.forEach(System.out::println);
    }

    @Test
    public void testJson() {
        boolean abc = JSONObject.isValid("{}");
        System.out.println(abc);
        JSONObject jsonObject = JSONObject.parseObject("{}");
        if (jsonObject == null) {
            System.out.println("======");
            return;
        }
        jsonObject.entrySet().forEach(entry -> System.out.println(entry.getKey() + ", " + entry.getValue()));
    }

    @Test
    public void testNull () {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", null);
        System.out.println(jsonObject.toJSONString());
    }
}

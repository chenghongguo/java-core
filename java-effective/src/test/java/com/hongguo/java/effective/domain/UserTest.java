package com.hongguo.java.effective.domain;

import org.junit.Test;

/**
 * @author: chenghongguo
 * @date: 2019-02-20
 * @description:
 */
public class UserTest {

    @Test
    public void test1() {
        User user = User.builder().id(1).name("hongguo").age(30).email("hongguo@jd.com").address("邯郸")
                .phone("123").build();
        System.out.println(user);
    }
}

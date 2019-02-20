package com.hongguo.java.effective.domain;

import lombok.Builder;
import lombok.Data;

/**
 * @author: chenghongguo
 * @date: 2019-02-20
 * @description:
 */
@Data
@Builder
public class User {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String phone;
    private String address;
}

package com.hongguo.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: chenghongguo
 * @date: 2019-02-18
 * @description:
 */
@Data
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private Integer gender;
    private String deptName;
    private Double salary;
    private Status status;
}

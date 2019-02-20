package com.hongguo.java.effective.domain;

import org.junit.Test;

/**
 * @author: chenghongguo
 * @date: 2019-02-20
 * @description:
 */
public class EmployeeTest {

    @Test
    public void test1() {
        Employee employee = new Employee.Builder(1, "hongguo").deptId(12).deptName("研发部").salary(1000.00)
                .gender(1).builder();
        System.out.println(employee);
    }
}

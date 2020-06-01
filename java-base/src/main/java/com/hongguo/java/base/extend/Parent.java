package com.hongguo.java.base.extend;

/**
 * Parent
 *
 * @author chenghongguo
 * @date 2020/4/3
 * @since 1.0.0
 */
public class Parent {

    private String name;

    private Integer age;

    public Parent(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

package com.hongguo.java.base.bean;

/**
 * PersonPO
 *
 * @author chenghongguo
 * @date 2019/12/14
 * @since 1.0.0
 */
public class PersonPO {

    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

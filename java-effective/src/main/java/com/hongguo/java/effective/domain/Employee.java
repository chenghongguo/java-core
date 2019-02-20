package com.hongguo.java.effective.domain;

/**
 * @author: chenghongguo
 * @date: 2019-02-20
 * @description:
 */
public class Employee {
    private Integer id;
    private String name;
    private Double salary;
    private Integer gender;
    private Integer deptId;
    private String deptName;

    public static class Builder {

        private Integer id;
        private String name;
        private Double salary;
        private Integer gender;
        private Integer deptId;
        private String deptName;

        public Builder(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder salary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Builder gender(Integer gender) {
            this.gender = gender;
            return this;
        }

        public Builder deptId(Integer deptId) {
            this.deptId = deptId;
            return this;
        }

        public Builder deptName(String deptName) {
            this.deptName = deptName;
            return this;
        }

        public Employee builder() {
            return new Employee(this);
        }
    }

    private Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.gender = builder.gender;
        this.salary = builder.salary;
        this.deptId = builder.deptId;
        this.deptName = builder.deptName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", gender=" + gender +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }
}

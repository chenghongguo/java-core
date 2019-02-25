package com.hongguo.java8.optional;

import java.util.Optional;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class Person {
    private Optional<Car> car;

    public void setCar(Optional<Car> car) {
        this.car = car;
    }

    public Optional<Car> getCar() {
        return this.car;
    }
}

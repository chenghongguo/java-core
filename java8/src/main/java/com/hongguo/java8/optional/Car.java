package com.hongguo.java8.optional;

import java.util.Optional;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class Car {
    private Optional<Insurance> insurance;

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }

    public Optional<Insurance> getInsurance() {
        return this.insurance;
    }
}

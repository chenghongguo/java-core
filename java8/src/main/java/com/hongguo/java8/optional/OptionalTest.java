package com.hongguo.java8.optional;

import org.junit.Test;

import java.util.Optional;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class OptionalTest {

    @Test
    public void test1() {
        Insurance insurance = new Insurance();
        insurance.setName("hongguo");
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> s = optionalInsurance.map(Insurance::getName);
        if (s.isPresent()) {
            System.out.println(s.get());
        } else {
            System.out.println("null");
        }
        Car car = new Car();
        car.setInsurance(optionalInsurance);
        Optional<Car> carOptional = Optional.of(car);
        Person person = new Person();
        person.setCar(carOptional);
        System.out.println(person);

        Optional<Person> personOptional = Optional.of(person);

        Optional<String> s1 = personOptional.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName);
        System.out.println(s1.get());
    }
}

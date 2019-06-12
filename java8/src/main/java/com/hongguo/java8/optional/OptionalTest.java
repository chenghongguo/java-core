package com.hongguo.java8.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class OptionalTest {

    @Test(expected = NoSuchElementException.class)
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null);
        opt.get();
    }

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> ops = Optional.of("hongguo");
        String name = ops.get();
        Assert.assertEquals(name, "hongguo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenOrElseThrowWorks_thenCorrect() {
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
    }

    private String getDefaultValue() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        String defaultValue = Optional.ofNullable(text).orElseGet(this::getDefaultValue);
        Assert.assertEquals("Text present", defaultValue);

        System.out.println("Using orElse:");
        defaultValue = Optional.ofNullable(text).orElse(getDefaultValue());
        Assert.assertEquals("Text present", defaultValue);
    }

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;
        String defaultValue = Optional.ofNullable(text).orElseGet(this::getDefaultValue);
        Assert.assertEquals("Default Value", defaultValue);

        defaultValue = Optional.ofNullable(text).orElse(getDefaultValue());
        Assert.assertEquals("Default Value", defaultValue);
    }

    @Test
    public void whenOrElseGet_thenCorrect() {
        String s = null;
        String name = Optional.ofNullable(s).orElseGet(() -> "hongguo");
        Assert.assertEquals(name, "hongguo");
    }

    @Test
    public void whenOrElseWorks_thenCorrect() {
        String s = null;
        String name = Optional.ofNullable(s).orElse("hongguo");
        Assert.assertEquals(name, "hongguo");
    }

    @Test
    public void givenNotNull_filter_thenCorrect() {
        List<String> names = Arrays.asList("tom", "jerry", "dog");
        Optional<List<String>> optional = Optional.ofNullable(names);
        optional.filter(name -> name.size() > 1).ifPresent(System.out::println);
    }

    @Test
    public void givenNull_whenCreatedNullable_thenCorrect() {
        String name = null;
        Optional<String> optional = Optional.ofNullable(name);
        Assert.assertFalse(optional.isPresent());
    }

    @Test
    public void givenNotNull_whenCreatedNullable_thenCorrect() {
        String name = "hongguo";
        Optional<String> optional = Optional.ofNullable(name);
        Assert.assertTrue(optional.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void givenNull_whenThrowsErrorOnCreate_thenCorrect() {
        String name = null;
        Optional.of(name);
    }

    @Test
    public void givenNotNull_whenCreatedNotNullable_thenCorrect() {
        String name = "hongguo";
        Optional<String> optional = Optional.of(name);
        Assert.assertTrue(optional.isPresent());
    }

    @Test
    public void testCreateEmptyOptional() {
        Optional<String> empty = Optional.empty();
        Assert.assertFalse(empty.isPresent());
    }

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

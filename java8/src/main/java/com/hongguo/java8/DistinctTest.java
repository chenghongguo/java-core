package com.hongguo.java8;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

/**
 * DistinctTest
 *
 * @author chenghongguo
 * @date 2020/4/18
 * @since 1.0.0
 */
public class DistinctTest {

    private List<Follow> follows;

    @Before
    public void before() {
        follows = Arrays.asList(
                new Follow("Prodck", "1556", 2),
                new Follow("JD#Ads", "1569", 1),
                new Follow("Pesanan", "1557", 1),
                new Follow("商品", "1556", 1),
                new Follow("Homepage", "1595", 1)
        );
    }

    @Test
    public void test() {
        LongStream longStream = follows.stream().mapToLong(follow -> Long.valueOf(follow.getId())).distinct();
        longStream.forEach(System.out::println);
    }

    @Test
    public void test2() {
        Map<String, Integer> collect = follows.stream().collect(Collectors.groupingBy(Follow::getId, Collectors.summingInt(Follow::getCount)));
        System.out.println(collect);
    }
}

class Follow implements Serializable {

    private static final long serialVersionUID = 3752392852358817255L;
    private String name;

    private String id;

    private Integer count;

    public Follow(String name, String id, Integer count) {
        this.name = name;
        this.id = id;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}

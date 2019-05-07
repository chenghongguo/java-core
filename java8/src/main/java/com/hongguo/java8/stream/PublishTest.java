package com.hongguo.java8.stream;

import com.alibaba.fastjson.JSONObject;
import com.hongguo.java8.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2019-04-19
 * @description:
 */
public class PublishTest {

    private List<Publish> publishes;

    @Test
    public void test1() {
        // 加入当前时间为4月17日
        Map<Long, List<Publish>> collect = publishes.stream().collect(Collectors.groupingBy(Publish::getResourceId));
        collect.forEach((k, v) -> {
            Map<Integer, List<Publish>> listMap = v.stream().collect(Collectors.groupingBy(Publish::getPositionNum));
            listMap.forEach((key, value) -> {
                List<Publish> publishes = value.stream().sorted(Comparator.comparing(Publish::getCreated).reversed()).limit(1).collect(Collectors.toList());
                System.out.println(key + ", " + JSONObject.toJSONString(publishes));
            });
        });
    }

    @Before
    public void init() {
        publishes = Arrays.asList(
                Publish.builder().id(1L).resourceId(100L).resourceDetailId(1000L).advertisementId(10000L).positionNum(1)
                        .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 00, 00, 00)))
                        .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 17, 23, 59, 59)))
                        .material("100")
                        .status((byte) 0)
                        .created(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 10, 10, 00, 00)))
                        .modified(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 10, 10, 00, 00)))
                        .build(),
                Publish.builder().id(2L).resourceId(100L).resourceDetailId(1000L).advertisementId(20000L).positionNum(1)
                        .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 16, 00, 00, 00)))
                        .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 18, 23, 59, 59)))
                        .material("200")
                        .status((byte) 0)
                        .created(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 11, 10, 00, 00)))
                        .modified(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 11, 10, 00, 00)))
                        .build(),
                Publish.builder().id(3L).resourceId(100L).resourceDetailId(1000L).advertisementId(30000L).positionNum(1)
                        .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 00, 00, 00)))
                        .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 20, 23, 59, 59)))
                        .material("300")
                        .status((byte) 0)
                        .created(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 10, 00, 00)))
                        .modified(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 10, 00, 00)))
                        .build()
        );
    }
}

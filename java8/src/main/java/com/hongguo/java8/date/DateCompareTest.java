package com.hongguo.java8.date;

import com.hongguo.java8.utils.DateUtils;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2019-05-06
 * @description:
 */
public class DateCompareTest {

    private List<DateObject> list = null;

    @Before
    public void before() {
        list = new ArrayList<>();
        list.add(DateObject.builder()
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 23, 0, 0, 0)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 24, 23, 59, 59)))
                .build());
        list.add(DateObject.builder()
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 20, 0, 0, 0)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 25, 23, 59, 59)))
                .build());
        list.add(DateObject.builder()
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 13, 0, 0, 0)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 27, 23, 59, 59)))
                .build());
        list.add(DateObject.builder()
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 3, 0, 0, 0)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 29, 23, 59, 59)))
                .build());
        list.add(DateObject.builder()
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 24, 0, 0, 0)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, Month.MAY, 31, 23, 59, 59)))
                .build());
    }

    @Test
    public void test3() {
        String message = String.format("查询区间[%s-%s]查询任务数据为空", format(new Date()), format(new Date()));
        System.out.println(message);
    }

    private String format(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    @Test
    public void test2() {
        list.stream().collect(Collectors.minBy(Comparator.comparing(DateObject::getStartTime))).ifPresent(System.out::println);
        list.stream().collect(Collectors.maxBy(Comparator.comparing(DateObject::getEndTime))).ifPresent(System.out::println);
    }

    @Test
    public void test1() {
        Date startTime = DateUtils.getFirstTimeOfDay(new Date());
        Date endTime = DateUtils.getEndTimeOfDay(new Date());
        Date now = new Date();
        System.out.println(now.after(startTime));
        System.out.println(now.before(endTime));
    }
}

package com.hongguo.java8.date;

import com.hongguo.java8.utils.DateUtils;
import org.junit.Test;

import java.util.Date;

/**
 * @author: chenghongguo
 * @date: 2019-05-06
 * @description:
 */
public class DateCompareTest {

    @Test
    public void test1() {
        Date startTime = DateUtils.getFirstTimeOfDay(new Date());
        Date endTime = DateUtils.getEndTimeOfDay(new Date());
        Date now = new Date();
        System.out.println(now.after(startTime));
        System.out.println(now.before(endTime));
    }
}

package com.hongguo.java8.jodatime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Instant;
import org.junit.Test;

/**
 * @author: chenghongguo
 * @date: 2019-06-14
 * @description:
 */
public class JodaTimeTest {
    @Test
    public void testInstantCreate() {
        Instant instant = new Instant();
        int i = instant.get(DateTimeFieldType.dayOfMonth());
        System.out.println(i);
        System.out.println(instant);
    }

    @Test
    public void testDateTimeCreate() {
        DateTime dateTime = new DateTime();
        System.out.println(dateTime);

        System.out.println(dateTime.getDayOfMonth());
        System.out.println(dateTime.getMonthOfYear());

        System.out.println(dateTime.toString());
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime.getZone().getID());

        DateTime dateTime1 = dateTime.plusWeeks(1);
        System.out.println(dateTime1);

        System.out.println(dateTime.centuryOfEra().getField().getMaximumValue());
    }
}

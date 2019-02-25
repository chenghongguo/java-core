package com.hongguo.java8.date;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * @author: chenghongguo
 * @date: 2019-02-25
 * @description:
 */
public class TemporalAdjusterTest {

    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        System.out.println("now:" + localDate);
        LocalDate dayOfSunday = localDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println("next sunday:" + dayOfSunday);
        LocalDate nextMonday = localDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("nextMonday:" + nextMonday.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)));
        LocalDate with = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        System.out.println(with);
    }

    @Test
    public void test2() {
        LocalDate localDate = LocalDate.now();
        LocalDate with = localDate.with(temporal -> {
            DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dayOfWeek == DayOfWeek.FRIDAY) {
                dayToAdd = 3;
            } else if (dayOfWeek == DayOfWeek.SATURDAY) {
                dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println(with);
    }

    @Test
    public void test3() {
        LocalDate now = LocalDate.now();
        LocalDate with = now.with(TemporalAdjusters.firstDayOfNextMonth());
        System.out.println(with);
        LocalDate dayOfNextYear = now.with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(dayOfNextYear);
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDayOfMonth);
    }
}

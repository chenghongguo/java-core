package com.hongguo.java8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2019-01-16
 * @description:
 */
public class DateTimeTest {

    public static void main(String[] args) throws Exception {
        String string = "2018-12-24 21:59:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = sdf.parse(string);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        LocalDate salesPeriodDate = LocalDate.now().plusMonths(2L);
        int salesPeriodYear = salesPeriodDate.getYear();
        int salesPeriodMonth = salesPeriodDate.getMonthValue();
        int startTimeYear = calendar.get(Calendar.YEAR);
        int startTimeMonth = calendar.get(Calendar.MONTH) + 1;
        if (startTimeYear == salesPeriodYear) {
            if (startTimeMonth <= salesPeriodMonth) {
                System.out.println("1 in");
            } else {
                System.out.println("1 in out");
            }
        } else if (startTimeYear < salesPeriodYear) {
            System.out.println("2 in");
        } else {
            System.out.println("3 out");
        }
    }

    @Test
    public void test01() {
        Date date = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        Date startTime = Date.from(LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
        Date endTime = Date.from(LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf.format(startTime));
        System.out.println(sdf.format(endTime));
    }

    private LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private Date getTheDayBefore(Date date) {
        LocalDateTime localDateTime = toLocalDateTime(date);
        return Date.from(LocalDateTime.of(localDateTime.plusDays(-1L).toLocalDate(), LocalTime.of(23, 59, 59)).atZone(ZoneId.systemDefault()).toInstant());
    }

    @Test
    public void test() {
        Date before = getTheDayBefore(new Date(1571662799000L));
        Date after = before;
        System.out.println(before);
        System.out.println(after);
        System.out.println(before.getTime());
        System.out.println(after.getTime());
    }

    @Test
    public void test2() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1060; i++) {
            list.add(i);
        }
        int count = list.size() % 500 == 0 ? list.size() / 500 : list.size() / 500 + 1;
        for (int i = 0; i < count; i++) {
            if (i == count - 1) {
                System.out.println(list.subList(i * 500, list.size()));
            } else {
                System.out.println(list.subList(i * 500, (i + 1) * 500));
            }
        }
    }

    @Test
    public void test3() {
        String expireDate;
        String endDate;
        LocalDate today = LocalDate.now();
        expireDate = today.with(TemporalAdjusters.firstDayOfMonth()).minus(1, ChronoUnit.MONTHS).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endDate = today.with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // 不需要count查询
        System.out.println(expireDate);
        System.out.println(endDate);
    }


}

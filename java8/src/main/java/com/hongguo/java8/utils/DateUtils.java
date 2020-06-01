package com.hongguo.java8.utils;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hongguo_cheng
 * @date 2019-02-24
 * @description
 */
public class DateUtils {

    /**
     * 获取date当天的最后时间
     *
     * @param date 日期
     * @return date当天的最后时间
     */
    public static Date getEndTimeOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return Date.from(LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取date当天的开始日期
     *
     * @param date 日期
     * @return date当天的开始日期
     */
    public static Date getFirstTimeOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return Date.from(LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取date所属月份第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        ZonedDateTime zonedDateTime = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIN).with(TemporalAdjusters.firstDayOfMonth()).atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * 获取date所属月份最后一天
     *
     * @param date
     * @return
     */
    public static Date getEndDayOfMonth(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        ZonedDateTime zonedDateTime = LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).with(TemporalAdjusters.lastDayOfMonth()).atZone(ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    /**
     * LocalDateTime 转 Date
     *
     * @param localDateTime
     * @return
     */
    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalDate 转 Date
     *
     * @param localDate
     * @return
     */
    public static Date convertLocalDateToDate(LocalDate localDate) {
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = localDate.atStartOfDay().atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    /**
     * LocalDate&LocalTime 转 Date
     *
     * @param localDate
     * @param localTime
     * @return
     */
    public static Date convertLocalTimeToDate(LocalDate localDate, LocalTime localTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        Instant instant = localDateTime.atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    /**
     * Date 转 LocalDateTime
     *
     * @param date
     * @return
     */
    public static LocalDateTime convertToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    /**
     * Date 转 LocalDate
     *
     * @param date
     * @return
     */
    public static LocalDate convertToLocalDate(Date date) {
        return convertToLocalDateTime(date).toLocalDate();
    }

    /**
     * Date 转 LocalTime
     *
     * @param date
     * @return
     */
    public static LocalTime convertToLocalTime(Date date) {
        return convertToLocalDateTime(date).toLocalTime();
    }

    /**
     * 获取两个日期之间所有日期集合
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<LocalDate> getDatesBetween(Date startDate, Date endDate) {
        LocalDate localStartDate = convertToLocalDate(startDate);
        LocalDate localEndDate = convertToLocalDate(endDate);
        long numOfDaysBetween = ChronoUnit.DAYS.between(localStartDate, localEndDate) + 1;
        return IntStream.iterate(0, i -> i + 1).limit(numOfDaysBetween).mapToObj(i -> localStartDate.plusDays(i)).collect(Collectors.toList());
    }

    /**
     * date加上days后的日期
     *
     * @param date
     * @return date加上days后的日期
     */
    public static Date plusDays(Date date, int days) {
        LocalDate localDate = convertToLocalDate(date);
        return convertLocalDateToDate(localDate.plusDays(days));
    }

    public static void main(String[] args) {
        System.out.println(getStartDate(0));
        LocalDateTime now = LocalDateTime.of(LocalDate.now().minusDays(7), LocalTime.MIN);
        System.out.println(now);
        now = LocalDateTime.of(LocalDate.now().minusMonths(1), LocalTime.MIN);
        System.out.println(now);
        now = LocalDateTime.of(LocalDate.now().minusMonths(3), LocalTime.MIN);
        System.out.println(now);

        long time = convertLocalDateTimeToDate(now).getTime();
        System.out.println(time);

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = now.atZone(zone).toInstant();
        System.out.println(instant.toEpochMilli());


        // 只保留3个月的数据
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -3);
        long expired = c.getTime().getTime();
        System.out.println(c.getTime());
        System.out.println(expired);
        now = LocalDateTime.of(LocalDate.now().minusMonths(3), LocalTime.MIN);
    }

    /**
     * 根据课程类型获取浏览历史记录
     *
     * @param timeSlot 0: 全部视频，不做时间判断
     *                 1: 1周内
     *                 2: 1个月内
     *                 3：3个月内
     * @return 时间戳
     */
    private static long getStartDate(int timeSlot) {
        long date = 0L;
        Calendar c = Calendar.getInstance();
        switch (timeSlot) {
            case 0:
                break;
            case 1:
                date = getDateBefore(c.getTime(), Calendar.DAY_OF_WEEK).getTime();
                break;
            case 2:
                c.add(Calendar.MONTH, -1);
                date = c.getTime().getTime();
                break;
            case 3:
                c.add(Calendar.MONTH, -3);
                date = c.getTime().getTime();
                break;
            default:
                date = 0L;
                break;
        }
        return date;
    }

    /**
     * 获取一指定天数之前的时间
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
        return calendar.getTime();
    }
}

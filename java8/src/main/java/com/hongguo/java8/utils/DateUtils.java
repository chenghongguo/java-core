package com.hongguo.java8.utils;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
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
}

package com.hongguo.java8.utils;

import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @author hongguo_cheng
 * @date 2019-02-24
 * @description
 */
public class DateUtils {

    /**
     * 获取date当天的最后时间
     *
     * @param date
     * @return
     */
    public static Date getEndTimeOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return Date.from(LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取date当天的开始日期
     *
     * @param date
     * @return
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
}

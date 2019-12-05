package com.hongguo.java8.date;

import com.alibaba.fastjson.JSONObject;
import com.hongguo.java8.utils.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author chenghongguo
 * @date 2019-06-24
 */
public class DateTest {

    @Test
    public void test1() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 时间区间
        DateObject open = new DateObject(format.parse("2019-07-01 00:00:00"), format.parse("2019-07-31 23:59:59"));

        // 时间区间列表合并
        List<DateObject> merge = merge(init());
        System.out.println("时间区间求并集：" + JSONObject.toJSONStringWithDateFormat(merge, "yyyy-MM-dd HH:mm:ss"));
        // 求交集
        List<DateObject> intersection = intersection(open, merge);
        System.out.println("时间区间求交集：" + JSONObject.toJSONStringWithDateFormat(intersection, "yyyy-MM-dd HH:mm:ss"));
        // 求差集
        if (intersection.isEmpty()) {
            System.out.println("该区间不可再选：" + JSONObject.toJSONStringWithDateFormat(open, "yyyy-MM-dd HH:mm:ss"));
            return;
        }
        List<DateObject> list = differences(open, intersection);
        System.out.println("时间区间求差集：" + JSONObject.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 初始化DateObject集合对象
     *
     * @return 集合对象
     * @throws Exception 异常
     */
    private List<DateObject> init() throws Exception {
        List<DateObject> list = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        list.add(new DateObject(format.parse("2019-07-01 00:00:00"), format.parse("2019-07-10 23:59:59")));
        list.add(new DateObject(format.parse("2019-07-15 00:00:00"), format.parse("2019-07-20 23:59:59")));
        list.add(new DateObject(format.parse("2019-07-22 00:00:00"), format.parse("2019-07-25 23:59:59")));
        list.sort(Comparator.comparing(DateObject::getStartDate));
        return list;
    }

    /**
     * 求差集
     *
     * @param dateObject 日期对象
     * @param list       日期列表
     * @return 差集
     */
    private List<DateObject> differences(DateObject dateObject, List<DateObject> list) {
        List<DateObject> result = new ArrayList<>();
        DateObject first = list.get(0);
        if (list.size() == 1) {
            if (dateObject.getStartDate().getTime() < first.getStartDate().getTime()) {
                result.add(new DateObject(dateObject.getStartDate(), DateUtils.getEndTimeOfDay(DateUtils.plusDays(first.getStartDate(), -1))));
            }
            if (dateObject.getEndDate().getTime() - first.getEndDate().getTime() > 1000) {
                result.add(new DateObject(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(first.getEndDate(), 1)), DateUtils.getEndTimeOfDay(dateObject.getEndDate())));
            }
        } else {
            for (int i = 1; i < list.size(); i++) {
                DateObject next = list.get(i);
                result.add(new DateObject(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(first.getEndDate(), 1)), DateUtils.getEndTimeOfDay(DateUtils.plusDays(next.getStartDate(), -1))));
                first = next;
            }
            DateObject last = list.get(list.size() - 1);
            if (dateObject.getEndDate().getTime() > last.getEndDate().getTime()) {
                result.add(new DateObject(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(last.getEndDate(), 1)), DateUtils.getEndTimeOfDay(dateObject.getEndDate())));
            }
        }
        return result;
    }

    /**
     * 求开放时间区间与时间区间的所有交集
     *
     * @param dateObject 日期对象
     * @param list       日期列表
     * @return 日期交集
     */
    private List<DateObject> intersection(DateObject dateObject, List<DateObject> list) {
        List<DateObject> result = new ArrayList<>();
        for (DateObject date : list) {
            // 时间区间全部在开放时间区间内：ad.startDate <= open.startDate < open.endDate <= ad.endDate
            // 则[open.startDate, open.endDate] 均不开放
            if (date.getStartDate().getTime() <= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() >= dateObject.getEndDate().getTime()) {
                // 开放时间区间已全部占用
                break;
            }
            // 时间区间全部在开放时间区间内：open.startDate <= ad.startDate < ad.endDate <= open.endDate
            else if (date.getStartDate().getTime() >= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() <= dateObject.getEndDate().getTime()) {
                result.add(new DateObject(date.getStartDate(), date.getEndDate()));
            }
            // 结束时间在开放时间区间内：ad.startDate <= open.startDate <= ad.endDate <= open.endDate
            else if (date.getStartDate().getTime() <= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() >= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() <= dateObject.getEndDate().getTime()) {
                result.add(new DateObject(dateObject.getStartDate(), date.getEndDate()));
            }
            // 开始时间在开放时间区间内：open.startDate <= ad.startDate <= open.endDate <= ad.endDate
            else if (date.getEndDate().getTime() > dateObject.getEndDate().getTime()) {
                result.add(new DateObject(date.getStartDate(), dateObject.getEndDate()));
            }
        }
        return result;
    }

    /**
     * 时间区间合并
     *
     * @param list 日期集合
     * @return 合并后日期集合
     */
    private List<DateObject> merge(List<DateObject> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }

        List<DateObject> result = new ArrayList<>();
        DateObject first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            DateObject next = list.get(i);
            // 合并区间，时间精确到秒（差1秒则为连续）
            if (next.getStartDate().getTime() < first.getEndDate().getTime() || next.getStartDate().getTime() - first.getEndDate().getTime() == 1000) {
                first.setStartDate(new Date(Math.min(first.getStartDate().getTime(), next.getStartDate().getTime())));
                first.setEndDate(new Date(Math.max(first.getEndDate().getTime(), next.getEndDate().getTime())));
            } else {
                // 没有交集，直接添加
                result.add(first);
                first = next;
            }
        }
        result.add(first);
        return result;
    }

    /**
     * 包含开始时间和结束时间的对象
     */
    private class DateObject {
        private Date startDate;
        private Date endDate;

        public DateObject(Date startDate, Date endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        @Override
        public String toString() {
            return "DateObject{startDate=" + startDate + ", endDate=" + endDate + "}";
        }
    }


}

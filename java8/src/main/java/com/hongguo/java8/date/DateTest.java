package com.hongguo.java8.date;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
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
        // 开放提报时间区间
        DateObject open = new DateObject(format.parse("2019-09-02 00:00:00"), format.parse("2019-09-06 23:59:59"));

        // 广告位时间区间列表合并
        List<DateObject> merge = merge(init());
        System.out.println("广告位时间区间列表合并：" + JSONObject.toJSONStringWithDateFormat(merge, "yyyy-MM-dd HH:mm:ss"));
        // 求交集
        List<DateObject> intersection = intersection(open, merge);
        System.out.println("开放提报时间区间与广告位时间区间列表求交集：" + JSONObject.toJSONStringWithDateFormat(intersection, "yyyy-MM-dd HH:mm:ss"));
        // 求差集
        if (intersection.isEmpty()) {
            System.out.println("该区间不可再选：" + JSONObject.toJSONStringWithDateFormat(open, "yyyy-MM-dd HH:mm:ss"));
            return;
        }
        List<DateObject> list = differences(open, intersection);
        System.out.println("最终可选择的时间区间：" + JSONObject.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 初始化DateObject集合对象
     * 已提交素材时间区间
     *
     * @return
     * @throws Exception
     */
    private List<DateObject> init() throws Exception {
        List<DateObject> list = Lists.newArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        list.add(new DateObject(format.parse("2019-09-03 00:00:00"), format.parse("2019-09-03 23:59:59")));
        list.add(new DateObject(format.parse("2019-09-04 00:00:00"), format.parse("2019-09-04 23:59:59")));
        list.sort(Comparator.comparing(DateObject::getStartDate));
        return list;
    }

    /**
     * 求差集
     *
     * @param open
     * @param list
     * @return
     */
    private List<DateObject> differences(DateObject open, List<DateObject> list) {
        List<DateObject> result = Lists.newArrayList();
        DateObject first = list.get(0);
        if (list.size() == 1) {
            if (open.getStartDate().getTime() < first.getStartDate().getTime()) {
                result.add(new DateObject(open.getStartDate(), DateUtils.getEndTimeOfDay(DateUtils.plusDays(first.getStartDate(), -1))));
            }
            if (open.getEndDate().getTime() - first.getEndDate().getTime() > 1000) {
                result.add(new DateObject(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(first.getEndDate(), 1)), DateUtils.getEndTimeOfDay(open.getEndDate())));
            }
        } else {
            for (int i = 1; i < list.size(); i++) {
                DateObject next = list.get(i);
                result.add(new DateObject(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(first.getEndDate(), 1)), DateUtils.getEndTimeOfDay(DateUtils.plusDays(next.getStartDate(), -1))));
                first = next;
            }
            DateObject last = list.get(list.size() - 1);
            if (open.getEndDate().getTime() > last.getEndDate().getTime()) {
                result.add(new DateObject(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(last.getEndDate(), 1)), DateUtils.getEndTimeOfDay(open.getEndDate())));
            }
        }
        return result;
    }

    /**
     * 求开放时间区间与广告位时间区间的所有交集
     *
     * @param dateObject
     * @param list
     * @return
     */
    private List<DateObject> intersection(DateObject dateObject, List<DateObject> list) {
        List<DateObject> result = Lists.newArrayList();
        for (DateObject date : list) {
            // 广告位时间区间全部在开放提报时间区间内：ad.startDate <= open.startDate < open.endDate <= ad.endDate
            // 则[open.startDate, open.endDate] 均不开放
            if (date.getStartDate().getTime() <= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() >= dateObject.getEndDate().getTime()) {
                // 开放区间已全部投放素材
                System.out.println("no---------------");
                result = Lists.newArrayList();
                break;
            }
            // 广告位时间区间全部在开放提报时间区间内：open.startDate <= ad.startDate < ad.endDate <= open.endDate
            else if (date.getStartDate().getTime() >= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() <= dateObject.getEndDate().getTime()) {
                result.add(new DateObject(date.getStartDate(), date.getEndDate()));
            }
            // 广告位结束时间在开放提报时间区间内：ad.startDate <= open.startDate <= ad.endDate <= open.endDate
            else if (date.getStartDate().getTime() <= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() >= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() <= dateObject.getEndDate().getTime()) {
                result.add(new DateObject(dateObject.getStartDate(), date.getEndDate()));
            }
            // 广告位开始时间在开放提报时间区间内：open.startDate <= ad.startDate <= open.endDate <= ad.endDate
            else if (date.getEndDate().getTime() > dateObject.getEndDate().getTime()) {
                result.add(new DateObject(date.getStartDate(), dateObject.getEndDate()));
            }
        }
        return result;
    }

    /**
     * 时间区间合并
     *
     * @param list
     * @return
     * @throws Exception
     */
    private List<DateObject> merge(List<DateObject> list) throws Exception {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }

        List<DateObject> result = Lists.newArrayList();
        DateObject first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            DateObject next = list.get(i);
            // 合并区间
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

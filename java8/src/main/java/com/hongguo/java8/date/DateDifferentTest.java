package com.hongguo.java8.date;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
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
public class DateDifferentTest {

    @Test
    public void test1() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 开放提报时间区间
        DateObject open = new DateObject(format.parse("2019-07-01"), format.parse("2019-07-31"));

        // 广告位时间区间列表合并
        List<DateObject> merge = merge(init());
        System.out.println("时间区间列表合并：" + JSONObject.toJSONStringWithDateFormat(merge, "yyyy-MM-dd"));
        // 求交集
        List<DateObject> intersection = intersection(open, merge);
        System.out.println("时间区间求交集：" + JSONObject.toJSONStringWithDateFormat(intersection, "yyyy-MM-dd"));
        // 求差集
        if (intersection.isEmpty()) {
            System.out.println("该区间不可再选：" + JSONObject.toJSONStringWithDateFormat(open, "yyyy-MM-dd"));
            return;
        }
        List<DateObject> list = differences(open, intersection);
        System.out.println("时间区间求差集：" + JSONObject.toJSONStringWithDateFormat(list, "yyyy-MM-dd"));
    }

    /**
     * 初始化DateObject集合对象
     *
     * @return 初始化数据集合
     * @throws Exception 异常
     */
    private List<DateObject> init() throws Exception {
        List<DateObject> list = Lists.newArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        list.add(new DateObject(format.parse("2019-07-01"), format.parse("2019-07-10")));
        list.add(new DateObject(format.parse("2019-07-15"), format.parse("2019-07-20")));
        list.add(new DateObject(format.parse("2019-07-22"), format.parse("2019-07-25")));
        // 排序，默认日期正序
        list.sort(Comparator.comparing(DateObject::getStartDate));
        return list;
    }


    /**
     * 求差集
     *
     * @param dateObject 日期对象
     * @param list       日期集合
     * @return 差集
     */
    private List<DateObject> differences(DateObject dateObject, List<DateObject> list) {
        List<DateObject> result = new ArrayList<>();
        DateObject first = list.get(0);
        if (list.size() == 1) {
            result.add(new DateObject(first.getEndDate(), dateObject.getEndDate()));
        } else {
            for (int i = 1; i < list.size(); i++) {
                DateObject next = list.get(i);
                result.add(new DateObject(first.getEndDate(), next.getStartDate()));
                first = next;
            }
            DateObject last = list.get(list.size() - 1);
            result.add(new DateObject(last.getEndDate(), dateObject.getEndDate()));
        }
        return result;
    }


    /**
     * 求已知日期区间date与日期区间集合list的交集
     *
     * @param dateObject 日期对象
     * @param list       日期集合
     * @return 交集
     */
    public List<DateObject> intersection(DateObject dateObject, List<DateObject> list) {
        List<DateObject> result = new ArrayList<>();
        for (DateObject date : list) {
            // dateObject全部在date时间区间内：date.startDate <= dateObject.startDate < dateObject.endDate <= date.endDate
            // 则dateObject与list的交集为空
            if (date.getStartDate().getTime() <= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() >= dateObject.getEndDate().getTime()) {
                result = Lists.newArrayList();
                break;
            }
            // date全部在dateObject时间区间内：dateObject.startDate <= date.startDate < date.endDate <= dateObject.endDate
            // 则交集为[date.startDate, date.endDate]
            else if (date.getStartDate().getTime() >= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() <= dateObject.getEndDate().getTime()) {
                result.add(new DateObject(date.getStartDate(), date.getEndDate()));
            }
            // date结束时间在dateObject区间内：date.startDate <= dateObject.startDate <= date.endDate <= dateObject.endDate
            // 则交集为[dateObject.startDate, date.endDate]
            else if (date.getStartDate().getTime() <= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() >= dateObject.getStartDate().getTime()
                    && date.getEndDate().getTime() <= dateObject.getEndDate().getTime()) {
                result.add(new DateObject(dateObject.getStartDate(), date.getEndDate()));
            }
            // date开始时间在dateObject内：dateObject.startDate <= date.startDate <= dateObject.endDate <= date.endDate
            // 则交集为[date.startDate, dateObject.endDate]
            else if (date.getEndDate().getTime() > dateObject.getEndDate().getTime()) {
                result.add(new DateObject(date.getStartDate(), dateObject.getEndDate()));
            }
        }
        return result;
    }


    /**
     * 日期区间合并
     *
     * @param list 日期集合
     * @return 合并后日期集合
     */
    public List<DateObject> merge(List<DateObject> list) {
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }

        List<DateObject> result = new ArrayList<>();
        DateObject first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            DateObject next = list.get(i);
            // 判断first与next是否有交集
            if (next.getStartDate().getTime() >= first.getStartDate().getTime()
                    && next.getStartDate().getTime() <= first.getEndDate().getTime()) {
                // 合并区间
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

package com.hongguo.java8.date;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.hongguo.java8.utils.DateUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2019-06-24
 * @description:
 */
public class DateTest {

    @Test
    public void test1() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        InternalVO open = new InternalVO(format.parse("2019-07-01"), format.parse("2019-07-31"));

        // 时间区间合并
        List<InternalVO> merge = merge(init());
        System.out.println("时间区间合并：" + JSONObject.toJSONStringWithDateFormat(merge, "yyyy-MM-dd HH:mm:ss"));
        // 求交集
        List<InternalVO> result = intersection(open, merge);
        // 求差集
        List<InternalVO> list = Lists.newArrayList();
        InternalVO first = result.get(0);
        if (result.size() == 1) {
            list.add(new InternalVO(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(first.getEndTime(), 1)), DateUtils.getEndTimeOfDay(open.getEndTime())));
        } else {
            for (int i = 1; i < result.size(); i++) {
                InternalVO next = result.get(i);
                list.add(new InternalVO(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(first.getEndTime(), 1)), DateUtils.getEndTimeOfDay(DateUtils.plusDays(next.getStartTime(), -1))));
                first = next;
            }
            InternalVO last = result.get(result.size() - 1);
            list.add(new InternalVO(DateUtils.getFirstTimeOfDay(DateUtils.plusDays(last.getEndTime(), 1)), DateUtils.getEndTimeOfDay(open.getEndTime())));
        }
        System.out.println("最终可选择的时间区间：" + JSONObject.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 求开放时间区间与广告位时间区间的所有交集
     *
     * @param open
     * @param merge
     * @return
     */
    private List<InternalVO> intersection(InternalVO open, List<InternalVO> merge) {
        List<InternalVO> result = Lists.newArrayList();
        for (InternalVO ad : merge) {
            // 广告位时间区间全部在开放提报时间区间内：ad.startTime <= open.startTime < open.endTime <= ad.endTime
            // 则[open.startTime, open.endTime] 均不开放
            if (ad.getStartTime().getTime() <= open.getStartTime().getTime()
                    && ad.getEndTime().getTime() >= open.getEndTime().getTime()) {
                // 开放区间已全部投放素材
                System.out.println("no---------------");
                result = Lists.newArrayList();
                break;
            }
            // 广告位时间区间全部在开放提报时间区间内：open.startTime <= ad.startTime < ad.endTime <= open.endTime
            else if (ad.getStartTime().getTime() >= open.getStartTime().getTime()
                    && ad.getEndTime().getTime() <= open.getEndTime().getTime()) {
                result.add(new InternalVO(ad.getStartTime(), ad.getEndTime()));
            }
            // 广告位结束时间在开放提报时间区间内：ad.startTime <= open.startTime <= ad.endTime <= open.endTime
            else if (ad.getStartTime().getTime() <= open.getStartTime().getTime()
                    && ad.getEndTime().getTime() >= open.getStartTime().getTime()
                    && ad.getEndTime().getTime() <= open.getEndTime().getTime()) {
                result.add(new InternalVO(open.getStartTime(), ad.getEndTime()));
            }
            // 广告位开始时间在开放提报时间区间内：open.startTime <= ad.startTime <= open.endTime <= ad.endTime
            else if (ad.getEndTime().getTime() > open.getEndTime().getTime()) {
                result.add(new InternalVO(ad.getStartTime(), open.getEndTime()));
            }
        }
        System.out.println("交集：" + JSONObject.toJSONStringWithDateFormat(result, "yyyy-MM-dd"));
        return result;
    }

    /**
     * 时间区间合并
     *
     * @param list
     * @return
     * @throws Exception
     */
    private List<InternalVO> merge(List<InternalVO> list) throws Exception {
        if (list == null || list.size() == 0) {
            return Lists.newArrayList();
        }

        List<InternalVO> result = Lists.newArrayList();
        InternalVO first = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            InternalVO next = list.get(i);
            // 合并区间
            if (next.getStartTime().getTime() >= first.getStartTime().getTime()
                    && next.getStartTime().getTime() <= first.getEndTime().getTime()) {
                first.setEndTime(new Date(Math.max(first.getEndTime().getTime(), next.getEndTime().getTime())));
            } else {
                // 没有交集，直接添加
                result.add(first);
                first = next;
            }
        }
        result.add(first);
        return result;
    }

    private List<InternalVO> init() throws Exception {
        List<InternalVO> list = Lists.newArrayList();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        list.add(new InternalVO(format.parse("2019-06-10"), format.parse("2019-06-17")));
        list.add(new InternalVO(format.parse("2019-06-23"), format.parse("2019-06-28")));
        list.add(new InternalVO(format.parse("2019-06-19"), format.parse("2019-06-20")));
        list.add(new InternalVO(format.parse("2019-07-01"), format.parse("2019-07-10")));
        list.add(new InternalVO(format.parse("2019-07-15"), format.parse("2019-07-20")));
        list.add(new InternalVO(format.parse("2019-07-22"), format.parse("2019-07-25")));
        list.sort(Comparator.comparing(InternalVO::getStartTime));
        return list;
    }

    private class InternalVO {
        private Date startTime;
        private Date endTime;

        public InternalVO(Date startTime, Date endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "InternalVO{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }


}

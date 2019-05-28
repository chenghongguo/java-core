package com.hongguo.java8.date;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: chenghongguo
 * @date: 2019-05-22
 * @description:
 */
@Data
@Builder
public class DateObject {

    private Date startTime;

    private Date endTime;
}

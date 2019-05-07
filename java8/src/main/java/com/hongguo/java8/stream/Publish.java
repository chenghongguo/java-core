package com.hongguo.java8.stream;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author: chenghongguo
 * @date: 2018-12-19
 * @description: 投放记录
 */
@Data
@Builder
public class Publish {

    private Long id;

    private Long advertisementId;

    private Long resourceDetailId;

    private Long resourceId;

    private Integer positionNum;

    private Long skuId;

    private Date startTime;

    private Date endTime;

    private Byte managementStyle;

    private String material;

    private Byte status;

    private Date created;

    private Date modified;
}
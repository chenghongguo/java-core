package com.hongguo.java8.core.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 系统信息表
 *
 * @author tangniannian
 * @date 2018年12月29日14:30:52
 */
@Data
@Builder
public class SystemPO implements Serializable {

    private static final long serialVersionUID = -2476872872825493300L;

    /**
     * 一级系统ID
     */
    private Integer id;

    /**
     * 系统名称
     */
    private String name;

    /**
     * 系统url
     */
    private String url;

    /**
     * 是否测试系统
     */
    private boolean test;

    /**
     * 是否隐藏
     */
    private boolean hidden;

    /**
     * 销售方式是否可互转
     */
    private boolean convertible;

    /**
     * 二级系统列表
     */
    private List<SystemDetailPO> sysDetailList;
}

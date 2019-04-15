package com.hongguo.java8;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * com.jd.vender.ads.man.domain.manager
 *
 * @author lvxin83
 * @date 2019/3/23
 * Description:
 */
@Data
@Builder
public class OwnerSystemPO implements Serializable {
    private static final long serialVersionUID = 7790549399153179830L;

    /**
     * 一级系统名称
     */
    private String sysName;

    /**
     *   对应二级系统名称的列表
     */
    private List<String> detailSysName;
}

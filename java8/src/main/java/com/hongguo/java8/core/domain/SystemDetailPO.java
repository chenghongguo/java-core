package com.hongguo.java8.core.domain;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 类描述:系统详情表
 *
 * @author tangniannian
 * @date 2018/12/29
 */
@Data
@Builder
public class SystemDetailPO implements Serializable {

    private static final long serialVersionUID = -1763828889701117209L;

    /**
     * 二级系统id
     */
    private Integer id;

    /**
     * 第几个位置
     */
    private Integer seq = 1;

    /**
     * 名称
     */
    private String name;

    /**
     * url
     */
    private String url;

    /**
     * 用户
     */
    private List<UserPO> userList;

}

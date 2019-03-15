package com.hongguo.java8.core.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息
 *
 * @author chenghongugo
 */
@Data
public class UserPO implements Serializable {

    private static final long serialVersionUID = 8807130932761442232L;

    private Integer id;

    /**
     * 用户ERP
     */
    private String erp;

    /**
     * 用户名称
     */
    private String name;
}

package com.hongguo.java.base.ifelse.factory;

import com.hongguo.java.base.ifelse.RoleOperation;

/**
 * OrderAdminRole
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public class OrderAdminRole implements RoleOperation {

    private String roleName;

    public OrderAdminRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String op() {
        return roleName + " has BBB permission";
    }
}

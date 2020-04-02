package com.hongguo.java.base.ifelse.strategy;

import com.hongguo.java.base.ifelse.RoleOperation;

/**
 * RoleContext
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public class RoleContext {

    private RoleOperation operation;

    public RoleContext(RoleOperation operation) {
        this.operation = operation;
    }

    public String execute() {
        return operation.op();
    }
}

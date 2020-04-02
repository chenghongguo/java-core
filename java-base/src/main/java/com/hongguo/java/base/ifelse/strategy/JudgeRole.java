package com.hongguo.java.base.ifelse.strategy;

import com.hongguo.java.base.ifelse.RoleOperation;

/**
 * JudgeRole
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public class JudgeRole {

    public String judge(RoleOperation operation) {
        RoleContext context = new RoleContext(operation);
        return context.execute();
    }
}

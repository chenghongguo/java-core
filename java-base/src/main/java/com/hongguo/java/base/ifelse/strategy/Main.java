package com.hongguo.java.base.ifelse.strategy;

import com.hongguo.java.base.ifelse.factory.NormalRole;
import com.hongguo.java.base.ifelse.factory.OrderAdminRole;
import com.hongguo.java.base.ifelse.factory.RootAdminRole;

/**
 * Main
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        JudgeRole judgeRole = new JudgeRole();
        String result = judgeRole.judge(new RootAdminRole("ROLE_ROOT_ADMIN"));
        System.out.println(result);
        String result2 = judgeRole.judge(new OrderAdminRole("ROLE_ORDER_ADMIN"));
        System.out.println(result2);
        String result3 = judgeRole.judge(new NormalRole("ROLE_NORMAL"));
        System.out.println(result3);
    }
}

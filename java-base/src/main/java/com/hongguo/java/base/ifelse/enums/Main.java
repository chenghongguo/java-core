package com.hongguo.java.base.ifelse.enums;

/**
 * Main
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        String judge = RoleEnum.judge("ROLE_NORMAL");
        System.out.println(judge);
    }
}

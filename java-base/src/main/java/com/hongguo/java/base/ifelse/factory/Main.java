package com.hongguo.java.base.ifelse.factory;

/**
 * Main
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        RoleFactory factory = new RoleFactory();
        String role = factory.judge("ROLE_NORMAL");
        System.out.println(role);
    }
}

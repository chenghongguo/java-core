package com.hongguo.java.base.ifelse.enums;

import com.hongguo.java.base.ifelse.RoleOperation;

/**
 * RoleEnum
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public enum RoleEnum implements RoleOperation {

    ROLE_ROOT_ADMIN {
        @Override
        public String op() {
            return "ROLE_ROOT_ADMIN" + " has AAA permission";
        }
    },

    ROLE_ORDER_ADMIN {
        @Override
        public String op() {
            return "ROLE_ORDER_ADMIN" + " has Order permission";
        }
    },

    ROLE_NORMAL {
        @Override
        public String op() {
            return "ROLE_NORMAL" + " has Normal permission";
        }
    };

    public static String judge(String roleName) {
        return RoleEnum.valueOf(roleName).op();
    }
}

package com.hongguo.java.base.ifelse.factory;

import com.hongguo.java.base.ifelse.RoleOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * RoleFactory
 *
 * @author chenghongguo
 * @date 2020/4/2
 * @since 1.0.0
 */
public class RoleFactory {

    static Map<String, RoleOperation> map = new HashMap<>(8);

    static {
        map.put("ROLE_ROOT_ADMIN", new RootAdminRole("ROLE_ROOT_ADMIN"));
        map.put("ROLE_ORDER_ADMIN", new OrderAdminRole("ROLE_ORDER_ADMIN"));
        map.put("ROLE_NORMAL", new NormalRole("ROLE_NORMAL"));
    }

    public static RoleOperation getOp(String roleName) {
        return map.get(roleName);
    }

    public String judge(String roleName) {
        return RoleFactory.getOp(roleName).op();
    }
}

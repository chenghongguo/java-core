package com.hongguo.java8.core;

import com.hongguo.java8.OwnerSystemPO;
import com.hongguo.java8.core.domain.SystemDetailPO;
import com.hongguo.java8.core.domain.SystemPO;
import com.hongguo.java8.core.domain.UserPO;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2019-02-20
 * @description:
 */
public class StringTest {

    @Test
    public void test4() {
        List<UserPO> userPOList = new ArrayList<>();
        userPOList.add(UserPO.builder().erp("chenghongguo").build());
        userPOList.add(UserPO.builder().erp("lvxin83").build());
        userPOList.add(UserPO.builder().erp("chenjie70").build());
        userPOList.add(UserPO.builder().erp("lixiaozhuo").build());
        userPOList.add(UserPO.builder().erp("tangniannian").build());
        userPOList.add(UserPO.builder().erp("test").build());
        boolean anyMatch = userPOList.stream().anyMatch(userPO -> userPO.getErp().equals("chenghongguo3"));
        System.out.println(anyMatch);
    }

    @Test
    public void test1() {
        String st1 = "abc";
        String st2 = "abc";
        System.out.println(st1 == st2);
        String st3 = new String("abc");
        String st4 = new String("abc");
        System.out.println(st1 == st3);
        System.out.println(st3 == st4);
        System.out.println(System.identityHashCode(st1));
        System.out.println(System.identityHashCode(st2));
        System.out.println(System.identityHashCode(st3));
        System.out.println(System.identityHashCode(st4));
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("测试系统-测试首页", "测试系统-测试标题页");
        convertToSystems(list);
    }

    private List<OwnerSystemPO> convertToSystems(List<String> servingSearchSysList) {
        Map<String, List<String>> result = new HashMap<>(16);
        servingSearchSysList.forEach(system -> {
            String[] sys = system.split("-");
            if (result.containsKey(sys[0])) {
                result.get(sys[0]).add(sys[1]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(sys[1]);
                result.put(sys[0], list);
            }
        });
        if (result.size() <= 0) {
            return Collections.emptyList();
        }
        List<OwnerSystemPO> ownerSystemList = new ArrayList<>();
        result.forEach((k, v) -> ownerSystemList.add(OwnerSystemPO.builder().sysName(k).detailSysName(v).build()));
        return ownerSystemList;
    }

    @Test
    public void test3() {
        List<SystemPO> list = new ArrayList<>();
        SystemDetailPO systemDetailPO = SystemDetailPO.builder().name("首页").userList(
                Arrays.asList(UserPO.builder().erp("lvxin83").build(), UserPO.builder().erp("chenjie").build()))
                .build();
        SystemDetailPO systemDetailPO2 = SystemDetailPO.builder().name("列表页").userList(
                Arrays.asList(UserPO.builder().erp("chenghongguo").build()))
                .build();
        SystemDetailPO systemDetailPO3 = SystemDetailPO.builder().name("列表页").userList(
                Arrays.asList(UserPO.builder().erp("test").build()))
                .build();
        List<SystemDetailPO> systemDetailPOList = new ArrayList<>();
        systemDetailPOList.add(systemDetailPO);
        systemDetailPOList.add(systemDetailPO2);
        systemDetailPOList.add(systemDetailPO3);
        SystemPO systemPO = SystemPO.builder().name("测试系统").sysDetailList(systemDetailPOList).build();
        list.add(systemPO);

        list.stream().map(system -> {
            List<SystemDetailPO> collect = system.getSysDetailList().stream()
                    .map(systemDetailPO1 -> {
                        List<UserPO> collect1 = systemDetailPO1.getUserList().stream().filter(userPO -> userPO.getErp().equals("chenghongguo")).collect(Collectors.toList());
                        if (collect1.size() > 0) {
                            return SystemDetailPO.builder().name(systemDetailPO1.getName()).userList(collect1).build();
                        } else {
                            return null;
                        }
                    }).collect(Collectors.toList());
            if (collect.size() > 0) {
                return SystemPO.builder().name(system.getName()).sysDetailList(collect).build();
            } else {
                return null;
            }
        }).forEach(System.out::println);
    }
}

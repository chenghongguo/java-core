package com.hongguo.java8.core;

import com.hongguo.java8.core.domain.MaterialDTO;
import com.hongguo.java8.utils.DateUtils;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: chenghongguo
 * @date: 2019-04-15
 * @description:
 */
public class MaterialTest {

    @Test
    public void test1() {
        List<MaterialDTO> list = createList();
        Date date = new Date();
//        list.removeIf(materialDTO -> materialDTO.getStartTime().after(date) || materialDTO.getEndTime().before(date));
//        list.forEach(dto -> {
//            System.out.println(dto);
//        });
        // 全量版本
        List<MaterialDTO> materialDTOList = list.stream()
                .filter(materialDTO -> materialDTO.getVersion() == null || "".equals(materialDTO.getVersion()))
                .collect(Collectors.toList());
        System.out.println(materialDTOList);
        // 部分版本
        Map<String, List<MaterialDTO>> collect = list.stream()
                .filter(materialDTO -> materialDTO.getVersion() != null && !"".equals(materialDTO.getVersion()))
                .collect(Collectors.groupingBy(MaterialDTO::getVersion));
        // 遍历部分版本素材
        collect.forEach((k, v) -> {
            System.out.println(k + ", " + v);
        });
    }

    private List<MaterialDTO> createList() {
        List<MaterialDTO> list = new ArrayList<>();
        list.add(MaterialDTO.builder()
                .id(100L)
                .name("素材name")
                .version("v1.0.0")
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 13, 00, 00)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 14, 59, 59)))
                .build());
        list.add(MaterialDTO.builder()
                .id(101L)
                .name("素材name1")
                .version("v1.0.1")
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 12, 00, 00)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 14, 59, 59)))
                .build());
        list.add(MaterialDTO.builder()
                .id(102L)
                .name("素材name2")
                .version("v1.0.2")
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 15, 00, 00)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 17, 59, 59)))
                .build());
        list.add(MaterialDTO.builder()
                .id(103L)
                .name("素材name3")
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 15, 00, 00)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 17, 59, 59)))
                .build());
        list.add(MaterialDTO.builder()
                .id(104L)
                .name("素材name2")
                .version("v1.0.2")
                .startTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 15, 00, 00)))
                .endTime(DateUtils.convertLocalDateTimeToDate(LocalDateTime.of(2019, 04, 15, 17, 59, 59)))
                .build());
        return list;
    }
}

package com.hongguo.java.base.poi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * PoiTest
 *
 * @author chenghongguo
 * @date 2020/5/21
 */
public class PoiTest {
    public static void main(String[] args) {
        Map<String, Set<String>> test = test("e://4.xlsx");
        System.out.println(test);
    }

    static Map<String, Set<String>> test(String path) {
        Map<String, Set<String>> map = new HashMap<>(8);
        File file = new File(path);
        if (!file.exists()) {
            return map;
        }
        Workbook sheets = null;
        try {
            sheets = WorkbookFactory.create(file);
            Sheet sheet = sheets.getSheetAt(0);
            List<InnerCell> list = new ArrayList<>();
            int lastRowNum = sheet.getLastRowNum();
            System.out.println("sheet row numbers:" + lastRowNum);
            // 校验存储数据量不能大于最大值

            for (int i = 0; i <= lastRowNum; i++) {
                if (i == 0) {
                    continue;
                }
                Row row = sheet.getRow(i);
                String name = getCellContent(row.getCell(0, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK));
                String type = getCellContent(row.getCell(1, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK));
                System.out.println(name + ", " + type);
                if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(type)) {
                    list.add(new InnerCell(type, name));
                }
            }

            Map<String, List<InnerCell>> listMap = list.stream().collect(Collectors.groupingBy(InnerCell::getType));
            listMap.forEach((k, v) -> map.put(k, v.stream().map(InnerCell::getName).collect(Collectors.toSet())));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sheets) {
                try {
                    sheets.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    private static class InnerCell {
        private String type;
        private String name;
    }

    private static String getCellContent(Cell cell) {
        if (null == cell) {
            return null;
        }
        String value = null;
        switch (cell.getCellType()) {
            case STRING:
                value = cell.getRichStringCellValue().getString();
                break;
            case NUMERIC:
                value = String.valueOf((int) cell.getNumericCellValue());
                break;
            default:
                break;
        }
        return value;
    }

}

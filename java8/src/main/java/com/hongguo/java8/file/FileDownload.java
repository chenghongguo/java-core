package com.hongguo.java8.file;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * FileDownload
 *
 * @author chenghongguo
 * @date 2020/5/12
 * @since 1.0.0
 */
public class FileDownload {

    @Test
    public void download() {
        String urlStr = "http://storage.jd.com/open-shared-files/test.xlsx";
        File temp = new File(UUID.randomUUID().toString().replaceAll("-", ""));
        try {
            FileUtils.copyURLToFile(new URL(urlStr), temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readExcel() {
        File temp = new File("e:/test.xlsx");
        try {
            Workbook sheets = WorkbookFactory.create(temp);
            Sheet sheet = sheets.getSheetAt(0);
            List<InnerCell> list = new ArrayList<>();
            for (Row row : sheet) {
                String name = getCellContent(row.getCell(0, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK));
                String type = getCellContent(row.getCell(1, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK));
                list.add(new InnerCell(type, name));
            }
            Map<String, List<InnerCell>> map = list.stream().collect(Collectors.groupingBy(InnerCell::getType));
            Map<String, Set<String>> setMap = new HashMap<>();
            map.forEach((k, v) -> setMap.put(k, v.stream().map(InnerCell::getName).collect(Collectors.toSet())));
            System.out.println(setMap);
            Collection<Set<String>> values = setMap.values();
            List<String> all = new ArrayList<>();
            values.forEach(v -> all.addAll(v));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCellContent(Cell cell) {
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

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    private static class InnerCell {
        private String type;
        private String name;
    }
}

package com.hongguo.java.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * SimpleDateFormatTest
 *
 * @author chenghongguo
 * @date 2020/4/21
 * @since 1.0.0
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<String> strs = Arrays.asList("2017-10-10", "2018-10-10", "2019-01-22", "2020-01-01", "2020-03-01");

        List<SimpleDemo> demos = new ArrayList<>();

        strs.forEach(s -> demos.add(new SimpleDemo(simpleDateFormat, s)));

        demos.forEach(r -> new Thread(r).start());
    }
}

class SimpleDemo implements Runnable {

    private SimpleDateFormat simpleDateFormat;

    private String str;

    public SimpleDemo(SimpleDateFormat simpleDateFormat, String str) {
        this.simpleDateFormat = simpleDateFormat;
        this.str = str;
    }

    @Override
    public void run() {
        try {
            Date date = simpleDateFormat.parse(str);
            System.out.println(str + " = " + date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
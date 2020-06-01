package com.hongguo.java8.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * NetUtils
 *
 * @author chenghongguo
 * @date 2020/5/12
 */
public class NetUtils {

    public static void main(String[] args) {
        boolean valid = NetUtils.isValid("http://storage.jd.com/xue.jd.com/source/data/70b8a6b447d844008e2cbebb3601c23e.xlsx");
        System.out.println(valid);
    }

    /**
     * 校验url是否有效
     *
     * @param urlStr 地址
     * @return true if valid
     */
    public static boolean isValid(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            huc.setRequestMethod("HEAD");
            int responseCode = huc.getResponseCode();
            return HttpURLConnection.HTTP_OK == responseCode;
        } catch (IOException e) {
            System.out.println("URL: {}, exception:{}" + urlStr + ", " + e);
            return false;
        }
    }
}

package com.hongguo.java8.functionalinterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * TestBuffered
 *
 * @author chenghongguo
 * @date 2020/2/18
 * @since 1.0.0
 */
public class TestBuffered {

    public static String processFile() throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor processor) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return processor.process(br);
        }
    }

    public static void main(String[] args) throws Exception {
        String oneLine = processFile(br -> {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
        String twoLine = processFile(br -> {
            try {
                return br.readLine() + br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        });
    }
}

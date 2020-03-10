package com.hongguo.java8.functionalinterface;

import java.io.BufferedReader;

/**
 * BufferedReaderProcessor
 *
 * @author chenghongguo
 * @date 2020/2/18
 * @since 1.0.0
 */
@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader reader) throws NullPointerException;
}

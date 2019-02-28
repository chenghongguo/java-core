package com.hongguo.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * @author: chenghongguo
 * @date: 2019-02-28
 * @description:
 */
public class BufferTest {

    private static final String MESSAGE = "abcde";

    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println("---------------allocate()----------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.put(MESSAGE.getBytes());
        System.out.println("---------------put()----------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.flip();
        System.out.println("---------------flip()----------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.get();
        System.out.println("---------------get()----------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.rewind();
        System.out.println("---------------rewind()----------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

        buffer.clear();
        System.out.println("---------------clear()----------------");
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());

    }
}

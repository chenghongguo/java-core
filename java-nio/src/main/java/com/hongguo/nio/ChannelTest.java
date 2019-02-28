package com.hongguo.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: chenghongguo
 * @date: 2019-02-28
 * @description: Channel
 * |- FileChannel
 * |- SocketChannel
 * |- ServerSocketChannel
 * |- DatagramChannel
 */
public class ChannelTest {

    /**
     * 文件读取 - RandomAccessFile
     *
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("d:/logback.xml", "rw");
        FileChannel channel = raf.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int data = channel.read(buffer);
        while (data != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            data = channel.read(buffer);
        }
        channel.close();
        raf.close();
    }

    /**
     * 分散和聚集
     */
    @Test
    public void test4() {
        try (FileChannel inChannel = FileChannel.open(Paths.get("d:/logback.xml"), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get("d:/logback2.xml"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer1 = ByteBuffer.allocate(100);
            ByteBuffer buffer2 = ByteBuffer.allocate(1024);
            ByteBuffer[] buffers = {buffer1, buffer2};
            inChannel.read(buffers);
            buffer1.flip();
            System.out.println(new String(buffer1.array(), 0, buffer1.limit()));
            System.out.println("---------------------------------------------");
            buffer2.flip();
            System.out.println(new String(buffer2.array(), 0, buffer2.limit()));
            outChannel.write(buffers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取文件内容
     */
    @Test
    public void test3() {
        try (FileChannel inChannel = FileChannel.open(Paths.get("d:/logback.xml"), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                System.out.println(new String(buffer.array(), 0, buffer.limit()));
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件复制：通道迁移
     */
    @Test
    public void test2() {
        try (FileChannel inChannel = FileChannel.open(Paths.get("d:/logback.xml"), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get("d:/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            // outChannel.transferFrom(inChannel, 0, inChannel.size());
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件复制：缓冲区
     */
    @Test
    public void test1() {
        try (FileChannel inChannel = FileChannel.open(Paths.get("d:/1.jpg"), StandardOpenOption.READ);
             FileChannel outChannel = FileChannel.open(Paths.get("d:/2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

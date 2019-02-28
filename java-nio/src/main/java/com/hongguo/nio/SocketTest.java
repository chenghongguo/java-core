package com.hongguo.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: chenghongguo
 * @date: 2019-02-28
 * @description:
 */
public class SocketTest {

    /**
     * 服务端
     *
     * @throws IOException
     */
    @Test
    public void server() throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(9090));
        SocketChannel accept = server.accept();
        FileChannel fileChannel = FileChannel.open(Paths.get("d:/2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (accept.read(buffer) != -1) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        fileChannel.close();
        accept.close();
        server.close();

    }

    /**
     * 客户端
     *
     * @throws IOException
     */
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9090));
        FileChannel fileChannel = FileChannel.open(Paths.get("d:/logback.xml"), StandardOpenOption.READ);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (fileChannel.read(buffer) != -1) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        fileChannel.close();
        socketChannel.close();
    }
}

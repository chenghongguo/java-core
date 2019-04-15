package com.hongguo.nio.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author hongguo_cheng
 * @date 2019-03-19
 * @description
 */
public class NioServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(8899));

        ByteBuffer buffer = ByteBuffer.allocate(4096);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);
            int read = 0;
            int readCount = 0;
            long start = System.currentTimeMillis();
            while ((read = socketChannel.read(buffer)) != -1) {
                readCount += read;
                buffer.rewind();
            }
            System.out.println("字节总数：" + readCount + ", 耗时：" + (System.currentTimeMillis() - start));
        }
    }
}

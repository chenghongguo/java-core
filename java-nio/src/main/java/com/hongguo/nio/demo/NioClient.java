package com.hongguo.nio.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hongguo_cheng
 * @date 2019-03-17
 * @description
 */
public class NioClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8899));
            Selector selector = Selector.open();
            socketChannel.register(selector, SelectionKey.OP_CONNECT);

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    try {
                        if (selectionKey.isConnectable()) {
                            SocketChannel client = (SocketChannel) selectionKey.channel();
                            if (client.isConnectionPending()) {
                                client.finishConnect();
                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                writeBuffer.put((LocalDateTime.now() + "连接成功").getBytes());
                                writeBuffer.flip();
                                client.write(writeBuffer);

                                ExecutorService executorService = Executors.newSingleThreadExecutor();
                                executorService.submit(() -> {
                                    while (true) {
                                        writeBuffer.clear();
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        writeBuffer.put(br.readLine().getBytes());
                                        writeBuffer.flip();
                                        client.write(writeBuffer);
                                    }
                                });
                            }
                            client.register(selector, SelectionKey.OP_READ);
                        } else if (selectionKey.isReadable()) {
                            SocketChannel client = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            int count = client.read(readBuffer);
                            if (count > 0) {
                                String msg = new String(readBuffer.array(), 0, count);
                                System.out.println(msg);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        selectionKeys.remove(selectionKey);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.hongguo.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author hongguo_cheng
 * @date 2019-03-17
 * @description
 */
public class NioServer {

    private static Map<String, SocketChannel> clientMap = new HashMap<>(16);

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.bind(new InetSocketAddress(8899));

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                selectionKeys.forEach(selectionKey -> {
                    try {
                        if (selectionKey.isAcceptable()) {
                            ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) selectionKey.channel();
                            SocketChannel socketChannel = serverSocketChannel1.accept();
                            socketChannel.configureBlocking(false);
                            String key = "[" + UUID.randomUUID().toString() + "]";
                            clientMap.put(key, socketChannel);
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        } else if (selectionKey.isReadable()) {
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                            int read = socketChannel.read(readBuffer);
                            if (read > 0) {
                                readBuffer.flip();
                                Charset charset = Charset.forName("utf-8");
                                String msg = String.valueOf(charset.decode(readBuffer).array());
                                System.out.println(socketChannel + ": " + msg);
                                String sendKey = null;
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (entry.getValue() == socketChannel) {
                                        sendKey = entry.getKey();
                                        break;
                                    }
                                }
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    SocketChannel value = entry.getValue();
                                    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                    writeBuffer.put((sendKey + ": " + msg).getBytes());
                                    writeBuffer.flip();
                                    value.write(writeBuffer);
                                }
                            } else {
                                System.out.println("client: " + socketChannel + ", 未读到任何数据");
                                for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                    if (entry.getValue() == socketChannel) {
                                        socketChannel.close();
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
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

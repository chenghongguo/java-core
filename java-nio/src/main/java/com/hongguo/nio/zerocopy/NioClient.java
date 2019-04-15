package com.hongguo.nio.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author hongguo_cheng
 * @date 2019-03-19
 * @description
 */
public class NioClient {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8899));
        socketChannel.configureBlocking(true);

        String filePath = "/Users/hongguo_cheng/Downloads/software/ideaIU-2018.3.dmg";

        FileChannel fileChannel = new FileInputStream(filePath).getChannel();

        fileChannel.transferTo(0, fileChannel.size(), socketChannel);

        fileChannel.close();
        socketChannel.close();
    }
}

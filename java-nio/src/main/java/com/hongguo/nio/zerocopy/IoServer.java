package com.hongguo.nio.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author hongguo_cheng
 * @date 2019-03-19
 * @description
 */
public class IoServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8899);
        serverSocket.setReuseAddress(true);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            byte[] buffer = new byte[4096];
            int count;
            int readCount = 0;
            long start = System.currentTimeMillis();
            while ((count = dataInputStream.read(buffer)) != -1) {
                readCount += count;
            }
            System.out.println("字节总数：" + readCount + ", 耗时：" + (System.currentTimeMillis() - start));
        }
    }
}

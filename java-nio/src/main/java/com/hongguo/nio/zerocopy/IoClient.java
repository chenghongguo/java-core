package com.hongguo.nio.zerocopy;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author hongguo_cheng
 * @date 2019-03-19
 * @description
 */
public class IoClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8899);

        String filePath = "/Users/hongguo_cheng/Downloads/software/ideaIU-2018.3.dmg";

        FileInputStream inputStream = new FileInputStream(filePath);

        OutputStream outputStream = socket.getOutputStream();

        byte[] buffer = new byte[4096];

        int count = 0;
        while ((count = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, count);
        }

        inputStream.close();
        outputStream.close();
    }
}

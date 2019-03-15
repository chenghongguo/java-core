package com.hongguo.java8.core;

import com.alibaba.fastjson.JSON;
import com.hongguo.java8.core.domain.SystemPO;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author: chenghongguo
 * @date: 2019-03-14
 * @description:
 */
public class JsonTest {

    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(10240);
        try {
            FileChannel fileChannel = FileChannel.open(Paths.get("d:/systems.json"));
            fileChannel.read(buffer);
            buffer.flip();
            byte[] array = buffer.array();
            String json = new String(array);
            List<SystemPO> systemPOList = JSON.parseArray(json, SystemPO.class);
            systemPOList.stream().filter(systemPO -> systemPO.isTest() == false).forEach(systemPO -> {
                System.out.println(systemPO);
            });
            System.out.println("====================");
            systemPOList.stream().filter(systemPO -> systemPO.isTest()).forEach(systemPO -> {
                System.out.println(systemPO);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

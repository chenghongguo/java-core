package com.hongguo.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * LongEventMain
 *
 * @author chenghongguo
 * @date 2020/4/29
 * @since 1.0.0
 */
public class LongEventMain {
    public static void main(String[] args) throws Exception {
        Executor executor = Executors.newCachedThreadPool();

        LongEventFactory factory = new LongEventFactory();
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, bufferSize, executor);

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        LongEventProducer producer = new LongEventProducer(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (long l = 0; true; l++) {
            byteBuffer.putLong(0, l);
            producer.onData(byteBuffer);
            Thread.sleep(1000);
        }
    }
}

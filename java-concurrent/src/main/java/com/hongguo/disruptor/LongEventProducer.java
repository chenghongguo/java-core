package com.hongguo.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * LongEventProducer
 *
 * @author chenghongguo
 * @date 2020/4/29
 * @since 1.0.0
 */
public class LongEventProducer {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer) {
        long sequence = ringBuffer.next();

        try {
            LongEvent event = ringBuffer.get(sequence);
            event.setValue(buffer.getLong(0));
        } finally {
            ringBuffer.publish(sequence);
        }
    }
}

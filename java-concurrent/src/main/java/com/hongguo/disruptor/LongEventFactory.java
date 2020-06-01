package com.hongguo.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * LongEventFactory
 *
 * @author chenghongguo
 * @date 2020/4/29
 * @since 1.0.0
 */
public class LongEventFactory implements EventFactory {

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}

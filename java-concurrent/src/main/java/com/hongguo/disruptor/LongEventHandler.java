package com.hongguo.disruptor;


import com.lmax.disruptor.EventHandler;

/**
 * LongEventHandler
 *
 * @author chenghongguo
 * @date 2020/4/29
 * @since 1.0.0
 */
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}

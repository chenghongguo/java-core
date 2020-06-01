package com.hongguo.java.base.innerclasses;

import java.time.Duration;
import java.time.Instant;

/**
 * Event
 *
 * @author chenghongguo
 * @date 2020/4/10
 * @since 1.0.0
 */
public abstract class Event {

    private Instant eventTime;

    protected final Duration delayTime;

    public Event(long millisecondDelay) {
        delayTime = Duration.ofMillis(millisecondDelay);
        start();
    }

    public void start() {
        eventTime = Instant.now().plus(delayTime);
    }

    public boolean ready() {
        return Instant.now().isAfter(eventTime);
    }

    public abstract void action();
}

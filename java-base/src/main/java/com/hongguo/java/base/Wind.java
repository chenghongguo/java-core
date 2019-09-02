package com.hongguo.java.base;

/**
 * Wind
 *
 * @author chenghongguo
 * @date 2019/8/27
 * @since 1.0.0
 */
public class Wind extends Instrument {

    @Override
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}

package com.hongguo.java.base;

/**
 * Stringed
 *
 * @author chenghongguo
 * @date 2019/8/27
 * @since 1.0.0
 */
public class Brass extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Brass.play() " + n);
    }
}

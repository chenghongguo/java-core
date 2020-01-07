package com.hongguo.java.base;

/**
 * Music
 *
 * @author chenghongguo
 * @date 2019/8/27
 * @since 1.0.0
 */
public class Music {
    public static void tune(Instrument i) {
        System.out.println(i.getClass());
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Wind wind = new Wind();
        Stringed stringed = new Stringed();
        Brass brass = new Brass();
        tune(wind);
        tune(stringed);
        tune(brass);
    }
}

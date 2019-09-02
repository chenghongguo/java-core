package com.hongguo.java.base;

/**
 * Glyph
 *
 * @author chenghongguo
 * @date 2019/8/28
 * @since 1.0.0
 */

public class Poly {
    public static void main(String[] args) {
        new Round(5);
    }
}

class Glyph {

    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph before draw()");
        draw();
        System.out.println("Glyph after draw()");
    }
}

class Round extends Glyph {
    private int r = 1;

    Round(int r) {
        this.r = r;
    }

    @Override
    void draw() {
        System.out.println("Round.r = " + r);
    }
}
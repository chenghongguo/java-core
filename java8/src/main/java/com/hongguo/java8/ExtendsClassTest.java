package com.hongguo.java8;

import java.util.Random;

/**
 * ExtendsClassTest
 *
 * @author chenghongguo
 * @date 2019/7/26
 * @since 1.0.0
 */
public class ExtendsClassTest extends BoardGame {

    private static Random random = new Random(20);

    private final int  a = random.nextInt();

    private static final int A = random.nextInt();

    private final int j;

    ExtendsClassTest() {
        super(11);
        j = 100;
        System.out.println("Chess constructor");
    }

    public void test(final int a) {
        System.out.println(a);
    }

    public void test2(final  Game game) {
        System.out.println(game);
    }

    public static void main(String[] args) {
//        ExtendsClassTest extendsClassTest = new ExtendsClassTest();
//        System.out.println(extendsClassTest.a);
//        extendsClassTest = new ExtendsClassTest();
//        System.out.println(extendsClassTest.a);
//        System.out.println(extendsClassTest.j);
//        System.out.println(ExtendsClassTest.A);
//        System.out.println(ExtendsClassTest.A);
//        extendsClassTest.test(100);
        System.out.println(Game.a);
    }

}

class Game {

    public static String a = "aaaaa";

    Game() {
        System.out.println("init");
    }
    Game(int i) {
        System.out.println("Game constructor");
    }

    final void testFinal() {
        System.out.println("Game final");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}

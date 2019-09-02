package com.hongguo.java.base;

/**
 * Chess
 *
 * @author chenghongguo
 * @date 2019/8/26
 * @since 1.0.0
 */
public class Chess extends BoardGame {
  Chess() {
      super(11);
      System.out.println("Chess constructor");
  }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
}

class Game {
    Game(int i) {
        System.out.println("Game Constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(1);
        System.out.println("BoardGame constructor");
    }
}
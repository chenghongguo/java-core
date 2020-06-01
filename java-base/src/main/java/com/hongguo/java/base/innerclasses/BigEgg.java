package com.hongguo.java.base.innerclasses;

/**
 * Egg
 *
 * @author chenghongguo
 * @date 2020/4/10
 * @since 1.0.0
 */
public class BigEgg extends Egg {
    public class Yolk {
        public Yolk() {
            System.out.println("BigEgg.Yolk()");
        }
    }

    public static void main(String[] args) {
        new BigEgg();
    }
}


class Egg {
    private Yolk y;

    protected class Yolk {
        public Yolk() {
            System.out.println("Egg.Yolk()");
        }
    }

    Egg() {
        System.out.println("New Egg()");
        y = new Yolk();
    }
}

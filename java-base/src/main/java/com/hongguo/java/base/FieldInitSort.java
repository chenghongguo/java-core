package com.hongguo.java.base;

/**
 * FieldInitSort
 *
 * @author chenghongguo
 * @date 2020/4/3
 * @since 1.0.0
 */
public class FieldInitSort {

    {
        water = new Water(10);
    }

    private Water water = new Water(1);

    public FieldInitSort() {
        Water water = new Water(2);
    }

    private Water water2 = new Water(3);

    static {
        staticWater = new Water(5);
    }

    private static Water staticWater = new Water(0);

    public static void main(String[] args) {
        new FieldInitSort();
    }
}

class Water {
    public Water(int i) {
        System.out.println("water" + i);
    }
}

package com.hongguo.java8;

/**
 * FieldAccess
 *
 * @author chenghongguo
 * @date 2019/7/26
 * @since 1.0.0
 */
public class FieldAccess {

    public static void main(String[] args) {
//        Super sup = new Sub();
//        System.out.println("sup.field = " + sup.field + ", sup.getField() = " + sup.getField());
//
//        Sub sub = new Sub();
//        System.out.println("sub.field = " + sub.field + ", sub.getField() = " + sub.getField() + ", sub.getSuperField() = " + sub.getSuperField());

        Super sup1 = new Sub();
        Super sup2 = new Sub2();
    }
}

class Super {
    public int field = 0;

    public Super() {
        System.out.println("Super init");
    }

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

class Sub2 extends Super {
    public int field = 1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

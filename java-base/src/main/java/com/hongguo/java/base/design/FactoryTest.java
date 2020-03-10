package com.hongguo.java.base.design;

/**
 * FactoryTest
 *
 * @author chenghongguo
 * @date 2019/12/20
 * @since 1.0.0
 */
public class FactoryTest {

    public static void main(String[] args) {
        HumanFactory femaleHumanFactory = new FemaleHumanFactory();
        Human femaleYellowHuman = femaleHumanFactory.createYellowHuman();
        femaleYellowHuman.getColor();
        femaleYellowHuman.talk();
        femaleYellowHuman.getSex();
    }
}


interface Human {
    void getColor();

    void talk();

    void getSex();
}

interface HumanFactory {
    Human createYellowHuman();

    Human createBlackHuman();

    Human createWhiteHuman();
}

class FemaleHumanFactory implements HumanFactory {
    @Override
    public Human createYellowHuman() {
        return new FemaleYellowHuman();
    }

    @Override
    public Human createBlackHuman() {
        return new FemaleBlackHuman();
    }

    @Override
    public Human createWhiteHuman() {
        return new FemaleWhiteHuman();
    }
}

abstract class AbstractWhiteHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("white color");
    }

    @Override
    public void talk() {
        System.out.println("white talk");
    }
}

class FemaleWhiteHuman extends AbstractWhiteHuman {
    @Override
    public void getSex() {
        System.out.println("female white sex");
    }
}

abstract class AbstractYellowHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("yellow color");
    }

    @Override
    public void talk() {
        System.out.println("yellow talk");
    }
}

class FemaleYellowHuman extends AbstractYellowHuman {
    @Override
    public void getSex() {
        System.out.println("female yellow sex");
    }
}

abstract class AbstractBlackHuman implements Human {
    @Override
    public void getColor() {
        System.out.println("black color");
    }

    @Override
    public void talk() {
        System.out.println("black talk");
    }

}

class FemaleBlackHuman extends AbstractBlackHuman {
    @Override
    public void getSex() {
        System.out.println("female black sex");
    }
}
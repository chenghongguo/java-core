package com.hongguo.java.base;

/**
 * Window
 *
 * @author chenghongguo
 * @date 2019/8/21
 * @since 1.0.0
 */
public class Window {

    static {
        System.out.println("static code block");
    }

    public Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }

    {
        System.out.println("code block");
    }
}

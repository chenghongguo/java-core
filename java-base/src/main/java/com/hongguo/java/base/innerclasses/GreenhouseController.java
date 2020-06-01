package com.hongguo.java.base.innerclasses;

/**
 * GreenhouseController
 *
 * @author chenghongguo
 * @date 2020/4/10
 * @since 1.0.0
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));

        Event[] events = {
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800)
        };

        gc.addEvent(gc.new Restart(2000, events));
        gc.addEvent(new GreenhouseControls.Terminate(5000));
        gc.run();
    }
}

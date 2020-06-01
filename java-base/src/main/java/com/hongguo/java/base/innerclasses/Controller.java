package com.hongguo.java.base.innerclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller
 *
 * @author chenghongguo
 * @date 2020/4/10
 * @since 1.0.0
 */
public class Controller {
    private List<Event> events = new ArrayList<>();

    public void addEvent(Event e) {
        events.add(e);
    }

    public void run() {
        while (events.size() > 0) {
            for (Event e : new ArrayList<>(events)) {
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    events.remove(e);
                }
            }
        }
    }
}

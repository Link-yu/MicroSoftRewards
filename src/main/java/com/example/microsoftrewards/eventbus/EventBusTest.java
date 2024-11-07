package com.example.microsoftrewards.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new EventListener());

        eventBus.post(1);
        eventBus.post(2);
        eventBus.post("3");
    }
}

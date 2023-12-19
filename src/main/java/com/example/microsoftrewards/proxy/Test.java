package com.example.microsoftrewards.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloService helloService = new HelloServiceImpl();
        Method sayHello = HelloService.class.getMethod("sayHello", String.class);
        Object ret = sayHello.invoke(helloService, "yulingkai");

    }
}

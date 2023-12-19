package com.example.microsoftrewards.proxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("你好：" + name);
    }
}

package com.example.microsoftrewards.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String addAccount(@RequestBody String[] userNames) throws InterruptedException {
        return null;
    }
}

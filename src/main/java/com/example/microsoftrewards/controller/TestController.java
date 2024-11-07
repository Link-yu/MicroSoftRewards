package com.example.microsoftrewards.controller;

import com.example.microsoftrewards.entity.MicrosoftAccount;
import com.example.microsoftrewards.service.IMicrosoftAccountService;
import com.example.microsoftrewards.util.ReadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class TestController {
    @Autowired
    private IMicrosoftAccountService microsoftAccountService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(String s) {
        return "测试成功, 恭喜你";
    }
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String addAccount(@RequestBody String userName) throws InterruptedException {
        MicrosoftAccount microsoftAccount = new MicrosoftAccount();
        microsoftAccount.setStatus(0);
        microsoftAccount.setUsername(userName);
        microsoftAccount.setLastScore(700);
        microsoftAccount.setPassword("yupaopao990");
        microsoftAccount.setCreateTime(LocalDateTime.now());
        microsoftAccount.setUpdateTime(LocalDateTime.now());
        microsoftAccount.setLatestScore(0);
        microsoftAccount.setId(83);

        microsoftAccountService.save(microsoftAccount);
        return "success";
    }
}

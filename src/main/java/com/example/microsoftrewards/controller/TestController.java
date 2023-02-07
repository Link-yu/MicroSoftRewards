package com.example.microsoftrewards.controller;

import com.example.microsoftrewards.entity.MicrosoftAccount;
import com.example.microsoftrewards.service.IMicrosoftAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private IMicrosoftAccountService microsoftAccountService;
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public String addAccount(@RequestBody String userName) throws InterruptedException {
//        List<String> names = Arrays.asList(userNames);
        MicrosoftAccount microsoftAccount = new MicrosoftAccount();
        microsoftAccount.setStatus(0);
        microsoftAccount.setUsername(userName);
        microsoftAccount.setLastScore(700);
        microsoftAccount.setPassword("yupaopao990");
        microsoftAccount.setCreateTime(LocalDateTime.now());
        microsoftAccount.setUpdateTime(LocalDateTime.now());
        microsoftAccount.setLatestScore(0);
        microsoftAccount.setId(83);

//        List<MicrosoftAccount> microsoftAccounts = new ArrayList<>();
//        names.forEach(name -> {
//            MicrosoftAccount microsoftAccount = new MicrosoftAccount();
//
//            microsoftAccount.setStatus(0);
//            microsoftAccount.setUsername(name);
//            microsoftAccount.setLastScore(700);
//            microsoftAccount.setPassword("yupaopao990");
//            microsoftAccount.setCreateTime(LocalDateTime.now());
//            microsoftAccount.setUpdateTime(LocalDateTime.now());
//            microsoftAccount.setLatestScore(0);
//            microsoftAccounts.add(microsoftAccount);
//        });

        microsoftAccountService.save(microsoftAccount);
        return "success";
    }
}

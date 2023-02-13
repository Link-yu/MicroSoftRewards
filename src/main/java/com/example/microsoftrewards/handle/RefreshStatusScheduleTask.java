package com.example.microsoftrewards.handle;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.microsoftrewards.entity.MicrosoftAccount;
import com.example.microsoftrewards.service.IMicrosoftAccountService;
import com.example.microsoftrewards.util.NetworkUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RefreshStatusScheduleTask {
    @Autowired
    private HandleTask handleTask;

    @Autowired
    private IMicrosoftAccountService microsoftAccountService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void refreshStatus() throws Exception {
        QueryWrapper<MicrosoftAccount> wrapper = new QueryWrapper<>();
        List<MicrosoftAccount> list = microsoftAccountService.list(wrapper);
        list.forEach(microsoftAccount -> {
            MicrosoftAccount update = new MicrosoftAccount();
            BeanUtils.copyProperties(microsoftAccount, update);
            update.setStatus(0);
            update.setFailCount(0);
            microsoftAccountService.updateById(update);
        });
        handleTask.startJob();
    }

//    @Scheduled(cron = "0 0 5 * * ?")
    public void grabPoints() throws Exception {
        System.out.println("start grabPoint.");
        if (!NetworkUtil.isConnect()) {
            handleTask.startJob();
        } else {
            System.out.println("无法访问网络,请稍后再试.");
        }
        System.out.println("end grabPoint.");
    }
}

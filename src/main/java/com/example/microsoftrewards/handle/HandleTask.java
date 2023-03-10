package com.example.microsoftrewards.handle;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.microsoftrewards.entity.MicrosoftAccount;
import com.example.microsoftrewards.service.IMicrosoftAccountService;
import com.example.microsoftrewards.util.RebootUtil;
import com.example.microsoftrewards.util.SpiderUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class HandleTask {
    private static final Logger log = LoggerFactory.getLogger(HandleTask.class);
    private final static String PREFIX_URL = "https://top.baidu.com/board?tab=";

    private final static Random random = new Random();
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private IMicrosoftAccountService microsoftAccountService;

    private static List<String> hotNewsUrls = new ArrayList<>();

    private static List<String> HOT_KEYS = new ArrayList<>();

    @PostConstruct
    public void test() throws Exception {
        log.info("start task");
        HOT_KEYS = SpiderUtil.grabMomoyuHot();
        startJob();
        log.info("end task");
    }
    public void startJob() throws Exception {
//        hotNewsUrls.addAll(Arrays.asList("realtime", "car", "movie", "novel", "teleplay", "game"));
        refreshPoint();
        sendMessage();
    }

    private String calculateScore() {
        StringBuffer failedList = new StringBuffer();
        List<MicrosoftAccount> accountList = microsoftAccountService.list();
        Integer latestScore = 0;
        Integer lastScore = 0;
        for (int i = 0; i < accountList.size(); i++) {
            MicrosoftAccount microsoftAccount = accountList.get(i);
            lastScore += microsoftAccount.getLastScore();
            latestScore += microsoftAccount.getLatestScore();
            if (microsoftAccount.getStatus() == 0) {
                failedList.append(microsoftAccount.getUsername()).append("\n");
            }
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("????????????: ").append(latestScore).append("\n");
        buffer.append("?????????????????????").append(String.valueOf(latestScore - lastScore)).append("\n");
        buffer.append("????????????").append("\n").append(failedList);
        return buffer.toString();
    }

    private void sendMessage() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(calculateScore());
        try {
            RebootUtil.sendReboot(RebootUtil.setMessage(false,buffer.toString(), Arrays.asList("13018902971")));
        } catch (Exception exception) {
            System.out.println("??????????????????");
        }
    }

    private void refreshPoint() throws Exception {
        Page<MicrosoftAccount> page = new Page<>(1, 10);
        QueryWrapper<MicrosoftAccount> wrapper = new QueryWrapper<>();
        wrapper.eq("status", 0);
        wrapper.lt("fail_count", 3);
        Page<MicrosoftAccount> pageResult = microsoftAccountService.page(page, wrapper);
        List<MicrosoftAccount> list = pageResult.getRecords();
        while (!CollectionUtils.isEmpty(list)) {
            sendTaskList(list);
            list.forEach(microsoftAccount -> {
                executeTask(microsoftAccount);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Collections.shuffle(HOT_KEYS);
            });
            Thread.sleep(30000);
            list = microsoftAccountService.page(page, wrapper).getRecords();
        }
    }

    private void sendTaskList(List<MicrosoftAccount> list) throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append("????????????:").append("\n");
        list.forEach(microsoftAccount -> {
            buffer.append(microsoftAccount.getUsername()).append("\n");
        });
        RebootUtil.sendReboot(RebootUtil.setMessage(false,buffer.toString(), Arrays.asList()));
    }
    private WebDriver getChromeDriver() {
        String chromeDriverPath = "/usr/local/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito"));
        // ??????chrome?????????
        WebDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    private WebDriver getEdgeDriver() {
        String msedgeDriverPath = "/usr/local/bin/msedgedriver";
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(Arrays.asList("--incognito"));
        // ??????edge?????????
        WebDriver driver = new EdgeDriver(edgeOptions);
        return driver;
    }

    public String executeTask(MicrosoftAccount microsoftAccount) {
        // msedgedriver.exe macOS
//        String msedgeDriverPath = "/usr/local/bin/msedgedriver";
        // msedgedriver.exe windows
        String msedgeDriverPath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
//         ?????????????????????????????????????
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(Arrays.asList("--incognito"));
        // ??????edge?????????
        WebDriver driver = new EdgeDriver();

        try {
            login(driver, microsoftAccount);
            search(driver, microsoftAccount);
            By rewardsId = By.id("id_rc");
            String value = driver.findElement(rewardsId).getText();
            if (Integer.valueOf(value) > microsoftAccount.getLatestScore()) {
                System.out.println("?????????" + microsoftAccount.getUsername() + " ????????????!");
                saveSuccessToDB(microsoftAccount, Integer.valueOf(value));
            } else {
                throw new Exception("???????????????");
            }
        } catch (Exception exception) {
            System.out.println("?????????" + microsoftAccount.getUsername()  + " ????????????!" + "?????????" + exception.getMessage());
            saveFailedToDB(microsoftAccount);
        } finally {
            driver.close();
        }
        return "success";
    }

    private void saveSuccessToDB(MicrosoftAccount microsoftAccount, Integer value) {
        microsoftAccount.setLastScore(microsoftAccount.getLatestScore());
        microsoftAccount.setLatestScore(value);
        microsoftAccount.setUpdateTime(LocalDateTime.now());
        microsoftAccount.setStatus(1);
        microsoftAccount.setFailCount(0);
        microsoftAccountService.updateById(microsoftAccount);
    }

    private void saveFailedToDB(MicrosoftAccount microsoftAccount) {
        microsoftAccount.setStatus(0);
        microsoftAccount.setFailCount(microsoftAccount.getFailCount()+1);
        microsoftAccountService.updateById(microsoftAccount);
    }

    private void login(WebDriver driver, MicrosoftAccount microsoftAccount) throws InterruptedException {
        driver.get("https://cn.bing.com/");
        Thread.sleep(6000);
        By loginInput = By.id("id_s");
        driver.findElement(loginInput).click();


        Thread.sleep(10000);
        System.out.println("??????????????? " + microsoftAccount.getUsername());
        By loginNameInput = By.name("loginfmt");
        driver.findElement(loginNameInput).sendKeys(microsoftAccount.getUsername());
        driver.findElement(loginNameInput).sendKeys(Keys.ENTER);

        Thread.sleep(10000);
        System.out.println("????????????");
        By passwordInput = By.name("passwd");
        driver.findElement(passwordInput).sendKeys(microsoftAccount.getPassword());
        driver.findElement(passwordInput).sendKeys(Keys.ENTER);


        Thread.sleep(10000);
        System.out.println("???????????????");
        By idBtnBack = By.id("idBtn_Back");
        driver.findElement(idBtnBack).click();
    }
    /**
     * ????????????
     * @param driver
     * @throws InterruptedException
     */
    private void search(WebDriver driver, MicrosoftAccount microsoftAccount) throws InterruptedException {
        int size = 15;
        if (microsoftAccount.getLevel() == 2) {
            size = 40;
        }
        Thread.sleep(2000);
        for (int i = 0; i < size; i++) {
            driver.get("https://cn.bing.com/search?q=" + HOT_KEYS.get(i));
            // ??????1????????????????????????
            Thread.sleep(   1000);
            // ???????????????????????????
//            By bingSearchInput = By.id("sb_form_q");
//            driver.findElement(bingSearchInput).clear();
//            // ???????????????????????????????????????
//            driver.findElement(bingSearchInput).sendKeys(hotNews.get(i));
//            driver.findElement(bingSearchInput).sendKeys(Keys.ENTER);
        }
        Thread.sleep(5000);
    }

    private boolean isElementPresent(WebDriver driver, String idName) {
        try {
            By loginInput = By.id(idName);
            driver.findElement(loginInput).click();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private void saveSuccessAccount(String userName) {
        BufferedWriter bufferedWriter = null;
        try {
//            String fileName = "/Users/yulingkai/File/ibuscloud/code/MicroSoftRewards/src/main/resources/templates/result.txt";
            String fileName = "E:\\Local\\MicroSoftRewards\\src\\main\\resources\\templates\\result.txt";
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(fileName, true));
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(userName);
            bufferedWriter.newLine();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

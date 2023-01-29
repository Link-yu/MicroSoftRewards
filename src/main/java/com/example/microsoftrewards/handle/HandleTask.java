package com.example.microsoftrewards.handle;

import com.example.microsoftrewards.entity.MicrosoftAccount;
import com.example.microsoftrewards.service.IMicrosoftAccountService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class HandleTask {

    private final static String PREFIX_URL = "https://top.baidu.com/board?tab=";

    private final static Random random = new Random();
    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private IMicrosoftAccountService microsoftAccountService;

    private static List<String> hotNewsUrls = new ArrayList<>();

    private static List<String> scores = new ArrayList<>();

    @PostConstruct
    private void startJob() {
        hotNewsUrls.addAll(Arrays.asList("realtime", "car", "movie", "novel", "teleplay", "game"));
        work();
        int total = 0;
        for (int i = 0;i < scores.size(); i++) {
            total+=Integer.valueOf(scores.get(0));
        }

        System.out.println("总计积分: " + total);
    }

    private void addAccount() {
        Resource res = resourceLoader.getResource("classpath:" + "/templates/" + "account.txt");
        try {
            File file = res.getFile();
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String content=null;
            while ((content = bufferedReader.readLine()) != null) {
                String userName = content;
                MicrosoftAccount microsoftAccount = new MicrosoftAccount();
                microsoftAccount.setUsername(userName);
                microsoftAccount.setCreateTime(LocalDateTime.now());
                microsoftAccount.setUpdateTime(LocalDateTime.now());
                if(userName.equals("kevinyulk@163.com")) {
                    microsoftAccount.setPassword("zhujing520");
                } else {
                    microsoftAccount.setPassword("yupaopao990");
                }
                microsoftAccountService.save(microsoftAccount);
            }
        } catch (Exception exception) {
            System.out.println("work error " + exception.getMessage());
        }
    }

    private void work() {
        List<MicrosoftAccount> list = microsoftAccountService.list();
        list.stream().filter(microsoftAccount -> microsoftAccount.getStatus() == 0)
                .collect(Collectors.toList()).forEach(microsoftAccount -> {
                    executeTask(microsoftAccount);
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

    }

    public String executeTask(MicrosoftAccount microsoftAccount) {
        // msedgedriver.exe macOS
//        String msedgeDriverPath = "/usr/local/bin/msedgedriver";
        // msedgedriver.exe windows
        String msedgeDriverPath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
        // 设置指定键对值的系统属性
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(Arrays.asList("--incognito"));
        // 打开edge浏览器
        WebDriver driver = new EdgeDriver(edgeOptions);
        // 浏览器最大化
        // driver.manage().window().maximize();

        try {
            driver.get("https://cn.bing.com/");
            Thread.sleep(5000);
            By loginInput = By.id("id_s");
            driver.findElement(loginInput).click();

            Thread.sleep(5000);
            By loginNameInput = By.name("loginfmt");
            driver.findElement(loginNameInput).sendKeys(microsoftAccount.getUsername());
            driver.findElement(loginNameInput).sendKeys(Keys.ENTER);

            Thread.sleep(3000);
            By passwordInput = By.name("passwd");
            driver.findElement(passwordInput).sendKeys(microsoftAccount.getPassword());
            driver.findElement(passwordInput).sendKeys(Keys.ENTER);

            Thread.sleep(3000);
            By idBtnBack = By.id("idSIButton9");
            driver.findElement(idBtnBack).click();

            Thread.sleep(2000);
            search(driver);
            By rewardsId = By.id("id_rc");
            String value = driver.findElement(rewardsId).getText();
            System.out.println("账号：" + microsoftAccount.getUsername() + " 执行成功!");
            saveSuccessAccount("success" + "账号: " + microsoftAccount.getUsername()  + " 执行成功,共积累 " + value + " 分");
            microsoftAccount.setLastScore(value);
            microsoftAccount.setLatestScore(value);
            microsoftAccount.setStatus(1);
            microsoftAccountService.updateById(microsoftAccount);
            scores.add(value);
        } catch (Exception exception) {
            System.out.println("账号：" + microsoftAccount.getUsername()  + " 执行失败!" + "原因是" + exception.getMessage());
            microsoftAccount.setStatus(0);
            microsoftAccountService.updateById(microsoftAccount);
            saveSuccessAccount("failed " + "账号: " + microsoftAccount.getUsername() );
        } finally {
            driver.close();
        }
        return "success";
    }

    /**
     * 搜索内容
     * @param driver
     * @throws InterruptedException
     */
    private void search(WebDriver driver) throws InterruptedException {
        List<String> hotNews = new ArrayList<>();
        String url = hotNewsUrls.get(random.nextInt(hotNewsUrls.size()));
        hotNews.addAll(SpiderUtil.grabBaiduHotNewsJson(PREFIX_URL + url));
        Thread.sleep(5000);
        for (int i = 0; i < 1; i++) {
            // 定位到必应的搜索框
            By bingSearchInput = By.id("sb_form_q");
            driver.findElement(bingSearchInput).clear();
            // 在必应的搜索框搜索二次疑问
            driver.findElement(bingSearchInput).sendKeys(hotNews.get(i));
            driver.findElement(bingSearchInput).sendKeys(Keys.ENTER);
            // 给你1秒钟预览答案时间
            Thread.sleep(   2000);
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

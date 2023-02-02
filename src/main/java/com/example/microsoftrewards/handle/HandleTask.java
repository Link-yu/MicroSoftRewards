package com.example.microsoftrewards.handle;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
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

    private static List<String> failedList = new ArrayList<>();

    @PostConstruct
    public void test() {
        startJob();
    }
    public void startJob() {
        hotNewsUrls.addAll(Arrays.asList("realtime", "car", "movie", "novel", "teleplay", "game"));
        refreshPoint();
        sendMessage();
    }

    private String calculateScore() {
        List<MicrosoftAccount> accountList = microsoftAccountService.list();
        Integer latestScore = 0;
        Integer lastScore = 0;
        for (int i = 0; i < accountList.size(); i++) {
            lastScore += accountList.get(i).getLastScore();
            latestScore += accountList.get(i).getLatestScore();
        }
        StringBuffer buffer = new StringBuffer();
        buffer.append("总计积分: ").append(latestScore).append("\n");
        buffer.append("今日新增积分：").append(String.valueOf(latestScore - lastScore)).append("\n");
        return buffer.toString();
    }

    private void sendMessage() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(calculateScore());
        buffer.append("失败列表").append("\n");
        failedList.forEach(userName -> {
            buffer.append(userName).append("\n");
        });
        try {
            RebootUtil.sendReboot(RebootUtil.setMessage(false,buffer.toString(), Arrays.asList("13018902971")));
        } catch (Exception exception) {
            System.out.println("发送消息失败");
        }
    }

    private void refreshPoint() {
        List<MicrosoftAccount> list = microsoftAccountService.list();
        list.stream().filter(microsoftAccount -> microsoftAccount.getStatus() == 0)
                .collect(Collectors.toList()).forEach(microsoftAccount -> {
                    executeTask(microsoftAccount);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
    }
    private WebDriver getChromeDriver() {
        String chromeDriverPath = "/usr/local/bin/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(Arrays.asList("--incognito"));
        // 打开chrome浏览器
        WebDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    private WebDriver getEdgeDriver() {
        String msedgeDriverPath = "/usr/local/bin/msedgedriver";
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(Arrays.asList("--incognito"));
        // 打开edge浏览器
        WebDriver driver = new EdgeDriver(edgeOptions);
        return driver;
    }

    public String executeTask(MicrosoftAccount microsoftAccount) {
        // msedgedriver.exe macOS
//        String msedgeDriverPath = "/usr/local/bin/msedgedriver";
        // msedgedriver.exe windows
        String msedgeDriverPath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
//         设置指定键对值的系统属性?
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments(Arrays.asList("--incognito"));
        // 打开edge浏览器
        WebDriver driver = new EdgeDriver();

        try {
            login(driver, microsoftAccount);
            search(driver, microsoftAccount);
            By rewardsId = By.id("id_rc");
            String value = driver.findElement(rewardsId).getText();
            System.out.println("账号：" + microsoftAccount.getUsername() + " 执行成功!");
            saveSuccessAccount("success" + "账号: " + microsoftAccount.getUsername()  + " 执行成功,共积累 " + value + " 分");
            microsoftAccount.setLastScore(microsoftAccount.getLatestScore());
            microsoftAccount.setLatestScore(Integer.valueOf(value));
            microsoftAccount.setUpdateTime(LocalDateTime.now());
            microsoftAccount.setStatus(1);
            microsoftAccountService.updateById(microsoftAccount);
            scores.add(value);
        } catch (Exception exception) {
            System.out.println("账号：" + microsoftAccount.getUsername()  + " 执行失败!" + "原因是" + exception.getMessage());
            microsoftAccount.setStatus(0);
            microsoftAccountService.updateById(microsoftAccount);
            failedList.add(microsoftAccount.getUsername());
            saveSuccessAccount("failed " + "账号: " + microsoftAccount.getUsername() );
        } finally {
            driver.close();
        }
        return "success";
    }

    private void login(WebDriver driver, MicrosoftAccount microsoftAccount) throws InterruptedException {
        driver.get("https://cn.bing.com/");
        Thread.sleep(6000);
        By loginInput = By.id("id_s");
        driver.findElement(loginInput).click();

        Thread.sleep(6000);
        By loginNameInput = By.name("loginfmt");
        driver.findElement(loginNameInput).sendKeys(microsoftAccount.getUsername());
        driver.findElement(loginNameInput).sendKeys(Keys.ENTER);

        Thread.sleep(6000);
        By passwordInput = By.name("passwd");
        driver.findElement(passwordInput).sendKeys(microsoftAccount.getPassword());
        driver.findElement(passwordInput).sendKeys(Keys.ENTER);

        Thread.sleep(6000);
        By idBtnBack = By.id("idBtn_Back");
        driver.findElement(idBtnBack).click();
    }
    /**
     * 搜索内容
     * @param driver
     * @throws InterruptedException
     */
    private void search(WebDriver driver, MicrosoftAccount microsoftAccount) throws InterruptedException {
        List<String> hotNews = new ArrayList<>();
        String url = hotNewsUrls.get(random.nextInt(hotNewsUrls.size()));
        hotNews.addAll(SpiderUtil.grabBaiduHotNewsJson(PREFIX_URL + url));
        int size = 15;
        if (microsoftAccount.getLastScore() > 500) {
            url = hotNewsUrls.get(random.nextInt(hotNewsUrls.size()));
            hotNews.addAll(SpiderUtil.grabBaiduHotNewsJson(PREFIX_URL + url));
            size = 40;
        }
        Thread.sleep(5000);
        for (int i = 0; i < size; i++) {
            driver.get("https://cn.bing.com/search?q=" + hotNews.get(i));
            // 给你1秒钟预览答案时间
            Thread.sleep(   1000);
            // 定位到必应的搜索框
//            By bingSearchInput = By.id("sb_form_q");
//            driver.findElement(bingSearchInput).clear();
//            // 在必应的搜索框搜索二次疑问
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

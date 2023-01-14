package com.example.microsoftrewards.handle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.HashMap;

@Component
public class HandleTask {
    @Autowired
    private ResourceLoader resourceLoader;

//    private final static String PASS_WORD = "yupaopao990";
//    private final static String USER_NAME = "hangzhouhuawei@hotmail.com";
    private final static String PASS_WORD = "zhujing520";
    private final static String USER_NAME = "kevinyulk@163.com";
    @PostConstruct
    public String test() throws InterruptedException, IOException {
        // msedgedriver.exe 绝对地址
        String msedgeDriverPath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
        // 设置指定键对值的系统属性
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        // 打开谷歌浏览器
        WebDriver driver = new EdgeDriver();
        // 浏览器最大化
        driver.manage().window().maximize();

        // 答案不是很明确？跳转到必应去搜索下
        driver.get("https://cn.bing.com/");
        Thread.sleep(5000);
        By loginInput = By.id("id_s");
        driver.findElement(loginInput).click();

        Thread.sleep(10000);
        By loginNameInput = By.name("loginfmt");
        driver.findElement(loginNameInput).sendKeys(USER_NAME);

        By nextButton = By.id("idSIButton9");
        driver.findElement(nextButton).click();

        Thread.sleep(3000);
        By passwordInput = By.name("passwd");
        driver.findElement(passwordInput).sendKeys(PASS_WORD);

        Thread.sleep(3000);
        driver.findElement(nextButton).click();

        Thread.sleep(3000);
        By idBtnBack = By.id("idSIButton9");
        driver.findElement(idBtnBack).click();

        search(driver);
        driver.close();
        return "success";
    }

    /**
     * 搜索内容
     * @param driver
     * @throws InterruptedException
     */
    private void search(WebDriver driver) throws InterruptedException, IOException {

        Resource res = resourceLoader.getResource("classpath:" + "/templates/" + "Key.txt");
        File file = res.getFile();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String content=null;
        while ((content = bufferedReader.readLine()) != null) {
            Thread.sleep(3000);
            // 定位到必应的搜索框
            By bingSearchInput = By.id("sb_form_q");
            driver.findElement(bingSearchInput).clear();
            // 在必应的搜索框搜索二次疑问
            driver.findElement(bingSearchInput).sendKeys(content);
            Thread.sleep(2000);
            driver.findElement(bingSearchInput).sendKeys(Keys.ENTER);
            // 给你五秒钟预览答案时间
            Thread.sleep(3000);
        }
    }
}

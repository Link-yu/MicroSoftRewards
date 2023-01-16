package com.example.microsoftrewards.handle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.concurrent.ExecutorService;

@Component
public class HandleTask {

    private final static String PASS_WORD = "yupaopao990";
    @Autowired
    private ResourceLoader resourceLoader;

    @javax.annotation.Resource(name = "threadPoolInstance")
    private ExecutorService executorService;

    @PostConstruct
    private void startJob() {
        work();
    }
    private void work() {
        Resource res = resourceLoader.getResource("classpath:" + "/templates/" + "account.txt");
        try {
            File file = res.getFile();
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(reader);
            String content=null;
            while ((content = bufferedReader.readLine()) != null) {
                String userName = content;
                if(userName.equals("kevinyulk@163.com")) {
                    executeTask(userName, "zhujing520");
                } else {
                    executeTask(userName, PASS_WORD);
                }
            }
        } catch (Exception exception) {
            System.out.println("work error " + exception.getMessage());
        }

    }

    public String executeTask(String userName, String password) {
        // msedgedriver.exe macOS
        String msedgeDriverPath = "/usr/local/bin/msedgedriver";
        // msedgedriver.exe windows
//        String msedgeDriverPath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
        // 设置指定键对值的系统属性
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        // 打开edge浏览器
        WebDriver driver = new EdgeDriver(edgeOptions);
        // 浏览器最大化
        driver.manage().window().maximize();

        try {
            // 答案不是很明确？跳转到必应去搜索下
            driver.get("https://cn.bing.com/");
            Thread.sleep(5000);
            By loginInput = By.id("id_s");
            driver.findElement(loginInput).click();

            Thread.sleep(10000);
            By loginNameInput = By.name("loginfmt");
            driver.findElement(loginNameInput).sendKeys(userName);

            By nextButton = By.id("idSIButton9");
            driver.findElement(nextButton).click();

            Thread.sleep(3000);
            By passwordInput = By.name("passwd");
            driver.findElement(passwordInput).sendKeys(password);

            Thread.sleep(3000);
            driver.findElement(nextButton).click();

            Thread.sleep(3000);
            By idBtnBack = By.id("idSIButton9");
            driver.findElement(idBtnBack).click();

            search(driver);
            System.out.println("账号：" + userName + " 执行成功!");
            saveSuccessAccount(userName + " " + "success");
        } catch (Exception exception) {
            System.out.println("账号：" + userName + " 执行失败!");
            saveSuccessAccount(userName + " " + "faild");
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
    private void search(WebDriver driver) throws InterruptedException, IOException {

        Resource res = resourceLoader.getResource("classpath:" + "/templates/" + "Key.txt");
        File file = res.getFile();
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String content=null;
        int count = 0;
        while ((content = bufferedReader.readLine()) != null) {
            Thread.sleep(3000);
            // 定位到必应的搜索框
            By bingSearchInput = By.id("sb_form_q");
            driver.findElement(bingSearchInput).clear();
            // 在必应的搜索框搜索二次疑问
            driver.findElement(bingSearchInput).sendKeys(content);
            driver.findElement(bingSearchInput).sendKeys(Keys.ENTER);
            // 给你五秒钟预览答案时间
            Thread.sleep(2000);
            count++;
            if (count == 30) {
                break;
            }
        }
        //
        By rewardsId = By.id("id_rc");
        String value = driver.findElement(rewardsId).getText();
        System.out.println(value);

        Thread.sleep(2000);
    }

    private void saveSuccessAccount(String userName) {
        BufferedWriter bufferedWriter = null;
        try {
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

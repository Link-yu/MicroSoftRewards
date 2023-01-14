package com.example.microsoftrewards.controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() throws InterruptedException {
        // msedgedriver.exe 绝对地址
        String msedgeDriverPath = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedgedriver.exe";
        // 设置指定键对值的系统属性
        System.setProperty("webdriver.edge.driver", msedgeDriverPath);
        // 打开谷歌浏览器
        WebDriver driver = new EdgeDriver();
        // 浏览器最大化
        driver.manage().window().maximize();

        // 访问百度
        driver.get("https://www.baidu.com/");
        // 定位到百度的搜索框(你们可以在百度页面打开调试模式看下搜索框的代码 <input id="kw" name="wd" class="s_ipt" value="" maxlength="255" autocomplete="off">)
        By baiduSearchInput = By.id("kw");
        // 在百度的搜索框搜索疑问
        driver.findElement(baiduSearchInput).sendKeys("鹿含宝宝到底是男的还是女的");

        // 给你五秒钟预览答案时间
        Thread.sleep(5000);

        // 答案不是很明确？跳转到必应去搜索下
        driver.get("https://cn.bing.com/");

        By loginInput = By.id("id_s");
        driver.findElement(loginInput).click();
        // 定位到必应的搜索框
//        By bingSearchInput = By.id("sb_form_q");
//        // 在必应的搜索框搜索二次疑问
//        driver.findElement(bingSearchInput).sendKeys("鹿含宝宝到底是男的还是女的");
//        Thread.sleep(5000);
//        // 定位到必应的确认搜索按钮、也就是那个放大镜
//        By bingSubmitInput = By.id("sb_form_go");
//        Thread.sleep(5000);
//        // 点击确认搜索按钮
//        driver.findElement(bingSubmitInput).click();

        // 给你五秒钟预览答案时间
        Thread.sleep(5000);
        // 总结疑问
        // .......

        // 关闭浏览器
        driver.close();
        return "success";
    }
}

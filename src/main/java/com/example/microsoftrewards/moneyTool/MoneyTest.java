package com.example.microsoftrewards.moneyTool;

/**
 * @ClassName MoneyTest
 * @Description TODO
 * @Author yulk48789
 * @Date 2024-11-05 10:58
 * @Version 1.0
 **/
public class MoneyTest {
    private final static String url = "https://pan.baidu.com/s/1Cv9LduWPUzBvXW3uv7BPhw?pwd=pavt\thttps://pan.quark.cn/s/b1af6af9cff5\thttps://www.123684.com/s/j81Fjv-xK65v";
    public static void main(String[] args) {
        String[] urls = url.split("\t");
        System.out.println("百度网盘：" + urls[0]);
        System.out.println("夸克网盘：" + urls[1]);
        System.out.println("123网盘：" + urls[2]);

        System.out.println("");
        System.out.println("123网盘无需登录，可直接下载");
    }
}

package com.example.microsoftrewards.handle;

import com.alibaba.fastjson.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取百度热搜榜
 */
public class SpiderUtil {

    /**
     * 抓取百度热点排行榜
     * @return
     */
    public static List<String> grabBaiduHotNewsJson(String url){
        List<String> list = new ArrayList<>();
        try {
            System.out.println("start grab baidu hot news");
            Document doc = Jsoup.connect(url).get();
            //标题
            Elements titles = doc.select(".c-single-text-ellipsis");
            //热搜指数
            Elements levels = doc.select(".hot-index_1Bl1a");
            for (int i = 0; i < levels.size(); i++) {
                list.add(titles.get(i).text().trim());
            }
            System.out.println(JSONArray.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

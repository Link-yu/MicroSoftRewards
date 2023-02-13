package com.example.microsoftrewards.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.microsoftrewards.moduel.Momoyu;
import com.example.microsoftrewards.moduel.MomoyuItem;
import com.example.microsoftrewards.moduel.MomoyuResponse;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<String> grabMomoyuHot() {
        List<String> list = new ArrayList<>();
        String url = "https://www.momoyu.cc/api/hot/list?type=0";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/json; charset=utf-8");
        httpGet.addHeader("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)");
        HttpResponse response = null;
        String result = null;
        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
            System.out.println(result);

            MomoyuResponse momoyuResponse = JSON.parseObject(result, MomoyuResponse.class);
            List<Momoyu> data = momoyuResponse.getData();
            List<MomoyuItem> momoyuItems = new ArrayList<>();
            data.forEach(momoyu -> {
                List<MomoyuItem> momoyuData = momoyu.getData();
                momoyuItems.addAll(momoyuData);
            });
            momoyuItems.forEach(momoyuItem -> {
                list.add(momoyuItem.getTitle());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

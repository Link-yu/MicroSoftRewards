package com.example.microsoftrewards.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.microsoftrewards.dl.DongLiangJob;
import com.example.microsoftrewards.dl.DongLiangResponse;
import com.example.microsoftrewards.moduel.Momoyu;
import com.example.microsoftrewards.moduel.MomoyuItem;
import com.example.microsoftrewards.moduel.MomoyuResponse;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 获取百度热搜榜
 */
public class SpiderUtil {
    private static final String URL = "http://123.157.130.75:9090/jdbg/GetWhrw?lx=csh";

    private static final String STATUS = "2";
    /**
     * 获取数据
     */
    public static void grabSpiderJson() {
        List<String> list = new ArrayList<>();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(URL);
        httpPost.addHeader("Content-Type", "application/json; charset=utf-8");
        httpPost.addHeader("User-Agent","Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:0.9.4)");
        httpPost.addHeader("Cookie", "ASP.NET_SessionId=g5mxz0ie0e1bq2rdgv11w5j4; .xCookie=A7FDFDF840F080D6E083589D5C352D29F3EC34290E92F30B8EF8CA1C4118F567DE083E45D3436B828C1363899426504AD849BB43695EA4A5DFE796269CBCE61DBD80EC60E40F679BC38C107773AEB0B8F42DF1E9F4F5E8D10F8D1594F4A7F6D44356A281D27C4DE85E0D8EBC2A27CE105CADBC050A683C2A9BD99AF0889B768D047ECDE9ACDB73BD839EC829D277775D");
        HttpResponse response = null;
        String result = null;
        try {
            response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
            System.out.println(result);
            DongLiangResponse dongLiangResponse = JSON.parseObject(result, DongLiangResponse.class);
            List<DongLiangJob> dongLiangList = dongLiangResponse.getData();
            if (CollectionUtils.isEmpty(dongLiangList)) {
                return;
            }
            List<DongLiangJob> taskList = dongLiangList.stream().filter(dongLiangJob -> dongLiangJob.getStatus().equals(STATUS))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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

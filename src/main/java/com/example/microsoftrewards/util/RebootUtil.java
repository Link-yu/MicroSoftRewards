package com.example.microsoftrewards.util;

import com.alibaba.fastjson.JSON;
import com.example.microsoftrewards.moduel.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RebootUtil {
    private final static String DING_URL = "https://oapi.dingtalk.com/robot/send?access_token=2d23c8242a2a8b7eadd0f7f826c3b2faa60f1969a8b423fb5d4f813d4e7f5af4";

    /**
     * 组装 发送的信息
     * Text版本
     * @param isAt       是否需要 @所有人
     * @param msgContent 要发送信息的主体
     * @param telList    要 @人的电话号码,如果@单独的几个人，就传一个空list，而不是 null
     * @return
     */
    public static String setMessage(boolean isAt, String msgContent, List<String> telList) {

        TextRebootModel model = new TextRebootModel();
        AtMobiles atMobiles = new AtMobiles();
        atMobiles.setIsAtAll(isAt);
        atMobiles.setAtMobiles(telList);

        ContentModel contentModel = new ContentModel();
        contentModel.setContent(msgContent);

        model.setAt(atMobiles);
        model.setText(contentModel);

        String toMsg = JSON.toJSONString(model);

        return toMsg;
    }

    /**
     * 组装 发送的信息
     * Markdown格式
     * @param isAt       是否需要 @所有人
     * @param title      标题
     * @param msgContent 要发送信息的主体
     * @param telList    要 @人的电话号码,如果@单独的几个人，就传一个空list，而不是 null
     * @return
     */
    public static String setMarkDown(boolean isAt, String title, String msgContent, List<String> telList) {

        MarkDownRebootModel model = new MarkDownRebootModel();
        AtMobiles atMobiles = new AtMobiles();
        atMobiles.setIsAtAll(isAt);
        atMobiles.setAtMobiles(telList);

        MarkDownModel markDownModel = new MarkDownModel();
        markDownModel.setTitle(title);
        markDownModel.setText(msgContent);

        model.setAt(atMobiles);
        model.setMarkdown(markDownModel);

        String Message = JSON.toJSONString(model);

        return Message;
    }

    /**
     * post 请求，发送给哪一个机器人
     *
     * @param reboot  机器人的token
     * @param message 发送的消息
     * @return
     */
    public static String sendPost(String reboot, String message) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(reboot);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        String textMsg = message;
        StringEntity se = new StringEntity(textMsg, "utf-8");
        httppost.setEntity(se);
        String result = null;
        HttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 选择加签方式下的加签方法
     * @param secret 密钥，机器人安全设置页面，加签一栏下面显示的SEC开头的字符串
     * @return
     */
    public static Map<String, String> dingDingSec(String secret) throws Exception {
        Long timestamp = System.currentTimeMillis();
        String stringToSign = timestamp + "\n" + secret;
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
        byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
        String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
        Map<String, String> map = new HashMap();
        map.put("sign", sign);
        map.put("timestamp", timestamp.toString());
        return map;
    }

    /**
     * 加签机器人实现，这里需要注意的是：timestamp和sign需要保持一致
     *
     * @param message 要发送的信息
     * @return
     * @throws Exception
     */
    public static String sendReboot(String message) throws Exception {
        if(!NetworkUtil.isConnect()) {
            System.out.println("网络不通");
            throw new Exception("");
        }
        Map<String,String> map=dingDingSec("SEC8d129ac10b9de9c7b1b8eaebf03702ce75b4dbd98f0cabbe87a309fe4ee25015");
        String sign = map.get("sign");
        String timestamp = map.get("timestamp");
        StringBuffer stringBuffer = new StringBuffer();
        String robotUrl =stringBuffer.append(DING_URL).append("&timestamp=").append(timestamp).append("&sign=").append(sign).toString();
        return sendPost(robotUrl, message);
    }

    /**
     * 关键字机器人：发送消息中需要有对应的关键字才能发送成功
     * @param message 封装的消息
     * @return
     * @throws Exception
     */
    public static String sendKeyReboot(String message) throws Exception {
        return sendPost("钉钉机器人的webhook", message);
    }

    public static void main(String[] args) {
        //text类型的消息：
        String text=RebootUtil.setMessage(true,"微软积分：我就是我,  是不一样的烟火", Arrays.asList("13018902971"));

        //markDown类型的消息：使用于字体加粗，超链接隐藏
        String markDown=RebootUtil.setMarkDown(true,"杭州天气","#### 杭州天气  \n > 9度，@1825718XXXX 西北风1级，空气良89，相对温度73%\n\n > ![screenshot](http://i01.lw.aliimg.com/media/lALPBbCc1ZhJGIvNAkzNBLA_1200_588.png)\n  > ###### 10点20分发布 [天气](http://www.thinkpage.cn/)",Arrays.asList(""));

        //钉钉机器人推送
        try {
            String message = RebootUtil.setMessage(false, text, Arrays.asList(""));
            RebootUtil.sendReboot(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

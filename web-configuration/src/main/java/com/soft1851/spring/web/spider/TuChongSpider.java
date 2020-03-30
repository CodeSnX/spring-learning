package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.TuChong;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TuChongSpider {
    private static final Integer SUCCESS = 200;

    public static List<TuChong> getTuChongs() {
        List<TuChong> tuChongs = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";
        //目标地址
        String url = "https://stock.tuchong.com/topic?topicId=49578";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Thread.sleep(2000);
            //创建get对象
            HttpGet httpget = new HttpGet(url);
            httpget.setHeader("User-Agent", userAgent);
            //创建context对象
            HttpClientContext context = HttpClientContext.create();
            //创建response对象
            CloseableHttpResponse response = httpClient.execute(httpget, context);
            //System.out.println(response.getStatusLine());
            int statusCode = response.getStatusLine().getStatusCode();
            //如果请求成功，则获取网络资源码
            if (statusCode == SUCCESS) {
                //获取响应对象实体，并转成utf-8字符串
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String res = EntityUtils.toString(entity);
                    //System.out.println(res);
                    Document document = Jsoup.parse(res);
                    Elements scripts = document.getElementsByTag("script");
                    String topicData = scripts.get(5).html();
                    String data = topicData.substring(topicData.indexOf("images")+8,topicData.indexOf("window.totalCount")-1);
                    JSONArray jsonArray = JSONArray.parseArray(data);
                    jsonArray.forEach(o -> {
                        JSONObject json = JSONObject.parseObject(o.toString());
                        TuChong tuChong = TuChong.builder()
                                .id(json.getInteger("imageId"))
                                .title(json.getString("title"))
                                .build();
                        tuChongs.add(tuChong);
                    });}
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return tuChongs;
    }

    public static void main(String[] args) throws Exception{
        List<TuChong> tuChongs = getTuChongs();
        tuChongs.forEach(System.out::println);
    }
}
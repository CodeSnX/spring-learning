package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Rank;
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

public class BiLiBiLiSpider {
    private static final Integer SUCCESS = 200;

    public static List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Mobile Safari/537.36";
        //目标地址
        String url = "https://www.bilibili.com/ranking?spm_id_from=333.851.b_7072696d61727950616765546162.3";
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
                    String wholeData = scripts.get(5).html();
                    String data = wholeData.substring(wholeData.indexOf("rankList")+10,wholeData.indexOf("rankRouteParams")-2);
                    JSONArray jsonArray = JSONArray.parseArray(data);
                    jsonArray.forEach(o -> {
                        JSONObject json = JSONObject.parseObject(o.toString());
                        Rank rank = Rank.builder()
                                .title(json.getString("title"))
                                .author(json.getString("author"))
                                .pic(json.getString("pic"))
                                .duration(json.getString("duration"))
                                .build();
                        ranks.add(rank);
                    });
//                    for (Element element : elements) {
//                        String num = element.child(0).text();
//                        Element contentEle = element.child(1);
//                        String title = contentEle.select(".title").text();
//                        Elements img = cofntentEle.select("lazy-img img");
//                        String cover = img.attr("src");
//                        Rank rank = Rank.builder().id(num).title(title).cover(cover).build();
//
//                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return ranks;
    }

    public static void main(String[] args) throws Exception{
        List<Rank> ranks = getRanks();
        ranks.forEach(System.out::println);
    }
}
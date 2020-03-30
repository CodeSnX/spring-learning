package com.soft1851.spring.web.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.entity.Topic;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xgp
 */
public class JueJinSpider {

    private static final Integer SUCCESS = 200;

    public static List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        //目标地址
        String url = "https://short-msg-ms.juejin.im/v1/topicList?uid=5e7f784bf265da794d4a6ac9&device_id=1585412171862&token=eyJhY2Nlc3NfdG9rZW4iOiJ6SWR3d2pRZm93dml0TUtxIiwicmVmcmVzaF90b2tlbiI6InVYM1FjRW05ZWRJQ0E2dU4iLCJ0b2tlbl90eXBlIjoibWFjIiwiZXhwaXJlX2luIjoyNTkyMDAwfQ%3D%3D&src=web&sortType=hot&page=0&pageSize=100";
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get对象
        HttpGet get = new HttpGet(url);
        //创建context对象
        HttpClientContext context = HttpClientContext.create();
        //创建response对象
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //如果请求成功，则获取网络资源码
        if (response.getStatusLine().getStatusCode() == SUCCESS){
            //获取响应对象实体，并转成utf-8字符串
            HttpEntity entity = response.getEntity();
            String res = null;
            try {
                res = EntityUtils.toString(entity,"UTF-8");
            }catch (IOException e){
                e.printStackTrace();
            }
            JSONObject jsonObject =JSONObject.parseObject(res);
            JSONArray list = jsonObject.getJSONObject("d").getJSONArray("list");
            list.forEach(o -> {
                JSONObject json =JSONObject.parseObject(o.toString());
                Topic topic = Topic.builder()
                        .id(json.getString("objectId"))
                        .topicName(json.getString("title"))
                        .topicIcon(json.getString("icon"))
                        .description(json.getString("description"))
                        .msgCount(json.getInteger("msgsCount"))
                        .followerCount(json.getInteger("followersCount"))
                        .followed(json.getBoolean("followed"))
                        .build();
                topics.add(topic);

            });
        }else {
            System.out.println("请求失败");
        }try {
            response.close();
            httpClient.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return topics;
    }
    public static void main(String[] args) throws IOException {
        System.out.println(getTopics());
    }
    }


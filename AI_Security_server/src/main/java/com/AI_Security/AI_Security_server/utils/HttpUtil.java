package com.AI_Security.AI_Security_server.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author Joe_yoy
 *
 */
public class HttpUtil {

    private static final CloseableHttpClient httpclient = HttpClients.createDefault();

    /**
     * 发送HttpGet请求
     * @param url
     * @return
     */
    public static String sendGet(String url) {

        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送HttpGet带参请求
     * @param url
     * @param header
     * @return
     */
    public static String sendGet(String url, Map<String, String> header) {
        HttpGet httpGet = new HttpGet(url);


        //设置头部
        for(Map.Entry entry:header.entrySet()){
//            System.out.println(entry.getKey()+ "###########" + entry.getValue());
            httpGet.setHeader(entry.getKey().toString(),entry.getValue().toString());
        }
//        System.out.println(jsonObject.toString());


//        HttpGet httpget = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        String result = null;
        try {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送HttpPost请求，参数为map
     * @param url
     * @param map
     * @return
     */
    public static String sendPost(String url, Map<String,String> map) {
//        JsonObject formparams = new JsonObject();
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            formparams.add(entry.getKey(), entry.getValue();
//        }
        //json 格式
//        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        JsonObject jsonObject = new JsonObject();
        for(Map.Entry entry:map.entrySet()){
//            System.out.println(entry.getKey()+ "###########" + entry.getValue());
            jsonObject.addProperty(entry.getKey().toString(),entry.getValue().toString());
        }
//        System.out.println(jsonObject.toString());
        StringEntity entity = new StringEntity(jsonObject.toString(), Consts.UTF_8);
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Content-Type", "application/json");
        httppost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity1 = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity1);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送不带参数的HttpPost请求
     * @param url
     * @return
     */
    public static String sendPost(String url) {
        HttpPost httppost = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        try {
            result = EntityUtils.toString(entity);
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void sendMapData(String urlString, Map<String, Object> data) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBody = objectMapper.writeValueAsString(data);

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        // 设置Content-Type为application/json
        connection.setRequestProperty("Content-Type", "application/json");

        // 写入JSON数据
        try (OutputStream outputStream = connection.getOutputStream()) {
            byte[] input = jsonBody.getBytes("utf-8");
            outputStream.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // 如果需要，可以读取响应数据
        // InputStream inputStream = connection.getInputStream();
        // ...

        connection.disconnect();
    }


    public static String convertMapToJson(Map<String, Object> dataMap) {
        try {
            // 创建ObjectMapper实例
            ObjectMapper objectMapper = new ObjectMapper();
            // 将Map转换为JSON字符串
            String jsonData = objectMapper.writeValueAsString(dataMap);
            return jsonData;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String sendPostRequest(String jsonData) {
        // 目标接口的URL
        String url = "http://localhost:8000/test";
        // 创建HttpClient实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpPost实例
        HttpPost httpPost = new HttpPost(url);

        try {
            // 设置请求体
            StringEntity stringEntity = new StringEntity(jsonData, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);

            // 发送POST请求
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

            // 获取响应实体
            HttpEntity entity = httpResponse.getEntity();

            // 将响应实体转换为字符串
            String response = EntityUtils.toString(entity);

            // 关闭响应
            httpResponse.close();

            return response;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                // 关闭HttpClient
                httpClient.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}


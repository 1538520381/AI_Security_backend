package com.AI_Security.AI_Security_client.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.AI_Security.AI_Security_client.service.ChatService;
import org.json.JSONObject;
import com.AI_Security.AI_Security_client.cli.OkHttpCli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {
    public static final String API_KEY = "dnkhyWQGIYw8syx4GAFw38Ts";
    public static final String SECRET_KEY = "JJkW32Qv1HRXmuD0wN2IWdG6jsbNlyID";
    public String Access_Token = null;

    @Autowired
    OkHttpCli okHttpCli;

    @Override
    public String getAccess_Token() {
        return Access_Token;
    }

    @Override
    public void obtainAccess_Token() {
        String url = "https://aip.baidubce.com/oauth/2.0/token";
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credentials");
        params.put("client_id", API_KEY);
        params.put("client_secret", SECRET_KEY);
        String a = okHttpCli.doPost(url, params);
        this.Access_Token = new JSONObject(a).getString("access_token");
    }

    @Override
    public String getMessage(String msg, String access_Token) {
        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions";

        HashMap<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", msg);

        ArrayList<HashMap> messages = new ArrayList<>();
        messages.add(message);

        HashMap<String, Object> requestBody = new HashMap<>();
        requestBody.put("messages", messages);

        String response = HttpUtil.post(url + "?access_token=" + access_Token, JSONUtil.toJsonStr(requestBody));

        System.out.println(response);
        return new JSONObject(response).getString("result");
//        System.out.println("msg:" + msg);
//        String url = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions?access_token=" + access_Token;
//        String json = "{\"messages\":[{\"role\":\"user\",\"content\":\"" + msg + "\"}]}";
//        String message = okHttpCli.doPostJson(url, json);
//        System.out.println(message);
//        return new JSONObject(message).getString("result");
    }
}

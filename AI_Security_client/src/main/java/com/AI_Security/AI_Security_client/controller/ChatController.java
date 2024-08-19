package com.AI_Security.AI_Security_client.controller;

import com.AI_Security.AI_Security_client.entity.result.R;
import com.AI_Security.AI_Security_client.service.ChatService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@CrossOrigin
public class ChatController {
    @Autowired
    private ChatService chatService;
//    @Resource
//    private ErnieBotClient ernieBotClient;


    @PostMapping("/message")
    @ResponseBody
    public R chat(@RequestBody String object) {
        long start_time = 0;
        JSONObject parse = JSONObject.parseObject(object);
        String message = parse.getString("message");
        long now_time = System.currentTimeMillis();
        if (chatService.getAccess_Token() == null) {
            chatService.obtainAccess_Token();
        }
        if ((now_time - start_time) / 60000 > 10) {
            chatService.obtainAccess_Token();
        }
        String reply = chatService.getMessage(message, chatService.getAccess_Token());
        return R.success().put("reply", reply);
    }

//    @PostMapping("/chat")
//    public BaseResponse<String> chatSingle(String msg) {
//        ChatResponse response = ernieBotClient.chatSingle(msg);
//        return BaseResponse.success(response.getResult());
//    }
}

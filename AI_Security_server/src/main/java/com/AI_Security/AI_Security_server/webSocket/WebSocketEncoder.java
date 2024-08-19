package com.AI_Security.AI_Security_server.webSocket;


import com.alibaba.fastjson.JSONObject;

import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import java.util.HashMap;

/**
 * @author Persolute
 * @version 1.0
 * @description WebSocket Encoder
 * @email 1538520381@qq.com
 * @date 2024/04/28 15:41
 */
public class WebSocketEncoder implements Encoder.Text<Object> {

    @Override
    public String encode(Object object) {
        if (object instanceof HashMap) {
            return JSONObject.toJSONString(object);
        } else if (object instanceof String) {
            return object.toString();
        } else {
            return object.toString();
        }
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}

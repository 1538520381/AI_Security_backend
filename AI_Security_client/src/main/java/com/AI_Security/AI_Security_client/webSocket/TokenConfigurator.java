package com.AI_Security.AI_Security_client.webSocket;

import javax.websocket.ClientEndpointConfig;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Persolute
 * @version 1.0
 * @description 与服务端WebSocket连接携带token
 * @email 1538520381@qq.com
 * @date 2024/04/30 16:08
 */
public class TokenConfigurator extends ClientEndpointConfig.Configurator {
    private final String token;

    public TokenConfigurator(String token) {
        this.token = token;
    }

    public void beforeRequest(Map<String, List<String>> headers) {
        super.beforeRequest(headers);
        headers.put("token", Collections.singletonList(token));
    }
}

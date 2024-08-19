package com.AI_Security.AI_Security_client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.List;
import java.util.Map;

/**
 * @author Persolute
 * @version 1.0
 * @description WebSocket Config
 * @email 1538520381@qq.com
 * @date 2024/04/28 11:39
 */
@Configuration
public class WebSocketConfig extends ServerEndpointConfig.Configurator {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Override
    public void modifyHandshake(ServerEndpointConfig serverEndpointConfig, HandshakeRequest request, HandshakeResponse response) {
        final Map<String, Object> userProperties = serverEndpointConfig.getUserProperties();
        Map<String, List<String>> headers = request.getHeaders();
        List<String> protocol = headers.get("token");
        if (protocol != null) {
            userProperties.put("token", protocol.get(0));
        }
    }

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
        return super.getEndpointInstance(clazz);
    }
}

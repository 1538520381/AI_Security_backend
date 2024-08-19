package com.AI_Security.AI_Security_server.webSocket;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.AI_Security.AI_Security_server.config.WebSocketConfig;
import com.AI_Security.AI_Security_server.exception.CustomerException;
import com.AI_Security.AI_Security_server.grpc.gRPCServer;
import com.AI_Security.AI_Security_server.utils.JwtUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Persolute
 * @version 1.0
 * @description WebSocket Server
 * @email 1538520381@qq.com
 * @date 2024/04/30 14:34
 */
@Component
@ServerEndpoint(value = "/webSocket/{connectionId}", encoders = WebSocketEncoder.class, configurator = WebSocketConfig.class)
public class WSServer {
    static Log log = LogFactory.get(WSServer.class);
    private static int onlineCount = 0;
    public static ConcurrentHashMap<String, Session> webSocketMap = new ConcurrentHashMap<>();
    private Session session;
    private String token;

    /*
     * @author Persolute 170.125
     * @version 1.0
     * @description WebSocket链接成功建立
     * @email 1538520381@qq.com
     * @date 2024/4/30 下午2:42
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("connectionId") Long connectionId) {
        session.setMaxTextMessageBufferSize(100 * 1024 * 1024);
        session.setMaxBinaryMessageBufferSize(100 * 1024 * 1024);
        this.session = session;
        this.token = getHeader(session, "token");
        if (!webSocketMap.containsKey(this.token)) {
            addOnlineCount();
        }
        webSocketMap.put(this.token, session);
//        log.info("服务端server：用户{}连接成功，当前在线人数为：{}", this.token, onlineCount);
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description
     * @email 1538520381@qq.com
     * @date 2024/4/30 下午2:47
     */
    @OnClose
    public void onClose() {
        if (webSocketMap.containsKey(token)) {
            webSocketMap.remove(token);
            subOnlineCount();
        }
//        log.info("服务端server：用户{}关闭连接，当前在线人数：{}", token, getOnlineCount());
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description WebSocket链接异常
     * @email 1538520381@qq.com
     * @date 2024/4/30 下午3:30
     */
    @OnError
    public void onError(Throwable error) {
        if (webSocketMap.remove(token) != null) {
            subOnlineCount();
        }
//        log.error("服务端server：与客户端后端WebSocket链接出现异常：{}", error.getMessage());
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 接收客户端后端信息
     * @email 1538520381@qq.com
     * @date 2024/4/30 下午3:31
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        try {
            if (message.startsWith("train:")) {
                String json = message.substring("train:".length());
                gRPCServer.train(getHeader(session, "token"), json);
            }
//            log.info("服务端server：用户{}发送了信息：{}", token, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 发送文本信息
     * @email 1538520381@qq.com
     * @date 2024/5/28 下午12:04
     */
    public static void sendMessage(Session session, String message) {
        try {
            session.getAsyncRemote().sendText(message);
//            log.info("服务端server：向客户端前端发送了信息：{}", message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendMessageAll(String message) {
        for (Session session : webSocketMap.values()) {
            sendMessage(session, message);
        }
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 获取在线人数
     * @email 1538520381@qq.com
     * @date 2024/4/30 下午2:47
     */
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 在线人数加1
     * @email 1538520381@qq.com
     * @date 2024/4/30 下午2:48
     */
    public static synchronized void addOnlineCount() {
        onlineCount++;
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 在线人数减1
     * @email 1538520381@qq.com
     * @date 2024/4/30 下午2:48
     */
    public static synchronized void subOnlineCount() {
        onlineCount--;
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 获取请求头
     * @email 1538520381@qq.com
     * @date 2024/5/5 下午2:49
     */
    private String getHeader(Session session, String headerName) {
        String header = (String) session.getUserProperties().get(headerName);
        if (StringUtils.isBlank(header)) {
            try {
                session.close();
            } catch (IOException e) {
                throw new CustomerException("请求头" + headerName + "不存在");
            }
        }
        return header;
    }
}

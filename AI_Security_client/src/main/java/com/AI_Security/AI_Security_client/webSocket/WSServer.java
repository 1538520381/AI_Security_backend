package com.AI_Security.AI_Security_client.webSocket;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.AI_Security.AI_Security_client.config.WebSocketConfig;
import com.AI_Security.AI_Security_client.entity.po.Connection;
import com.AI_Security.AI_Security_client.exception.CustomerException;
import com.AI_Security.AI_Security_client.service.ConnectionService;
import com.AI_Security.AI_Security_client.utils.JwtUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import javax.xml.ws.handler.MessageContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Persolute
 * @version 1.0
 * @description WebSocket Server
 * @email 1538520381@qq.com
 * @date 2024/04/28 11:43
 */
@Component
@ServerEndpoint(value = "/webSocket/{token}/{ip}/{name}/{department}/{userId}", encoders = WebSocketEncoder.class, configurator = WebSocketConfig.class)
public class WSServer {
    static Log log = LogFactory.get(WSServer.class);
    private Session session;
    private String token;
    public Long userId;
    private Connection connection;
    public static WSClient wsClient;

    private static ConnectionService connectionService;

    @Autowired
    private void setConnectionService(ConnectionService connectionService) {
        WSServer.connectionService = connectionService;
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description WebSocket链接成功建立
     * @email 1538520381@qq.com
     * @date 2024/4/28 下午1:59
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token, @PathParam("ip") String ip, @PathParam("name") String name, @PathParam("department") String department, @PathParam("userId") Long userId) {
        try {
            this.session = session;
            this.token = token;
            try {
                this.userId = Long.parseLong(token);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(token);
                this.userId = userId;
                System.out.println(this.userId);
            }
            connection = new Connection();
            connection.setUserId(this.userId);
            connection.setUserIp(userId == 1 ? "172.20.10.9" : "172.20.10.2");
            connection.setUserName(name);
            connection.setDepartment(department);
            connection.setIp(ip);
            connection.setConfirm(0);
            connection.setDeleted(false);
            connectionService.save(connection);

            Map<String, String> httpHeaders = new HashMap<>();
            httpHeaders.put("token", this.token);

            wsClient = new WSClient(new URI("ws://" + ip + ":9000/webSocket" + "/" + connection.getId()), httpHeaders, this);
            wsClient.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        log.info("客户端server：用户{}已建立连接", token);
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description WebSocket链接关闭
     * @email 1538520381@qq.com
     * @date 2024/4/28 下午2:01
     */
    @OnClose
    public void onClose() {
        connection.setDeleted(true);
        connectionService.updateById(connection);
//        log.info("客户端server：用户{}已断开连接", token);
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description WebSocket链接异常
     * @email 1538520381@qq.com
     * @date 2024/4/28 下午2:02
     */
    @OnError
    public void onError(Throwable error) {
//        log.error("客户端server：与客户端前端WebSocket连接出现异常：{}", error.getMessage());
        error.printStackTrace();
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 接收客户端前端信息
     * @email 1538520381@qq.com
     * @date 2024/4/28 下午2:11
     */
    @OnMessage
    public void onMessage(String message) {
//        log.info("客户端server：用户{}收到了信息", token);
        if (message.startsWith("1:")) {
            sendMessage(message.substring(2));
        } else if (message.startsWith("2:")) {
            wsClient.send(message.substring(2));
        }
    }

    /*
     * @author Persolute
     * @version 1.0
     * @description 发送文本数据
     * @email 1538520381@qq.com
     * @date 2024/4/28 下午4:15
     */
    public void sendMessage(String message) {
        session.getAsyncRemote().sendText(message);
//        log.info("客户端server：向客户端前端发送了信息");
    }

    public void close() {
        try {
//            session.close();
//            wsClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

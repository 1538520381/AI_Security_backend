package com.AI_Security.AI_Security_client.webSocket;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.AI_Security.AI_Security_client.grpc.gRPCServer;
import com.AI_Security.AI_Security_client.grpc2.gRPCServer2;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.Map;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/05/28 11:41
 */
public class WSClient extends WebSocketClient {
    static Log log = LogFactory.get(WSClient.class);
    private WSServer serverEndpoint;

    public WSClient(URI serverUri, Map<String, String> httpHeaders, WSServer serverEndpoint) {
        super(serverUri, httpHeaders);
        this.serverEndpoint = serverEndpoint;
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
//        log.info("客户端client：服务端与客户端后端已建立连接");
    }

    @Override
    public void onMessage(String s) {
        try {
            if (s.startsWith("connect:")) {
                serverEndpoint.sendMessage(s);
            } else if (s.startsWith("trainInit:")) {
                if (serverEndpoint.userId == 1) {
                    gRPCServer2.trainInit(s.substring("trainInit:".length()), serverEndpoint.userId);
                } else {
                    gRPCServer.trainInit(s.substring("trainInit:".length()), serverEndpoint.userId);
                }
            } else if (s.startsWith("train:")) {
                if (serverEndpoint.userId == 1) {
                    gRPCServer2.train(s.substring("train:".length()), serverEndpoint.userId);
                } else {
                    gRPCServer.train(s.substring("train:".length()), serverEndpoint.userId);
                }
            } else if (s.startsWith("close:")) {
                serverEndpoint.close();
            }
//            log.info("客户端client：服务端后端发送了信息：{}", s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        serverEndpoint.close();
//        log.info("客户端client：服务端与客户端后端已断开连接");
    }

    @Override
    public void onError(Exception e) {
//        log.info("客户端client：服务端与客户端后端连接出现异常");
        e.printStackTrace();
    }
}

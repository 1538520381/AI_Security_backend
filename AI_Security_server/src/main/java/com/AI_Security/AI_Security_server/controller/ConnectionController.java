package com.AI_Security.AI_Security_server.controller;

import com.AI_Security.AI_Security_server.entity.po.Connection;
import com.AI_Security.AI_Security_server.entity.result.R;
import com.AI_Security.AI_Security_server.service.ConnectionService;
import com.AI_Security.AI_Security_server.webSocket.WSServer;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/02 13:23
 */
@RestController
@RequestMapping("/connection")
public class ConnectionController {
    @Autowired
    private ConnectionService connectionService;

    @GetMapping()
    private R getAllConnections() {
        return R.success().put("connections", connectionService.list(new LambdaQueryWrapper<Connection>().orderByDesc(Connection::getCreateTime)));
    }

    @GetMapping("/getUnconfirm")
    private R getConnection() {
        return R.success().put("connections", connectionService.list(new LambdaQueryWrapper<Connection>().eq(Connection::getDeleted, false).eq(Connection::getConfirm, 0)));
    }

    @GetMapping("/getSuccess")
    private R getSuccess() {
        return R.success().put("connections", connectionService.list(new LambdaQueryWrapper<Connection>().eq(Connection::getDeleted, false).eq(Connection::getConfirm, 1)));
    }

    @PutMapping("/confirm")
    private R updateConnection(@RequestBody Connection connection) {
        if (connection.getConfirm() == 1) {
            WSServer.sendMessage(WSServer.webSocketMap.get(connection.getUserId().toString()), "connect:success");
        } else {
            WSServer.sendMessage(WSServer.webSocketMap.get(connection.getUserId().toString()), "connect:fail");
        }
        connectionService.updateById(connection);
        return R.success();
    }

    @DeleteMapping("/delete")
    private R deleteConnection(@RequestBody Connection connection) {
        WSServer.sendMessage(WSServer.webSocketMap.get(connection.getUserId().toString()), "close:服务端断开了连接");
        connectionService.updateById(connection);
        return R.success();
    }

    @GetMapping("/getByUserIdAndTime")
    public R getByUserIdAndTime(@RequestParam("userId") Long userId, @RequestParam("time") String time) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LambdaQueryWrapper<Connection> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Connection::getUserId, userId);
        lambdaQueryWrapper.lt(Connection::getCreateTime, LocalDateTime.parse(time, dateTimeFormatter));
        lambdaQueryWrapper.orderByDesc(Connection::getCreateTime);
        List<Connection> connections = connectionService.list(lambdaQueryWrapper);
        if (connections.isEmpty()) {
            return R.success().put("connection", null);
        } else {
            return R.success().put("connection", connections.get(0));
        }
    }
}

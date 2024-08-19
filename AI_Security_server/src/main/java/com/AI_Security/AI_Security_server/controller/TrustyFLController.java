package com.AI_Security.AI_Security_server.controller;

import com.AI_Security.AI_Security_server.grpc.gRPCServer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Persolute
 * @version 1.0
 * @description Trusty Controller
 * @email 1538520381@qq.com
 * @date 2024/05/28 15:26
 */
@RestController
@RequestMapping("/trustyFL")
public class TrustyFLController {
    @PostMapping("/train")
    public void train(Integer round) {
//        gRPCServer.trainInit(round);
    }
}

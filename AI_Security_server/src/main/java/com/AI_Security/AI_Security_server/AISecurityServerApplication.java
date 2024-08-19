package com.AI_Security.AI_Security_server;

import com.AI_Security.AI_Security_server.grpc.gRPCServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Persolute
 * @version 1.0
 * @description 服务端启动类
 * @email 1538520381@qq.com
 * @date 2024/04/28 17:00
 */
@SpringBootApplication
public class AISecurityServerApplication {
    @Bean
    public gRPCServer AIClient() {
//        return new gRPCServer("172.20.10.5", 8011);
        return new gRPCServer("172.20.10.2", 8011);
    }

    public static void main(String[] args) {
        SpringApplication.run(AISecurityServerApplication.class, args);
    }
}

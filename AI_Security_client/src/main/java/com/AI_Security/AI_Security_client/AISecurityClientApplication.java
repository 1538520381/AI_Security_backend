package com.AI_Security.AI_Security_client;

import com.AI_Security.AI_Security_client.grpc.gRPCServer;
import com.AI_Security.AI_Security_client.grpc1.gRPCServer1;
import com.AI_Security.AI_Security_client.grpc2.gRPCServer2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Persolute
 * @version 1.0
 * @description 客户端启动类
 * @email 1538520381@qq.com
 * @date 2024/04/28 11:28
 */
@SpringBootApplication
public class AISecurityClientApplication {
    @Bean
    public gRPCServer gRPCServer() {
//        return new gRPCServer("172.20.10.2", 50051);
        return new gRPCServer("172.20.10.10", 50051);
    }

    @Bean
    public gRPCServer1 gRPCServer1() {
//        return new gRPCServer1("172.20.10.2", 8010);
        return new gRPCServer1("172.20.10.10", 8010);
    }

    @Bean
    public gRPCServer2 gRPCServer2() {
//        return new gRPCServer2("172.20.10.5", 50051);
        return new gRPCServer2("172.20.10.2", 50051);
    }
//
//    @Bean
//    public gRPCServer1 gRPCServer3() {
//        return new gRPCServer1("192.168.235.125", 8010);
//    }

    public static void main(String[] args) {
        SpringApplication.run(AISecurityClientApplication.class, args);
    }
}

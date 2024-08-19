# README

### 项目介绍

本项目为基于增量联邦学习的流量攻击检测系统的后端部分，实现了联邦的加入与通讯，与前端的交互，与算法模型的通讯与调用等功能

### 环境依赖

+ JDK：1.8.0
+ Maven：3.6.1
+ MySQL：5.7.44

### 目录结构

    ├── AI_Security_client // 客户端后端
    
    │   ├── src // 源代码
    
    │       ├── main
    
    │           ├── java
    
    |				├── com.AI_Security.AI_Security_client
    
    |					├── common // 通用类
    
    |					├── config // 配置类
    
    |					├── controller // 控制层
    
    |					├── entity // 实体类
    
    |					├── exception // 异常类
    
    |					├── grpc // gRPC
    
    |					├── utils // 工具类
    
    |					├── webSocket // WebSocket
    
    |					└── AISecurityClientApplication	// 客户端启动入口文件
    
    ├── AI_Security_server	// 服务端后端
    
    │   ├── src     // 源代码
    
    │       ├── main
    
    │           ├── java
    
    |				├── com.AI_Security.AI_Security_server
    
    |					├── common // 通用类
    
    |					├── config // 配置类
    
    |					├── controller // 控制层
    
    |					├── entity // 实体类
    
    |					├── exception // 异常类
    
    |					├── filter // 过滤器
    
    |					├── grpc // gRPC
    
    |					├── handler // 处理器
    
    |					├── mapper // 持久层
    
    |					├── service // 业务层
    
    |					├── utils // 工具类
    
    |					├── webSocket // WebSocket
    
    |					└── AISecurityServerApplication	// 服务端启动入口文件
    
    └── README.md // 帮助文档


package com.AI_Security.AI_Security_server.service.impl;

import com.AI_Security.AI_Security_server.entity.po.Connection;
import com.AI_Security.AI_Security_server.mapper.ConnectionMapper;
import com.AI_Security.AI_Security_server.service.ConnectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/02 12:48
 */
@Service
public class ConnectionServiceImpl extends ServiceImpl<ConnectionMapper, Connection> implements ConnectionService {
}

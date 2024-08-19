package com.AI_Security.AI_Security_client.service;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/01 15:10
 */
public interface ChatService {
    String getAccess_Token();

    void obtainAccess_Token();

    String getMessage(String msg, String access_Token);
}

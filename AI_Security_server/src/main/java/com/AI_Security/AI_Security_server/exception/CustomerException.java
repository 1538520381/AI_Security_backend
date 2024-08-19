package com.AI_Security.AI_Security_server.exception;

/**
 * @author Persolute
 * @version 1.0
 * @description 自定义异常类
 * @email 1538520381@qq.com
 * @date 2024/04/29 12:03
 */
public class CustomerException extends RuntimeException {
    public CustomerException(String message) {
        super(message);
    }
}

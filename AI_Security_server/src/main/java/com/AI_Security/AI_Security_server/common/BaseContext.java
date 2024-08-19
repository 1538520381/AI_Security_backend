package com.AI_Security.AI_Security_server.common;

/**
 * @author Persolute
 * @version 1.0
 * @description 当前线程用户主键存取
 * @email 1538520381@qq.com
 * @date 2024/04/29 12:18
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}

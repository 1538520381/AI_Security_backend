package com.AI_Security.AI_Security_client.common;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Persolute
 * @version 1.0
 * @description 手动获取Bean
 * @email 1538520381@qq.com
 * @date 2024/04/30 15:50
 */
public class ApplicationContextUtil {
    public static ConfigurableApplicationContext context;

    public static Object getBean(String name) {
        if (null == context) {
            return null;
        }
        return context.getBean(name);
    }
}

package com.AI_Security.AI_Security_server.handler;

import com.AI_Security.AI_Security_server.common.BaseContext;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author Persolute
 * @version 1.0
 * @description 公共字段自动填充
 * @email 1538520381@qq.com
 * @date 2024/04/29 12:14
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasGetter("createTime")) {
            metaObject.setValue("createTime", LocalDateTime.now());
        }
        if (metaObject.hasGetter("updateTime")) {
            metaObject.setValue("updateTime", LocalDateTime.now());
        }
        if (metaObject.hasGetter("createUser")) {
            metaObject.setValue("createUser", BaseContext.getCurrentId());
        }
        if (metaObject.hasGetter("updateUser")) {
            metaObject.setValue("updateUser", BaseContext.getCurrentId());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasGetter("updateTime")) {
            metaObject.setValue("updateTime", LocalDateTime.now());
        }
        if (metaObject.hasGetter("updateUser")) {
            metaObject.setValue("updateUser", BaseContext.getCurrentId());
        }
    }
}

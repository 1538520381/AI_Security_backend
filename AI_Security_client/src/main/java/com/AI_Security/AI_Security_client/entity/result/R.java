package com.AI_Security.AI_Security_client.entity.result;

import cn.hutool.http.HttpStatus;

import java.util.HashMap;

/**
 * @author Persolute
 * @version 1.0
 * @description 全局通用返回类
 * @email 1538520381@qq.com
 * @date 2024/04/28 14:13
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public static R success() {
        return success("success");
    }

    public static R success(String msg) {
        R r = new R();
        r.put("code", 200);
        r.put("msg", msg);
        return r;
    }

    public static R error() {
        return error("error");
    }

    public static R error(String msg) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}

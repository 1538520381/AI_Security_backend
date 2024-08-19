package com.AI_Security.AI_Security_server.entity.vo;

import lombok.Data;

/**
 * @author Persolute
 * @version 1.0
 * @description 登录VO类
 * @email 1538520381@qq.com
 * @date 2024/04/29 13:25
 */
@Data
public class LoginVO {
    // 手机号
    private String phone;

    // 密码
    private String password;

    // 通用唯一标识码
    private String uuid;

    // 验证码
    private String captcha;

    // 类型
    private Integer type;
}

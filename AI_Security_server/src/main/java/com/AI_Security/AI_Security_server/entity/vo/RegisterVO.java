package com.AI_Security.AI_Security_server.entity.vo;

import lombok.Data;

/**
 * @author Persolute
 * @version 1.0
 * @description 注册VO类
 * @email 1538520381@qq.com
 * @date 2024/04/29 21:07
 */
@Data
public class RegisterVO {
    // 手机号
    private String phone;

    // 密码
    private String password;

    // 昵称
    private String nickName;

    // 头像
    private String avatar;

    // 通用唯一标识码
    private String uuid;

    // 验证码
    private String captcha;

    // 类型(0：普通用户;1：管理员)
    private Integer type;
}

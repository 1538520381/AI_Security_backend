package com.AI_Security.AI_Security_server.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Persolute
 * @version 1.0
 * @description 用户
 * @email 1538520381@qq.com
 * @date 2024/04/28 19:55
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 用户名
    private String phone;

    // 密码
    private String password;

    // 昵称
    private String nickName;

    // 头像
    private String avatar;

    // 类型(0：普通用户;1：管理员)
    private Integer type;

    // 账号状态(0：正常;1：启用)
    private Integer status;

    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 删除标识
    private Boolean isDeleted;
}

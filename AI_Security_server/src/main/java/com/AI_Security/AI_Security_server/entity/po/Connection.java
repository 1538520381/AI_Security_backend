package com.AI_Security.AI_Security_server.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/01 16:44
 */
@Data
public class Connection implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 服务端用户id
    private Long userId;

    // 客户端ip
    private String userIp;

    // 客户端名称
    private String userName;

    // 客户端部门
    private String department;

    // 服务端ip
    private String ip;

    // 确认
    private Integer confirm;

    // 删除
    private Boolean deleted;

    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

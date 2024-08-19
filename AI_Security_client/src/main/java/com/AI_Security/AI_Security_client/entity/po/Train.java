package com.AI_Security.AI_Security_client.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Persolute
 * @version 1.0
 * @description 训练
 * @email 1538520381@qq.com
 * @date 2024/07/31 16:29
 */
@Data
public class Train implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    private String id;

    // 用户主键
    private String userId;

    // 数据集名称
    private String dataName;

    // 数据地址
    private String dataUrl;

    // 预处理数据
    private String preprocessData;

    // 平台数据分析
    private String dataAnalysis;

    // 方法
    private String method;

    // 当前训练流程训练出来的model的url
    private String modelUrl;

    // 当前训练流程训练的结果
    private String result;

    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

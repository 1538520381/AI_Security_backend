package com.AI_Security.AI_Security_client.entity.po;

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
 * @date 2024/08/02 16:19
 */
@Data
public class Polymerization implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 方法
    private String methodsId;

    // 总轮次
    private Integer round;

    // 准确度
    private Double accuracy;

    // 开始时间
    private LocalDateTime startTime;

    // 结束时间
    private LocalDateTime endTime;

    // 创建时间
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

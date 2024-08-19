package com.AI_Security.AI_Security_client.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/02 16:22
 */
@Data
public class PolymerizationUser implements Serializable {
    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 聚合主键
    private Long polymerizationId;

    // 用户主键
    private Long userId;

    // 轮次
    private Integer round;

    // 开始时间
    private LocalDateTime startTime;

    // 结束时间
    private LocalDateTime endTime;
}

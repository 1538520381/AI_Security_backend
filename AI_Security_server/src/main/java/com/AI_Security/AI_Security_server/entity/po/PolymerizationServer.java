package com.AI_Security.AI_Security_server.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/04 12:59
 */
@Data
public class PolymerizationServer implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long polymerizationId;

    private Integer round;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}

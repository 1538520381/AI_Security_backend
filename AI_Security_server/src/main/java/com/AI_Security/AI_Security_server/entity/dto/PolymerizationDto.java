package com.AI_Security.AI_Security_server.entity.dto;

import com.AI_Security.AI_Security_server.entity.po.Polymerization;
import com.AI_Security.AI_Security_server.entity.po.PolymerizationServer;
import com.AI_Security.AI_Security_server.entity.po.PolymerizationUser;
import lombok.Data;

import java.util.List;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/02 16:36
 */
@Data
public class PolymerizationDto extends Polymerization {
    private List<PolymerizationUser> polymerizationUsers;
    private List<PolymerizationServer> polymerizationServers;
}

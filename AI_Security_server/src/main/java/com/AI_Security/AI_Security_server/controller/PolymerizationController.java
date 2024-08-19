package com.AI_Security.AI_Security_server.controller;

import com.AI_Security.AI_Security_server.entity.dto.PolymerizationDto;
import com.AI_Security.AI_Security_server.entity.po.Polymerization;
import com.AI_Security.AI_Security_server.entity.po.PolymerizationServer;
import com.AI_Security.AI_Security_server.entity.po.PolymerizationUser;
import com.AI_Security.AI_Security_server.entity.result.R;
import com.AI_Security.AI_Security_server.grpc.gRPCServer;
import com.AI_Security.AI_Security_server.service.PolymerizationServerService;
import com.AI_Security.AI_Security_server.service.PolymerizationService;
import com.AI_Security.AI_Security_server.service.PolymerizationUserService;
import com.AI_Security.AI_Security_server.webSocket.WSServer;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/02 16:34
 */
@RestController
@RequestMapping("/polymerization")
public class PolymerizationController {
    @Autowired
    private PolymerizationService polymerizationService;
    @Autowired
    private PolymerizationUserService polymerizationUserService;
    @Autowired
    private PolymerizationServerService polymerizationServerService;

    @PostMapping("/train")
    public R train(@RequestBody PolymerizationDto polymerizationDTO) {
        Polymerization polymerization = new PolymerizationDto();
        BeanUtils.copyProperties(polymerizationDTO, polymerization);
        polymerizationService.save(polymerization);
        List<Long> userIds = new ArrayList<>();
        for (PolymerizationUser polymerizationUser : polymerizationDTO.getPolymerizationUsers()) {
            WSServer.sendMessage(WSServer.webSocketMap.get(polymerizationUser.getUserId().toString()), "connect:" + polymerizationDTO.getMethodsId() + "," + polymerization.getRound());
            userIds.add(polymerizationUser.getUserId());
        }
        gRPCServer.trainInit(polymerizationDTO.getRound(), polymerization.getId(), userIds);
        return R.success();
    }

    @GetMapping
    public R get() {
        List<Polymerization> polymerizations = polymerizationService.list();
        List<PolymerizationDto> polymerizationDtos = new ArrayList<>();
        for (Polymerization polymerization : polymerizations) {
            PolymerizationDto polymerizationDto = new PolymerizationDto();
            BeanUtils.copyProperties(polymerization, polymerizationDto);
            List<PolymerizationUser> polymerizationUsers = polymerizationUserService.list(new LambdaQueryWrapper<PolymerizationUser>().eq(PolymerizationUser::getPolymerizationId, polymerization.getId()).orderByDesc(PolymerizationUser::getEndTime));
            List<PolymerizationServer> polymerizationServers = polymerizationServerService.list(new LambdaQueryWrapper<PolymerizationServer>().eq(PolymerizationServer::getPolymerizationId, polymerization.getId()).orderByDesc(PolymerizationServer::getEndTime));
            polymerizationDto.setPolymerizationUsers(polymerizationUsers);
            polymerizationDto.setPolymerizationServers(polymerizationServers);
            polymerizationDtos.add(polymerizationDto);
        }
        polymerizationDtos.sort((o1, o2) -> o2.getCreateTime().compareTo(o1.getCreateTime()));
        return R.success().put("polymerizationDtos", polymerizationDtos);
    }

    @GetMapping("/result")
    public R getResult() throws IOException {
        return R.success().put("result", gRPCServer.result);
    }
}

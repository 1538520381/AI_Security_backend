package com.AI_Security.AI_Security_server.grpc;

import com.AI_Security.AI_Security_server.entity.po.Polymerization;
import com.AI_Security.AI_Security_server.entity.po.PolymerizationServer;
import com.AI_Security.AI_Security_server.service.PolymerizationServerService;
import com.AI_Security.AI_Security_server.service.PolymerizationService;
import com.AI_Security.AI_Security_server.webSocket.WSServer;
import com.alibaba.fastjson.JSON;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.midi.Patch;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Persolute
 * @version 1.0
 * @description grpc Service
 * @email 1538520381@qq.com
 * @date 2024/05/28 15:41
 */
public class gRPCServer {
    private static PolymerizationService polymerizationService;
    private static PolymerizationServerService polymerizationServerService;

    @Autowired
    public void setPolymerizationService(PolymerizationService polymerizationService) {
        gRPCServer.polymerizationService = polymerizationService;
    }

    @Autowired
    public void setPolymerizationServerService(PolymerizationServerService polymerizationServerService) {
        gRPCServer.polymerizationServerService = polymerizationServerService;
    }

    private static final Logger log = LoggerFactory.getLogger(gRPCServer.class);
    private static ArithmeticServerGrpc.ArithmeticServerBlockingStub blockingStub = null;
    private static ManagedChannel managedChannel = null;
    private static Map<String, String> jsons = new HashMap<>();
    private static int round = 0;
    private static int nowRound = 1;
    private static Long polymerizationId;
    private static List<Long> userIds;
    public static List<Map<String, List<Double>>> result;

    public gRPCServer(String host, int port) {
        managedChannel = ManagedChannelBuilder.forAddress(host, port)
                .maxInboundMessageSize(1073741824)
                .usePlaintext()
                .keepAliveWithoutCalls(true)
                .build();
        blockingStub = ArithmeticServerGrpc.newBlockingStub(managedChannel);
    }

    private static ResponseInit serverInit() {
        RequestInit requestInit = RequestInit.newBuilder().build();
        return blockingStub.serverInit(requestInit);
    }

    private static Response sendAggregatedPara(Integer number, Integer round, byte[][] encryptedFileContent, byte[][] gradinets) {
        Request.Builder builder = Request.newBuilder()
                .setNumber(number)
                .setRound(round);
        for (byte[] bytes : encryptedFileContent) {
            builder.addEncryptedFileContent(ByteString.copyFrom(bytes));
        }
        for (byte[] bytes : gradinets) {
            builder.addGradients(ByteString.copyFrom(bytes));
        }
        Request request = builder.build();
        return blockingStub.sendAggregatedPara(request);
    }

    public static void trainInit(int round, Long polymerizationId, List<Long> userIds) {
        result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, List<Double>> map0 = new HashMap<>();
            map0.put("mydata", new ArrayList<>());
            result.add(map0);
        }

        log.info("trainInit");
        gRPCServer.polymerizationId = polymerizationId;
        gRPCServer.userIds = userIds;

        jsons = new HashMap<>();
        gRPCServer.round = round;
        nowRound = 0;
        LocalDateTime startTime = LocalDateTime.now();
        log.info("trainInitI");
        ResponseInit responseInit = serverInit();
        log.info("trainInitII");
        LocalDateTime endTime = LocalDateTime.now();
        Map<String, Object> map = new HashMap<>();
        map.put("round", gRPCServer.round);
        map.put("nowRound", nowRound);
        map.put("paraFileContent", new String(responseInit.getParaFileContent().toByteArray(), StandardCharsets.ISO_8859_1));
        map.put("ctxFileContent", new String(responseInit.getCtxFileContent().toByteArray(), StandardCharsets.ISO_8859_1));
        map.put("polymerizationId", gRPCServer.polymerizationId);
        String json = JSON.toJSONString(map);
        for (Long userId : gRPCServer.userIds) {
            WSServer.sendMessage(WSServer.webSocketMap.get(userId.toString()), "trainInit:" + json);
        }

        PolymerizationServer polymerizationServer = new PolymerizationServer();
        polymerizationServer.setPolymerizationId(gRPCServer.polymerizationId);
        polymerizationServer.setStartTime(startTime);
        polymerizationServer.setEndTime(endTime);
        polymerizationServer.setRound(nowRound);
        gRPCServer.polymerizationServerService.save(polymerizationServer);

        Polymerization polymerization = new Polymerization();
        polymerization.setId(gRPCServer.polymerizationId);
        polymerization.setStartTime(startTime);
        polymerizationService.updateById(polymerization);

        log.info("/trainInit");
    }

    public static void train(String token, String json) throws IOException {
        log.info("train:{}", nowRound);
        jsons.put(String.valueOf(jsons.size()), json);
        int number = userIds.size();
        if (jsons.size() == number) {
            byte[][] encryptedFileContent = new byte[number][];
            byte[][] gradients = new byte[number][];
            int i = 0;
            for (String str : jsons.values()) {
                Map map = JSON.parseObject(str, Map.class);
                encryptedFileContent[i] = String.valueOf(map.get("parasContent")).getBytes(StandardCharsets.ISO_8859_1);
                gradients[i] = String.valueOf(map.get("gradientsContent")).getBytes(StandardCharsets.ISO_8859_1);
                i++;
            }
            jsons = new HashMap<>();
            nowRound++;
            LocalDateTime startTime = LocalDateTime.now();
            log.info("trainI:{}", nowRound);
            Response response = sendAggregatedPara(number, nowRound, encryptedFileContent, gradients);
            log.info("trainII:{}", nowRound);
            LocalDateTime endTime = LocalDateTime.now();

            String fileName = "D:\\server" + nowRound + ".csv";
            File file = new File(fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(response.getResult().toByteArray());
            fos.flush();
            fos.close();

            BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
            String line;
            br.readLine();
            line = br.readLine();
            String[] split = line.split(",");
            double accuracy = 0.0;
            for (int j = 1; j <= 5; j++) {
                accuracy += Double.parseDouble(split[j]);
                result.get(j - 1).get("mydata").add(Double.parseDouble(split[j]));
            }
            accuracy /= 5;

            log.info("nowRound:{}", nowRound);
            log.info("round:{}", round);
            if (nowRound != round) {
                Map<String, Object> map = new HashMap<>();
                map.put("round", gRPCServer.round);
                map.put("nowRound", nowRound);
                map.put("aggParaFileContent", new String(response.getAggParaFileContent().toByteArray(), StandardCharsets.ISO_8859_1));
                map.put("polymerizationId", gRPCServer.polymerizationId);
                String newJson = JSON.toJSONString(map);
                for (Long userId : userIds) {
                    WSServer.sendMessage(WSServer.webSocketMap.get(userId.toString()), "train:" + newJson);
                }
            } else {
                Polymerization polymerization = new Polymerization();
                polymerization.setId(gRPCServer.polymerizationId);
                polymerization.setEndTime(endTime);
                polymerization.setAccuracy(accuracy);
                polymerizationService.updateById(polymerization);
            }
            PolymerizationServer polymerizationServer = new PolymerizationServer();
            polymerizationServer.setPolymerizationId(gRPCServer.polymerizationId);
            polymerizationServer.setStartTime(startTime);
            polymerizationServer.setEndTime(endTime);
            polymerizationServer.setRound(nowRound);
            gRPCServer.polymerizationServerService.save(polymerizationServer);
        }
        log.info("/train:{}", nowRound);
    }
}

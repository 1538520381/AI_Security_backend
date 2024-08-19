package com.AI_Security.AI_Security_client.grpc;

import com.AI_Security.AI_Security_client.entity.po.PolymerizationUser;
import com.AI_Security.AI_Security_client.entity.result.R;
import com.AI_Security.AI_Security_client.service.PolymerizationUserService;
import com.AI_Security.AI_Security_client.webSocket.WSServer;
import com.alibaba.fastjson.JSON;
import com.google.protobuf.ByteString;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Persolute
 * @version 1.0
 * @description grpc Service
 * @email 1538520381@qq.com
 * @date 2024/05/28 15:41
 */
public class gRPCServer {
    private static PolymerizationUserService polymerizationUserService;

    @Autowired
    public void setPolymerizationUserService(PolymerizationUserService polymerizationUserService) {
        gRPCServer.polymerizationUserService = polymerizationUserService;
    }

    private static final Logger log = LoggerFactory.getLogger(gRPCServer.class);
    private static FileServiceGrpc.FileServiceBlockingStub blockingStub;
    private static ManagedChannel managedChannel = null;
    public static Map<String, List<Map<String, List<Double>>>> result;
    public static List<List<Map<String, List<Double>>>> result0;

    public gRPCServer(String host, int port) {
        managedChannel = ManagedChannelBuilder.forAddress(host, port)
                .maxInboundMessageSize(1073741824)
                .usePlaintext()
                .keepAliveWithoutCalls(true)
                .build();
        blockingStub = FileServiceGrpc.newBlockingStub(managedChannel);
    }

    private static Response uploadAndProcessFileInit(byte[] ctxContent, byte[] parasContent, Integer round) {
        RequestInit requestInit = RequestInit.newBuilder()
                .setCtxContent(ByteString.copyFrom(ctxContent))
                .setParasContent(ByteString.copyFrom(parasContent))
                .setRound(round)
                .build();
        return blockingStub.processinit(requestInit);
    }

    private static Response uploadAndProcessFile(byte[] parasContent, Integer round) {
        Request request = Request.newBuilder()
                .setParasContent(ByteString.copyFrom(parasContent))
                .setRound(round)
                .build();
        return blockingStub.process(request);
    }

    private static ResponseDetect detect() {
        RequestDetect requestDetect = RequestDetect.newBuilder().build();
        return blockingStub.detect(requestDetect);
    }

    public static void trainInit(String json, Long userId) throws IOException {
        result = new HashMap<>();
        List<Map<String, List<Double>>> loss = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, List<Double>> map0 = new HashMap<>();
            map0.put("mydata", new ArrayList<>());
            loss.add(map0);
        }
        result.put("loss", loss);

        List<Map<String, List<Double>>> accuracy = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, List<Double>> map0 = new HashMap<>();
            map0.put("mydata", new ArrayList<>());
            accuracy.add(map0);
        }
        result.put("accuracy", accuracy);

        result0 = new ArrayList<>();

        log.info("trainInit");
        Map map = JSON.parseObject(json, Map.class);
        LocalDateTime startTime = LocalDateTime.now();
        log.info("trainInitI");
        Response response = uploadAndProcessFileInit(String.valueOf(map.get("ctxFileContent")).getBytes(StandardCharsets.ISO_8859_1),
                String.valueOf(map.get("paraFileContent")).getBytes(StandardCharsets.ISO_8859_1),
                (Integer) map.get("nowRound"));
        log.info("trainInitII");
        LocalDateTime endTime = LocalDateTime.now();
        Map<String, Object> newMap = new HashMap<>();
        newMap.put("parasContent", new String(response.getParasContent().toByteArray(), StandardCharsets.ISO_8859_1));
        newMap.put("gradientsContent", new String(response.getGradientsContent().toByteArray(), StandardCharsets.ISO_8859_1));
        String newJson = JSON.toJSONString(newMap);
        try {
            WSServer.wsClient.send("train:" + newJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PolymerizationUser polymerizationUser = new PolymerizationUser();
        polymerizationUser.setUserId(userId);
        polymerizationUser.setRound((Integer) map.get("nowRound"));
        polymerizationUser.setStartTime(startTime);
        polymerizationUser.setEndTime(endTime);
        polymerizationUser.setPolymerizationId((Long) map.get("polymerizationId"));
        polymerizationUserService.save(polymerizationUser);

        String fileName = "D:\\client" + userId + "_" + map.get("nowRound") + ".csv";
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(response.getResultContent().toByteArray());
        fos.flush();
        fos.close();

        BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
        String line0 = null;
        String line;
        br.readLine();
        line = br.readLine();
        List<Map<String, List<Double>>> list0 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, List<Double>> map0 = new HashMap<>();
            map0.put("mydata", new ArrayList<>());
            list0.add(map0);
        }
        while (line != null) {
            String[] splits = line.split(",");
            for (int i = 0; i < 5; i++) {
                if (i * 2 + 1 >= splits.length || splits[i * 2 + 1] == null || splits[i * 2 + 1].isEmpty()) {
                    list0.get(i).get("mydata").add(null);
                } else {
                    list0.get(i).get("mydata").add(Double.parseDouble(splits[i * 2 + 1]));
                }
            }
            line0 = line;
            line = br.readLine();
        }
        result0.add(list0);
        try {
            String[] split = line0.split(",");
            for (int j = 1; j <= 5; j++) {
                result.get("accuracy").get(j - 1).get("mydata").add(Double.parseDouble(split[j * 2 - 1]));
                result.get("loss").get(j - 1).get("mydata").add(Double.parseDouble(split[j * 2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(line0);
        }


//        log.info("/trainInit");
    }

    public static void train(String json, Long userId) throws IOException {
        log.info("train");
        Map map = JSON.parseObject(json, Map.class);
        LocalDateTime startTime = LocalDateTime.now();
        log.info("trainI:{}", map.get("nowRound"));
        Response response = uploadAndProcessFile(String.valueOf(map.get("aggParaFileContent")).getBytes(StandardCharsets.ISO_8859_1),
                (Integer) map.get("nowRound"));
        log.info("trainII:{}", map.get("nowRound"));
        LocalDateTime endTime = LocalDateTime.now();

        String fileName = "D:\\client" + userId + "_" + map.get("nowRound") + ".csv";
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(response.getResultContent().toByteArray());
        fos.flush();
        fos.close();

        BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
        String line0 = null;
        String line;
        br.readLine();
        line = br.readLine();
        List<Map<String, List<Double>>> list0 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, List<Double>> map0 = new HashMap<>();
            map0.put("mydata", new ArrayList<>());
            list0.add(map0);
        }
        while (line != null) {
            String[] splits = line.split(",");
            for (int i = 0; i < 5; i++) {
                if (i * 2 + 1 >= splits.length || splits[i * 2 + 1] == null || splits[i * 2 + 1].isEmpty()) {
                    list0.get(i).get("mydata").add(null);
                } else {
                    list0.get(i).get("mydata").add(Double.parseDouble(splits[i * 2 + 1]));
                }
            }
            line0 = line;
            line = br.readLine();
        }
        result0.add(list0);
        String[] split = line0.split(",");
        try {
            for (int j = 1; j <= 5; j++) {
                result.get("accuracy").get(j - 1).get("mydata").add(Double.parseDouble(split[j * 2 - 1]));
                result.get("loss").get(j - 1).get("mydata").add(Double.parseDouble(split[j * 2]));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(line0);
        }

        Map<String, Object> newMap = new HashMap<>();
        newMap.put("parasContent", new String(response.getParasContent().toByteArray(), StandardCharsets.ISO_8859_1));
        newMap.put("gradientsContent", new String(response.getGradientsContent().toByteArray(), StandardCharsets.ISO_8859_1));
        String newJson = JSON.toJSONString(newMap);
        WSServer.wsClient.send("train:" + newJson);

        PolymerizationUser polymerizationUser = new PolymerizationUser();
        polymerizationUser.setUserId(userId);
        polymerizationUser.setRound((Integer) map.get("nowRound"));
        polymerizationUser.setStartTime(startTime);
        polymerizationUser.setEndTime(endTime);
        polymerizationUser.setPolymerizationId((Long) map.get("polymerizationId"));
        polymerizationUserService.save(polymerizationUser);
        log.info("/train");
    }

    public static List<Map<String, String>> getDetect() throws IOException, ParseException {
        ResponseDetect responseDetect = detect();

        String fileName = "D:\\detect.csv";
        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(responseDetect.getResultDetect().toByteArray());
        fos.flush();
        fos.close();

        List<String> newList = new ArrayList<>();
        List<Map<String, String>> list = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
        String line;
        line = br.readLine();
        newList.add(line);
        while ((line = br.readLine()) != null) {
            String[] split = line.split(",");
            Map<String, String> map = new HashMap<>();
            map.put("srcIp", split[1]);
            map.put("srcPort", split[2]);
            map.put("dstIp", split[3]);
            map.put("dstPort", split[4]);
            Date date = new Date(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(split[6].substring(0, split[6].lastIndexOf(" "))).getTime());
//            if (date.getHours() < 12) {
//                date.setHours(date.getHours() + 12);
//            }
            map.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            list.add(map);

            line = line.substring(0, line.lastIndexOf(",") + 1) + "DDOS";
            newList.add(line);
        }
        br.close();

        BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
        for (String newLine : newList) {
            writer.write(newLine);
            writer.newLine();
        }
        writer.close();
        return list;
    }
}

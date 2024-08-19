package com.AI_Security.AI_Security_client.grpc1;


import com.AI_Security.AI_Security_client.entity.result.R;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Persolute
 * @version 1.0
 * @description
 * @email 1538520381@qq.com
 * @date 2024/08/01 13:42
 */
public class gRPCServer1 {
    private static final Logger log = LoggerFactory.getLogger(gRPCServer1.class);
    private static ArithmeticServerGrpc.ArithmeticServerBlockingStub blockingStub;
    private static ManagedChannel managedChannel = null;

    public gRPCServer1(String host, int port) {
        managedChannel = ManagedChannelBuilder.forAddress(host, port)
                .maxInboundMessageSize(1073741824)
                .usePlaintext()
                .keepAliveWithoutCalls(true)
                .build();
        blockingStub = ArithmeticServerGrpc.newBlockingStub(managedChannel);
    }

    public static Response dataInfo(String url, String type) {
        Request request = Request.newBuilder().setUrl(url).setType(type).build();
        return blockingStub.dataInfo(request);
    }

    public static Response fun(String url, String type) {
        Request request = Request.newBuilder().setUrl(url).setType(type).build();
        return blockingStub.localTrain(request);
    }
}

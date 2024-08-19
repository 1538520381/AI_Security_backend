package com.AI_Security.AI_Security_server.grpc;

import static com.mysql.cj.x.protobuf.MysqlxSql.getDescriptor;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: proto")
public final class ArithmeticServerGrpc {

  private ArithmeticServerGrpc() {}

  public static final String SERVICE_NAME = "example.ArithmeticServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RequestInit,
          ResponseInit> getServerInitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "server_init",
      requestType = RequestInit.class,
      responseType = ResponseInit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestInit,
          ResponseInit> getServerInitMethod() {
    io.grpc.MethodDescriptor<RequestInit, ResponseInit> getServerInitMethod;
    if ((getServerInitMethod = ArithmeticServerGrpc.getServerInitMethod) == null) {
      synchronized (ArithmeticServerGrpc.class) {
        if ((getServerInitMethod = ArithmeticServerGrpc.getServerInitMethod) == null) {
          ArithmeticServerGrpc.getServerInitMethod = getServerInitMethod = 
              io.grpc.MethodDescriptor.<RequestInit, ResponseInit>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "example.ArithmeticServer", "server_init"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestInit.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseInit.getDefaultInstance()))
                  .setSchemaDescriptor(new ArithmeticServerMethodDescriptorSupplier("server_init"))
                  .build();
          }
        }
     }
     return getServerInitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Request,
      Response> getSendAggregatedParaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "send_aggregated_para",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Request,
      Response> getSendAggregatedParaMethod() {
    io.grpc.MethodDescriptor<Request, Response> getSendAggregatedParaMethod;
    if ((getSendAggregatedParaMethod = ArithmeticServerGrpc.getSendAggregatedParaMethod) == null) {
      synchronized (ArithmeticServerGrpc.class) {
        if ((getSendAggregatedParaMethod = ArithmeticServerGrpc.getSendAggregatedParaMethod) == null) {
          ArithmeticServerGrpc.getSendAggregatedParaMethod = getSendAggregatedParaMethod = 
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "example.ArithmeticServer", "send_aggregated_para"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ArithmeticServerMethodDescriptorSupplier("send_aggregated_para"))
                  .build();
          }
        }
     }
     return getSendAggregatedParaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ArithmeticServerStub newStub(io.grpc.Channel channel) {
    return new ArithmeticServerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArithmeticServerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ArithmeticServerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ArithmeticServerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ArithmeticServerFutureStub(channel);
  }

  /**
   */
  public static abstract class ArithmeticServerImplBase implements io.grpc.BindableService {

    /**
     */
    public void serverInit(RequestInit request,
                           io.grpc.stub.StreamObserver<ResponseInit> responseObserver) {
      asyncUnimplementedUnaryCall(getServerInitMethod(), responseObserver);
    }

    /**
     */
    public void sendAggregatedPara(Request request,
                                   io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getSendAggregatedParaMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getServerInitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      RequestInit,
                      ResponseInit>(
                  this, METHODID_SERVER_INIT)))
          .addMethod(
            getSendAggregatedParaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                Request,
                Response>(
                  this, METHODID_SEND_AGGREGATED_PARA)))
          .build();
    }
  }

  /**
   */
  public static final class ArithmeticServerStub extends io.grpc.stub.AbstractStub<ArithmeticServerStub> {
    private ArithmeticServerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArithmeticServerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ArithmeticServerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArithmeticServerStub(channel, callOptions);
    }

    /**
     */
    public void serverInit(RequestInit request,
                           io.grpc.stub.StreamObserver<ResponseInit> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getServerInitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendAggregatedPara(Request request,
                                   io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendAggregatedParaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ArithmeticServerBlockingStub extends io.grpc.stub.AbstractStub<ArithmeticServerBlockingStub> {
    private ArithmeticServerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArithmeticServerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ArithmeticServerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArithmeticServerBlockingStub(channel, callOptions);
    }

    /**
     */
    public ResponseInit serverInit(RequestInit request) {
      return blockingUnaryCall(
          getChannel(), getServerInitMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response sendAggregatedPara(Request request) {
      return blockingUnaryCall(
          getChannel(), getSendAggregatedParaMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ArithmeticServerFutureStub extends io.grpc.stub.AbstractStub<ArithmeticServerFutureStub> {
    private ArithmeticServerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ArithmeticServerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ArithmeticServerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ArithmeticServerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResponseInit> serverInit(
        RequestInit request) {
      return futureUnaryCall(
          getChannel().newCall(getServerInitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> sendAggregatedPara(
        Request request) {
      return futureUnaryCall(
          getChannel().newCall(getSendAggregatedParaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SERVER_INIT = 0;
  private static final int METHODID_SEND_AGGREGATED_PARA = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ArithmeticServerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArithmeticServerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SERVER_INIT:
          serviceImpl.serverInit((RequestInit) request,
              (io.grpc.stub.StreamObserver<ResponseInit>) responseObserver);
          break;
        case METHODID_SEND_AGGREGATED_PARA:
          serviceImpl.sendAggregatedPara((Request) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ArithmeticServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArithmeticServerBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ArithmeticServer");
    }
  }

  private static final class ArithmeticServerFileDescriptorSupplier
      extends ArithmeticServerBaseDescriptorSupplier {
    ArithmeticServerFileDescriptorSupplier() {}
  }

  private static final class ArithmeticServerMethodDescriptorSupplier
      extends ArithmeticServerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArithmeticServerMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ArithmeticServerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ArithmeticServerFileDescriptorSupplier())
              .addMethod(getServerInitMethod())
              .addMethod(getSendAggregatedParaMethod())
              .build();
        }
      }
    }
    return result;
  }
}

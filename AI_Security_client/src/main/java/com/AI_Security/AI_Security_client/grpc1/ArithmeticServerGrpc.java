package com.AI_Security.AI_Security_client.grpc1;

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
    comments = "Source: federal1.proto")
public final class ArithmeticServerGrpc {

  private ArithmeticServerGrpc() {}

  public static final String SERVICE_NAME = "example.ArithmeticServer";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Request,
          Response> getDataInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "dataInfo",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Request,
          Response> getDataInfoMethod() {
    io.grpc.MethodDescriptor<Request, Response> getDataInfoMethod;
    if ((getDataInfoMethod = ArithmeticServerGrpc.getDataInfoMethod) == null) {
      synchronized (ArithmeticServerGrpc.class) {
        if ((getDataInfoMethod = ArithmeticServerGrpc.getDataInfoMethod) == null) {
          ArithmeticServerGrpc.getDataInfoMethod = getDataInfoMethod = 
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "example.ArithmeticServer", "dataInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ArithmeticServerMethodDescriptorSupplier("dataInfo"))
                  .build();
          }
        }
     }
     return getDataInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Request,
          Response> getLocalTrainMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "localTrain",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Request,
          Response> getLocalTrainMethod() {
    io.grpc.MethodDescriptor<Request, Response> getLocalTrainMethod;
    if ((getLocalTrainMethod = ArithmeticServerGrpc.getLocalTrainMethod) == null) {
      synchronized (ArithmeticServerGrpc.class) {
        if ((getLocalTrainMethod = ArithmeticServerGrpc.getLocalTrainMethod) == null) {
          ArithmeticServerGrpc.getLocalTrainMethod = getLocalTrainMethod = 
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "example.ArithmeticServer", "localTrain"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ArithmeticServerMethodDescriptorSupplier("localTrain"))
                  .build();
          }
        }
     }
     return getLocalTrainMethod;
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
    public void dataInfo(Request request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDataInfoMethod(), responseObserver);
    }

    /**
     */
    public void localTrain(Request request,
                           io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getLocalTrainMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getDataInfoMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      Request,
                      Response>(
                  this, METHODID_DATA_INFO)))
          .addMethod(
            getLocalTrainMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      Request,
                      Response>(
                  this, METHODID_LOCAL_TRAIN)))
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
    public void dataInfo(Request request,
                         io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDataInfoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void localTrain(Request request,
                           io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLocalTrainMethod(), getCallOptions()), request, responseObserver);
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
    public Response dataInfo(Request request) {
      return blockingUnaryCall(
          getChannel(), getDataInfoMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response localTrain(Request request) {
      return blockingUnaryCall(
          getChannel(), getLocalTrainMethod(), getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<Response> dataInfo(
        Request request) {
      return futureUnaryCall(
          getChannel().newCall(getDataInfoMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> localTrain(
        Request request) {
      return futureUnaryCall(
          getChannel().newCall(getLocalTrainMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_DATA_INFO = 0;
  private static final int METHODID_LOCAL_TRAIN = 1;

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
        case METHODID_DATA_INFO:
          serviceImpl.dataInfo((Request) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_LOCAL_TRAIN:
          serviceImpl.localTrain((Request) request,
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
      return FederalProto.getDescriptor();
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
              .addMethod(getDataInfoMethod())
              .addMethod(getLocalTrainMethod())
              .build();
        }
      }
    }
    return result;
  }
}

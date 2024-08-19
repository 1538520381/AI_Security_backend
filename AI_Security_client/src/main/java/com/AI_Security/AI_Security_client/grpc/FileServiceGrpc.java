package com.AI_Security.AI_Security_client.grpc;

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
    comments = "Source: federal.proto")
public final class FileServiceGrpc {

  private FileServiceGrpc() {}

  public static final String SERVICE_NAME = "filetransfer.FileService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<RequestInit,
          Response> getProcessinitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "processinit",
      requestType = RequestInit.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestInit,
          Response> getProcessinitMethod() {
    io.grpc.MethodDescriptor<RequestInit, Response> getProcessinitMethod;
    if ((getProcessinitMethod = FileServiceGrpc.getProcessinitMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getProcessinitMethod = FileServiceGrpc.getProcessinitMethod) == null) {
          FileServiceGrpc.getProcessinitMethod = getProcessinitMethod = 
              io.grpc.MethodDescriptor.<RequestInit, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "filetransfer.FileService", "processinit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestInit.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("processinit"))
                  .build();
          }
        }
     }
     return getProcessinitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Request,
          Response> getProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "process",
      requestType = Request.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Request,
          Response> getProcessMethod() {
    io.grpc.MethodDescriptor<Request, Response> getProcessMethod;
    if ((getProcessMethod = FileServiceGrpc.getProcessMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getProcessMethod = FileServiceGrpc.getProcessMethod) == null) {
          FileServiceGrpc.getProcessMethod = getProcessMethod = 
              io.grpc.MethodDescriptor.<Request, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "filetransfer.FileService", "process"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("process"))
                  .build();
          }
        }
     }
     return getProcessMethod;
  }

  private static volatile io.grpc.MethodDescriptor<RequestDetect,
          ResponseDetect> getDetectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "detect",
      requestType = RequestDetect.class,
      responseType = ResponseDetect.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<RequestDetect,
          ResponseDetect> getDetectMethod() {
    io.grpc.MethodDescriptor<RequestDetect, ResponseDetect> getDetectMethod;
    if ((getDetectMethod = FileServiceGrpc.getDetectMethod) == null) {
      synchronized (FileServiceGrpc.class) {
        if ((getDetectMethod = FileServiceGrpc.getDetectMethod) == null) {
          FileServiceGrpc.getDetectMethod = getDetectMethod = 
              io.grpc.MethodDescriptor.<RequestDetect, ResponseDetect>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "filetransfer.FileService", "detect"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  RequestDetect.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ResponseDetect.getDefaultInstance()))
                  .setSchemaDescriptor(new FileServiceMethodDescriptorSupplier("detect"))
                  .build();
          }
        }
     }
     return getDetectMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FileServiceStub newStub(io.grpc.Channel channel) {
    return new FileServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FileServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new FileServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FileServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new FileServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class FileServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void processinit(RequestInit request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessinitMethod(), responseObserver);
    }

    /**
     */
    public void process(Request request,
                        io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getProcessMethod(), responseObserver);
    }

    /**
     */
    public void detect(RequestDetect request,
                       io.grpc.stub.StreamObserver<ResponseDetect> responseObserver) {
      asyncUnimplementedUnaryCall(getDetectMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessinitMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      RequestInit,
                      Response>(
                  this, METHODID_PROCESSINIT)))
          .addMethod(
            getProcessMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      Request,
                      Response>(
                  this, METHODID_PROCESS)))
          .addMethod(
            getDetectMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                      RequestDetect,
                      ResponseDetect>(
                  this, METHODID_DETECT)))
          .build();
    }
  }

  /**
   */
  public static final class FileServiceStub extends io.grpc.stub.AbstractStub<FileServiceStub> {
    private FileServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected FileServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceStub(channel, callOptions);
    }

    /**
     */
    public void processinit(RequestInit request,
                            io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessinitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void process(Request request,
                        io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void detect(RequestDetect request,
                       io.grpc.stub.StreamObserver<ResponseDetect> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDetectMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FileServiceBlockingStub extends io.grpc.stub.AbstractStub<FileServiceBlockingStub> {
    private FileServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected FileServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public Response processinit(RequestInit request) {
      return blockingUnaryCall(
          getChannel(), getProcessinitMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response process(Request request) {
      return blockingUnaryCall(
          getChannel(), getProcessMethod(), getCallOptions(), request);
    }

    /**
     */
    public ResponseDetect detect(RequestDetect request) {
      return blockingUnaryCall(
          getChannel(), getDetectMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FileServiceFutureStub extends io.grpc.stub.AbstractStub<FileServiceFutureStub> {
    private FileServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private FileServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected FileServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new FileServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> processinit(
        RequestInit request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessinitMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> process(
        Request request) {
      return futureUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ResponseDetect> detect(
        RequestDetect request) {
      return futureUnaryCall(
          getChannel().newCall(getDetectMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESSINIT = 0;
  private static final int METHODID_PROCESS = 1;
  private static final int METHODID_DETECT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FileServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FileServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESSINIT:
          serviceImpl.processinit((RequestInit) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_PROCESS:
          serviceImpl.process((Request) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_DETECT:
          serviceImpl.detect((RequestDetect) request,
              (io.grpc.stub.StreamObserver<ResponseDetect>) responseObserver);
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

  private static abstract class FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FileServiceBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Federal.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FileService");
    }
  }

  private static final class FileServiceFileDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier {
    FileServiceFileDescriptorSupplier() {}
  }

  private static final class FileServiceMethodDescriptorSupplier
      extends FileServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FileServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FileServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FileServiceFileDescriptorSupplier())
              .addMethod(getProcessinitMethod())
              .addMethod(getProcessMethod())
              .addMethod(getDetectMethod())
              .build();
        }
      }
    }
    return result;
  }
}

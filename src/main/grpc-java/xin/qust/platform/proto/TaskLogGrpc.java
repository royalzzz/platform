package xin.qust.platform.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *服务端接口类
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: tasklog.proto")
public final class TaskLogGrpc {

  private TaskLogGrpc() {}

  public static final String SERVICE_NAME = "proto.TaskLog";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xin.qust.platform.proto.TaskLogProto.LogRequest,
      xin.qust.platform.proto.TaskLogProto.LogReply> getCollectLogMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectLog",
      requestType = xin.qust.platform.proto.TaskLogProto.LogRequest.class,
      responseType = xin.qust.platform.proto.TaskLogProto.LogReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xin.qust.platform.proto.TaskLogProto.LogRequest,
      xin.qust.platform.proto.TaskLogProto.LogReply> getCollectLogMethod() {
    io.grpc.MethodDescriptor<xin.qust.platform.proto.TaskLogProto.LogRequest, xin.qust.platform.proto.TaskLogProto.LogReply> getCollectLogMethod;
    if ((getCollectLogMethod = TaskLogGrpc.getCollectLogMethod) == null) {
      synchronized (TaskLogGrpc.class) {
        if ((getCollectLogMethod = TaskLogGrpc.getCollectLogMethod) == null) {
          TaskLogGrpc.getCollectLogMethod = getCollectLogMethod = 
              io.grpc.MethodDescriptor.<xin.qust.platform.proto.TaskLogProto.LogRequest, xin.qust.platform.proto.TaskLogProto.LogReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.TaskLog", "collectLog"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.TaskLogProto.LogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.TaskLogProto.LogReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskLogMethodDescriptorSupplier("collectLog"))
                  .build();
          }
        }
     }
     return getCollectLogMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskLogStub newStub(io.grpc.Channel channel) {
    return new TaskLogStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskLogBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TaskLogBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskLogFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TaskLogFutureStub(channel);
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static abstract class TaskLogImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void collectLog(xin.qust.platform.proto.TaskLogProto.LogRequest request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.TaskLogProto.LogReply> responseObserver) {
      asyncUnimplementedUnaryCall(getCollectLogMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCollectLogMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                xin.qust.platform.proto.TaskLogProto.LogRequest,
                xin.qust.platform.proto.TaskLogProto.LogReply>(
                  this, METHODID_COLLECT_LOG)))
          .build();
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskLogStub extends io.grpc.stub.AbstractStub<TaskLogStub> {
    private TaskLogStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskLogStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskLogStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskLogStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void collectLog(xin.qust.platform.proto.TaskLogProto.LogRequest request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.TaskLogProto.LogReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCollectLogMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskLogBlockingStub extends io.grpc.stub.AbstractStub<TaskLogBlockingStub> {
    private TaskLogBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskLogBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskLogBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskLogBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public xin.qust.platform.proto.TaskLogProto.LogReply collectLog(xin.qust.platform.proto.TaskLogProto.LogRequest request) {
      return blockingUnaryCall(
          getChannel(), getCollectLogMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskLogFutureStub extends io.grpc.stub.AbstractStub<TaskLogFutureStub> {
    private TaskLogFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskLogFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TaskLogFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskLogFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<xin.qust.platform.proto.TaskLogProto.LogReply> collectLog(
        xin.qust.platform.proto.TaskLogProto.LogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCollectLogMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COLLECT_LOG = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskLogImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskLogImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COLLECT_LOG:
          serviceImpl.collectLog((xin.qust.platform.proto.TaskLogProto.LogRequest) request,
              (io.grpc.stub.StreamObserver<xin.qust.platform.proto.TaskLogProto.LogReply>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TaskLogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskLogBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xin.qust.platform.proto.TaskLogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskLog");
    }
  }

  private static final class TaskLogFileDescriptorSupplier
      extends TaskLogBaseDescriptorSupplier {
    TaskLogFileDescriptorSupplier() {}
  }

  private static final class TaskLogMethodDescriptorSupplier
      extends TaskLogBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskLogMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TaskLogGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskLogFileDescriptorSupplier())
              .addMethod(getCollectLogMethod())
              .build();
        }
      }
    }
    return result;
  }
}

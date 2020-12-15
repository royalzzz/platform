package xin.qust.platform.grpc.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *服务端接口类
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: taskyuqingcla.proto")
public final class TaskYuqingClaGrpc {

  private TaskYuqingClaGrpc() {}

  public static final String SERVICE_NAME = "proto.TaskYuqingCla";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest,
      xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply> getYuqingClaMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "yuqingCla",
      requestType = xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest.class,
      responseType = xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest,
      xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply> getYuqingClaMethod() {
    io.grpc.MethodDescriptor<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest, xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply> getYuqingClaMethod;
    if ((getYuqingClaMethod = TaskYuqingClaGrpc.getYuqingClaMethod) == null) {
      synchronized (TaskYuqingClaGrpc.class) {
        if ((getYuqingClaMethod = TaskYuqingClaGrpc.getYuqingClaMethod) == null) {
          TaskYuqingClaGrpc.getYuqingClaMethod = getYuqingClaMethod =
              io.grpc.MethodDescriptor.<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest, xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.TaskYuqingCla", "yuqingCla"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskYuqingClaMethodDescriptorSupplier("yuqingCla"))
                  .build();
          }
        }
     }
     return getYuqingClaMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskYuqingClaStub newStub(io.grpc.Channel channel) {
    return new TaskYuqingClaStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskYuqingClaBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TaskYuqingClaBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskYuqingClaFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TaskYuqingClaFutureStub(channel);
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static abstract class TaskYuqingClaImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void yuqingCla(xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest request,
        io.grpc.stub.StreamObserver<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply> responseObserver) {
      asyncUnimplementedUnaryCall(getYuqingClaMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getYuqingClaMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest,
                xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply>(
                  this, METHODID_YUQING_CLA)))
          .build();
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskYuqingClaStub extends io.grpc.stub.AbstractStub<TaskYuqingClaStub> {
    private TaskYuqingClaStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskYuqingClaStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskYuqingClaStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskYuqingClaStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void yuqingCla(xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest request,
        io.grpc.stub.StreamObserver<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getYuqingClaMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskYuqingClaBlockingStub extends io.grpc.stub.AbstractStub<TaskYuqingClaBlockingStub> {
    private TaskYuqingClaBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskYuqingClaBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskYuqingClaBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskYuqingClaBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply yuqingCla(xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest request) {
      return blockingUnaryCall(
          getChannel(), getYuqingClaMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskYuqingClaFutureStub extends io.grpc.stub.AbstractStub<TaskYuqingClaFutureStub> {
    private TaskYuqingClaFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskYuqingClaFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskYuqingClaFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskYuqingClaFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply> yuqingCla(
        xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getYuqingClaMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_YUQING_CLA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskYuqingClaImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskYuqingClaImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_YUQING_CLA:
          serviceImpl.yuqingCla((xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaRequest) request,
              (io.grpc.stub.StreamObserver<xin.qust.platform.grpc.proto.TaskYuqingClaProto.TaskYuqingClaReply>) responseObserver);
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

  private static abstract class TaskYuqingClaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskYuqingClaBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xin.qust.platform.grpc.proto.TaskYuqingClaProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskYuqingCla");
    }
  }

  private static final class TaskYuqingClaFileDescriptorSupplier
      extends TaskYuqingClaBaseDescriptorSupplier {
    TaskYuqingClaFileDescriptorSupplier() {}
  }

  private static final class TaskYuqingClaMethodDescriptorSupplier
      extends TaskYuqingClaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskYuqingClaMethodDescriptorSupplier(String methodName) {
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
      synchronized (TaskYuqingClaGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskYuqingClaFileDescriptorSupplier())
              .addMethod(getYuqingClaMethod())
              .build();
        }
      }
    }
    return result;
  }
}

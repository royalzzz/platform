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
    comments = "Source: taskmanage.proto")
public final class TaskManageGrpc {

  private TaskManageGrpc() {}

  public static final String SERVICE_NAME = "proto.TaskManage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<TaskManageProto.ListActiveRequest,
      TaskManageProto.ListActiveReply> getListActiveTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "listActiveTask",
      requestType = TaskManageProto.ListActiveRequest.class,
      responseType = TaskManageProto.ListActiveReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TaskManageProto.ListActiveRequest,
      TaskManageProto.ListActiveReply> getListActiveTaskMethod() {
    io.grpc.MethodDescriptor<TaskManageProto.ListActiveRequest, TaskManageProto.ListActiveReply> getListActiveTaskMethod;
    if ((getListActiveTaskMethod = TaskManageGrpc.getListActiveTaskMethod) == null) {
      synchronized (TaskManageGrpc.class) {
        if ((getListActiveTaskMethod = TaskManageGrpc.getListActiveTaskMethod) == null) {
          TaskManageGrpc.getListActiveTaskMethod = getListActiveTaskMethod = 
              io.grpc.MethodDescriptor.<TaskManageProto.ListActiveRequest, TaskManageProto.ListActiveReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.TaskManage", "listActiveTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TaskManageProto.ListActiveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TaskManageProto.ListActiveReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskManageMethodDescriptorSupplier("listActiveTask"))
                  .build();
          }
        }
     }
     return getListActiveTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<TaskManageProto.KillRequest,
      TaskManageProto.KillReply> getKillTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "killTask",
      requestType = TaskManageProto.KillRequest.class,
      responseType = TaskManageProto.KillReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<TaskManageProto.KillRequest,
      TaskManageProto.KillReply> getKillTaskMethod() {
    io.grpc.MethodDescriptor<TaskManageProto.KillRequest, TaskManageProto.KillReply> getKillTaskMethod;
    if ((getKillTaskMethod = TaskManageGrpc.getKillTaskMethod) == null) {
      synchronized (TaskManageGrpc.class) {
        if ((getKillTaskMethod = TaskManageGrpc.getKillTaskMethod) == null) {
          TaskManageGrpc.getKillTaskMethod = getKillTaskMethod = 
              io.grpc.MethodDescriptor.<TaskManageProto.KillRequest, TaskManageProto.KillReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.TaskManage", "killTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TaskManageProto.KillRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  TaskManageProto.KillReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TaskManageMethodDescriptorSupplier("killTask"))
                  .build();
          }
        }
     }
     return getKillTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TaskManageStub newStub(io.grpc.Channel channel) {
    return new TaskManageStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TaskManageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TaskManageBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TaskManageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TaskManageFutureStub(channel);
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static abstract class TaskManageImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void listActiveTask(TaskManageProto.ListActiveRequest request,
                               io.grpc.stub.StreamObserver<TaskManageProto.ListActiveReply> responseObserver) {
      asyncUnimplementedUnaryCall(getListActiveTaskMethod(), responseObserver);
    }

    /**
     */
    public void killTask(TaskManageProto.KillRequest request,
                         io.grpc.stub.StreamObserver<TaskManageProto.KillReply> responseObserver) {
      asyncUnimplementedUnaryCall(getKillTaskMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListActiveTaskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                TaskManageProto.ListActiveRequest,
                TaskManageProto.ListActiveReply>(
                  this, METHODID_LIST_ACTIVE_TASK)))
          .addMethod(
            getKillTaskMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                TaskManageProto.KillRequest,
                TaskManageProto.KillReply>(
                  this, METHODID_KILL_TASK)))
          .build();
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskManageStub extends io.grpc.stub.AbstractStub<TaskManageStub> {
    private TaskManageStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskManageStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskManageStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskManageStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void listActiveTask(TaskManageProto.ListActiveRequest request,
                               io.grpc.stub.StreamObserver<TaskManageProto.ListActiveReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListActiveTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void killTask(TaskManageProto.KillRequest request,
                         io.grpc.stub.StreamObserver<TaskManageProto.KillReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getKillTaskMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskManageBlockingStub extends io.grpc.stub.AbstractStub<TaskManageBlockingStub> {
    private TaskManageBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskManageBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskManageBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskManageBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public TaskManageProto.ListActiveReply listActiveTask(TaskManageProto.ListActiveRequest request) {
      return blockingUnaryCall(
          getChannel(), getListActiveTaskMethod(), getCallOptions(), request);
    }

    /**
     */
    public TaskManageProto.KillReply killTask(TaskManageProto.KillRequest request) {
      return blockingUnaryCall(
          getChannel(), getKillTaskMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class TaskManageFutureStub extends io.grpc.stub.AbstractStub<TaskManageFutureStub> {
    private TaskManageFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TaskManageFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TaskManageFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TaskManageFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<TaskManageProto.ListActiveReply> listActiveTask(
        TaskManageProto.ListActiveRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListActiveTaskMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<TaskManageProto.KillReply> killTask(
        TaskManageProto.KillRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getKillTaskMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ACTIVE_TASK = 0;
  private static final int METHODID_KILL_TASK = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TaskManageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TaskManageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ACTIVE_TASK:
          serviceImpl.listActiveTask((TaskManageProto.ListActiveRequest) request,
              (io.grpc.stub.StreamObserver<TaskManageProto.ListActiveReply>) responseObserver);
          break;
        case METHODID_KILL_TASK:
          serviceImpl.killTask((TaskManageProto.KillRequest) request,
              (io.grpc.stub.StreamObserver<TaskManageProto.KillReply>) responseObserver);
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

  private static abstract class TaskManageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TaskManageBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return TaskManageProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TaskManage");
    }
  }

  private static final class TaskManageFileDescriptorSupplier
      extends TaskManageBaseDescriptorSupplier {
    TaskManageFileDescriptorSupplier() {}
  }

  private static final class TaskManageMethodDescriptorSupplier
      extends TaskManageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TaskManageMethodDescriptorSupplier(String methodName) {
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
      synchronized (TaskManageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TaskManageFileDescriptorSupplier())
              .addMethod(getListActiveTaskMethod())
              .addMethod(getKillTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}

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
    comments = "Source: server1.proto")
public final class Server1Grpc {

  private Server1Grpc() {}

  public static final String SERVICE_NAME = "proto.Server1";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xin.qust.platform.proto.Server1Proto.Fun1Request,
      xin.qust.platform.proto.Server1Proto.Fun1Reply> getFun1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fun1",
      requestType = xin.qust.platform.proto.Server1Proto.Fun1Request.class,
      responseType = xin.qust.platform.proto.Server1Proto.Fun1Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xin.qust.platform.proto.Server1Proto.Fun1Request,
      xin.qust.platform.proto.Server1Proto.Fun1Reply> getFun1Method() {
    io.grpc.MethodDescriptor<xin.qust.platform.proto.Server1Proto.Fun1Request, xin.qust.platform.proto.Server1Proto.Fun1Reply> getFun1Method;
    if ((getFun1Method = Server1Grpc.getFun1Method) == null) {
      synchronized (Server1Grpc.class) {
        if ((getFun1Method = Server1Grpc.getFun1Method) == null) {
          Server1Grpc.getFun1Method = getFun1Method = 
              io.grpc.MethodDescriptor.<xin.qust.platform.proto.Server1Proto.Fun1Request, xin.qust.platform.proto.Server1Proto.Fun1Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.Server1", "fun1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.Server1Proto.Fun1Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.Server1Proto.Fun1Reply.getDefaultInstance()))
                  .setSchemaDescriptor(new Server1MethodDescriptorSupplier("fun1"))
                  .build();
          }
        }
     }
     return getFun1Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Server1Stub newStub(io.grpc.Channel channel) {
    return new Server1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Server1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Server1BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Server1FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Server1FutureStub(channel);
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static abstract class Server1ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void fun1(xin.qust.platform.proto.Server1Proto.Fun1Request request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.Server1Proto.Fun1Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getFun1Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFun1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                xin.qust.platform.proto.Server1Proto.Fun1Request,
                xin.qust.platform.proto.Server1Proto.Fun1Reply>(
                  this, METHODID_FUN1)))
          .build();
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class Server1Stub extends io.grpc.stub.AbstractStub<Server1Stub> {
    private Server1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Server1Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Server1Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Server1Stub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void fun1(xin.qust.platform.proto.Server1Proto.Fun1Request request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.Server1Proto.Fun1Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFun1Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class Server1BlockingStub extends io.grpc.stub.AbstractStub<Server1BlockingStub> {
    private Server1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Server1BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Server1BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Server1BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public xin.qust.platform.proto.Server1Proto.Fun1Reply fun1(xin.qust.platform.proto.Server1Proto.Fun1Request request) {
      return blockingUnaryCall(
          getChannel(), getFun1Method(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class Server1FutureStub extends io.grpc.stub.AbstractStub<Server1FutureStub> {
    private Server1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Server1FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Server1FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Server1FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<xin.qust.platform.proto.Server1Proto.Fun1Reply> fun1(
        xin.qust.platform.proto.Server1Proto.Fun1Request request) {
      return futureUnaryCall(
          getChannel().newCall(getFun1Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FUN1 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Server1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Server1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FUN1:
          serviceImpl.fun1((xin.qust.platform.proto.Server1Proto.Fun1Request) request,
              (io.grpc.stub.StreamObserver<xin.qust.platform.proto.Server1Proto.Fun1Reply>) responseObserver);
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

  private static abstract class Server1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Server1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xin.qust.platform.proto.Server1Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Server1");
    }
  }

  private static final class Server1FileDescriptorSupplier
      extends Server1BaseDescriptorSupplier {
    Server1FileDescriptorSupplier() {}
  }

  private static final class Server1MethodDescriptorSupplier
      extends Server1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Server1MethodDescriptorSupplier(String methodName) {
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
      synchronized (Server1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Server1FileDescriptorSupplier())
              .addMethod(getFun1Method())
              .build();
        }
      }
    }
    return result;
  }
}

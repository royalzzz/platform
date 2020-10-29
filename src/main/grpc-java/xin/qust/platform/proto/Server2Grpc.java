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
    comments = "Source: server2.proto")
public final class Server2Grpc {

  private Server2Grpc() {}

  public static final String SERVICE_NAME = "proto.Server2";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xin.qust.platform.proto.Server2Proto.Fun2Request,
      xin.qust.platform.proto.Server2Proto.Fun2Reply> getFun2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "fun2",
      requestType = xin.qust.platform.proto.Server2Proto.Fun2Request.class,
      responseType = xin.qust.platform.proto.Server2Proto.Fun2Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xin.qust.platform.proto.Server2Proto.Fun2Request,
      xin.qust.platform.proto.Server2Proto.Fun2Reply> getFun2Method() {
    io.grpc.MethodDescriptor<xin.qust.platform.proto.Server2Proto.Fun2Request, xin.qust.platform.proto.Server2Proto.Fun2Reply> getFun2Method;
    if ((getFun2Method = Server2Grpc.getFun2Method) == null) {
      synchronized (Server2Grpc.class) {
        if ((getFun2Method = Server2Grpc.getFun2Method) == null) {
          Server2Grpc.getFun2Method = getFun2Method = 
              io.grpc.MethodDescriptor.<xin.qust.platform.proto.Server2Proto.Fun2Request, xin.qust.platform.proto.Server2Proto.Fun2Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.Server2", "fun2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.Server2Proto.Fun2Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.Server2Proto.Fun2Reply.getDefaultInstance()))
                  .setSchemaDescriptor(new Server2MethodDescriptorSupplier("fun2"))
                  .build();
          }
        }
     }
     return getFun2Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Server2Stub newStub(io.grpc.Channel channel) {
    return new Server2Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Server2BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Server2BlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Server2FutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Server2FutureStub(channel);
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static abstract class Server2ImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void fun2(xin.qust.platform.proto.Server2Proto.Fun2Request request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.Server2Proto.Fun2Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getFun2Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getFun2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                xin.qust.platform.proto.Server2Proto.Fun2Request,
                xin.qust.platform.proto.Server2Proto.Fun2Reply>(
                  this, METHODID_FUN2)))
          .build();
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class Server2Stub extends io.grpc.stub.AbstractStub<Server2Stub> {
    private Server2Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private Server2Stub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Server2Stub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Server2Stub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void fun2(xin.qust.platform.proto.Server2Proto.Fun2Request request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.Server2Proto.Fun2Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getFun2Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class Server2BlockingStub extends io.grpc.stub.AbstractStub<Server2BlockingStub> {
    private Server2BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Server2BlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Server2BlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Server2BlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public xin.qust.platform.proto.Server2Proto.Fun2Reply fun2(xin.qust.platform.proto.Server2Proto.Fun2Request request) {
      return blockingUnaryCall(
          getChannel(), getFun2Method(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class Server2FutureStub extends io.grpc.stub.AbstractStub<Server2FutureStub> {
    private Server2FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Server2FutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Server2FutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Server2FutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<xin.qust.platform.proto.Server2Proto.Fun2Reply> fun2(
        xin.qust.platform.proto.Server2Proto.Fun2Request request) {
      return futureUnaryCall(
          getChannel().newCall(getFun2Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_FUN2 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Server2ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Server2ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_FUN2:
          serviceImpl.fun2((xin.qust.platform.proto.Server2Proto.Fun2Request) request,
              (io.grpc.stub.StreamObserver<xin.qust.platform.proto.Server2Proto.Fun2Reply>) responseObserver);
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

  private static abstract class Server2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Server2BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xin.qust.platform.proto.Server2Proto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Server2");
    }
  }

  private static final class Server2FileDescriptorSupplier
      extends Server2BaseDescriptorSupplier {
    Server2FileDescriptorSupplier() {}
  }

  private static final class Server2MethodDescriptorSupplier
      extends Server2BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Server2MethodDescriptorSupplier(String methodName) {
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
      synchronized (Server2Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Server2FileDescriptorSupplier())
              .addMethod(getFun2Method())
              .build();
        }
      }
    }
    return result;
  }
}

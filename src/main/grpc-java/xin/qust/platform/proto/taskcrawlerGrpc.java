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
    comments = "Source: taskcrawler.proto")
public final class taskcrawlerGrpc {

  private taskcrawlerGrpc() {}

  public static final String SERVICE_NAME = "proto.taskcrawler";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request,
      xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply> getCrawler1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "crawler1",
      requestType = xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request.class,
      responseType = xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request,
      xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply> getCrawler1Method() {
    io.grpc.MethodDescriptor<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request, xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply> getCrawler1Method;
    if ((getCrawler1Method = taskcrawlerGrpc.getCrawler1Method) == null) {
      synchronized (taskcrawlerGrpc.class) {
        if ((getCrawler1Method = taskcrawlerGrpc.getCrawler1Method) == null) {
          taskcrawlerGrpc.getCrawler1Method = getCrawler1Method = 
              io.grpc.MethodDescriptor.<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request, xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.taskcrawler", "crawler1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply.getDefaultInstance()))
                  .setSchemaDescriptor(new taskcrawlerMethodDescriptorSupplier("crawler1"))
                  .build();
          }
        }
     }
     return getCrawler1Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static taskcrawlerStub newStub(io.grpc.Channel channel) {
    return new taskcrawlerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static taskcrawlerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new taskcrawlerBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static taskcrawlerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new taskcrawlerFutureStub(channel);
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static abstract class taskcrawlerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void crawler1(xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply> responseObserver) {
      asyncUnimplementedUnaryCall(getCrawler1Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCrawler1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request,
                xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply>(
                  this, METHODID_CRAWLER1)))
          .build();
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class taskcrawlerStub extends io.grpc.stub.AbstractStub<taskcrawlerStub> {
    private taskcrawlerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private taskcrawlerStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected taskcrawlerStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new taskcrawlerStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public void crawler1(xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request request,
        io.grpc.stub.StreamObserver<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCrawler1Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class taskcrawlerBlockingStub extends io.grpc.stub.AbstractStub<taskcrawlerBlockingStub> {
    private taskcrawlerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private taskcrawlerBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected taskcrawlerBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new taskcrawlerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply crawler1(xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request request) {
      return blockingUnaryCall(
          getChannel(), getCrawler1Method(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务端接口类
   * </pre>
   */
  public static final class taskcrawlerFutureStub extends io.grpc.stub.AbstractStub<taskcrawlerFutureStub> {
    private taskcrawlerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private taskcrawlerFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected taskcrawlerFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new taskcrawlerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *服务端接口方法
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply> crawler1(
        xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request request) {
      return futureUnaryCall(
          getChannel().newCall(getCrawler1Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CRAWLER1 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final taskcrawlerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(taskcrawlerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CRAWLER1:
          serviceImpl.crawler1((xin.qust.platform.proto.TaskCrawlerProto.Crawler1Request) request,
              (io.grpc.stub.StreamObserver<xin.qust.platform.proto.TaskCrawlerProto.Crawler1Reply>) responseObserver);
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

  private static abstract class taskcrawlerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    taskcrawlerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return xin.qust.platform.proto.TaskCrawlerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("taskcrawler");
    }
  }

  private static final class taskcrawlerFileDescriptorSupplier
      extends taskcrawlerBaseDescriptorSupplier {
    taskcrawlerFileDescriptorSupplier() {}
  }

  private static final class taskcrawlerMethodDescriptorSupplier
      extends taskcrawlerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    taskcrawlerMethodDescriptorSupplier(String methodName) {
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
      synchronized (taskcrawlerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new taskcrawlerFileDescriptorSupplier())
              .addMethod(getCrawler1Method())
              .build();
        }
      }
    }
    return result;
  }
}

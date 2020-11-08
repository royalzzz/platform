package xin.qust.platform.grpc.proxy;

import xin.qust.platform.grpc.proto.TaskLogGrpc;
import xin.qust.platform.grpc.proto.TaskLogProto.LogReply;
import xin.qust.platform.grpc.proto.TaskLogProto.LogRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.util.HashMap;

public class LogBucket {

	private static final int port = 5002;
	private static HashMap<String, LogHandler> maps = new HashMap<String, LogHandler>();

	public static void startListen() {

		TaskLogGrpc.TaskLogImplBase impl = new TaskLogGrpc.TaskLogImplBase() {

			@Override
			public void collectLog(LogRequest request, StreamObserver<LogReply> responseObserver) {

				String taskId = request.getTaskId();
				String message = request.getMessage();
				
				LogHandler handler = maps.get(taskId);
				
				if (handler != null) {
					handler.handle(message);
				}

				LogReply reply = LogReply.newBuilder().setMessage("").build();
				responseObserver.onNext(reply);
				responseObserver.onCompleted();
			}

		};

		try {
			Server server = ServerBuilder.forPort(port).addService(impl).build().start();
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					// Use stderr here since the logger may have been reset by
					// its JVM shutdown hook.
					if (server != null) {
						server.shutdown();
					}
				}
			});
			System.out.println("Start collect task log at port: "+port);
			if (server != null) {
				server.awaitTermination();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

	public static void addListener(String taskId, LogHandler handler) {
		LogBucket.maps.put(taskId, handler);
	}

	public static void removeListener(String taskId) {
		LogBucket.maps.remove(taskId);
	}


}
